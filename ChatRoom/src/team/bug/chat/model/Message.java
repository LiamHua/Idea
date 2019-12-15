package team.bug.chat.model;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import team.bug.chat.itemUtils.AlertDialog;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Message {

    public static void sentmessage(String address,String msg){
        try {
            Socket socket = new Socket(address, 9998);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("msg");
            out.writeUTF(User.nickName + ": " + msg);
            out.flush();
            out.close();

            /*PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connect succeed!");
            writer.println("大哥："+msg);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Thread receivemessage(ObservableList<String> list){
        Thread thread = new Thread(() -> {
            try {
                ServerSocket server = new ServerSocket(9998);
                System.out.println("socket creat succeed!");

                while (true) {
                    System.out.println("Waiting...");
                    Socket socket = server.accept();
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    String type = in.readUTF();  //第一个读取的字段为消息类型
                    if (type.equals("msg")){
                        Platform.runLater(() -> {
                            try {
                                list.add(in.readUTF());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }else if (type.equals("file")){
                        boolean flag = AlertDialog.FileConfirmationDialog();
                        if (flag){
                            String name = in.readUTF();//文件名
                            long length = in.readLong();  //长度
                            byte[] bytes = new byte[(int) length];
                            for (int i=0;i<length;i++){
                                bytes[i] = in.readByte();
                            }
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    String savePath = FileStream.saveFile();
                                    String filePath = savePath + "/"+name;
                                    try {
                                        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                                        fileOutputStream.write(bytes);
                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }else {

                        }
                    }


                       /* BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String text = reader.readLine();
                        while (text != null) {
                            Platform.runLater(() -> {
                                list.add(text);
                            });
                            break;
                        }*/
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return thread;
    }
}

