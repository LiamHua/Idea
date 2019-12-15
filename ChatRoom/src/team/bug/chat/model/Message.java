package team.bug.chat.model;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import team.bug.chat.Info.CurrentChatObj;
import team.bug.chat.Info.Friend;
import team.bug.chat.Info.recordMsg;
import team.bug.chat.itemUtils.AlertDialog;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liam
 */
public class Message {
    public void sentMessage(String msg) {
        try {
            Friend friend = MyInfo.friendMap.get(CurrentChatObj.username);
            if (!recordMsg.isExist(friend)) {
                ObservableList<String> msgList = FXCollections.observableArrayList();
                recordMsg.addMsgList(friend, msgList);
            }
            recordMsg.getMsgList(friend).add(MyInfo.nickName + ": " + msg);
            Socket socket = new Socket(CurrentChatObj.address, 9998);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(MyInfo.username);
            out.writeUTF("msg");
            out.writeUTF(MyInfo.nickName + ": " + msg);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Thread receiveMessage() {
        return new Thread(() -> {
            try {
                ServerSocket server = new ServerSocket(9998);
                System.out.println("socket creat succeed!");
                while (true) {
                    System.out.println("Waiting...");
                    Socket socket = server.accept();
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    // 第一个读取的字段为消息发送者
                    String username = in.readUTF();
                    // 第二个读取的字段为消息类型
                    String type = in.readUTF();
                    if ("msg".equals(type)) {
                        Platform.runLater(() -> {
                            try {
                                Friend friend = MyInfo.friendMap.get(username);
                                if (!recordMsg.isExist(friend)) {
                                    ObservableList<String> msg = FXCollections.observableArrayList();
                                    recordMsg.addMsgList(friend, msg);
                                }
                                recordMsg.getMsgList(friend).add(in.readUTF());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    } else if ("file".equals(type)) {
                        AlertDialog alertDialog = new AlertDialog();
                        boolean flag = alertDialog.fileConfirmationDialog();
                        System.out.println(flag);

                        if (flag) {
                            // 文件名
                            String name = in.readUTF();
                            // 长度
                            long length = in.readLong();
                            byte[] bytes = new byte[(int) length];
                            for (int i = 0; i < length; i++) {
                                bytes[i] = in.readByte();
                            }
                            Platform.runLater(() -> {
                                FileStream fileStream = new FileStream();
                                String savePath = fileStream.saveFile();
                                String filePath = savePath + "/" + name;
                                try {
                                    FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                                    fileOutputStream.write(bytes);
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                        } else {
                            //TODO 什么都不用干了
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
    }
}

