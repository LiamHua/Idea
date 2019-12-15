package Model;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private List<ClientHandle> list = new ArrayList<>();

    public static void main(String[] args) {
        new Server().connect();
    }

    public void connect() {
        try {
            serverSocket = new ServerSocket(8888);
            while (true) {
                socket = serverSocket.accept();
                System.out.println("客户端已连接");
                ClientHandle clientHandle = new ClientHandle(socket);
                list.add(clientHandle);
                new Thread(clientHandle).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("端口占用");
        }
    }

    class ClientHandle implements Runnable {
        private DataOutputStream dos = null;
        private DataInputStream dis = null;
        private boolean isRunning = true;

        ClientHandle(Socket socket) {
            try {
                dos = new DataOutputStream(socket.getOutputStream());
                dis = new DataInputStream(socket.getInputStream());
                System.out.println("初始化完成");//
            } catch (IOException e) {
                e.printStackTrace();
                isRunning = false;
            }
        }
        @Override
        public void run() {
            while (isRunning) {
                String message = null;
                try {
                    message = dis.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("用户下线");
                    list.remove(this);
//                    CloseUtil.closeAll(socket);
                }
                for (ClientHandle clientHandle : list) {
                    if (clientHandle != this) {
                        try {
                            dos.writeUTF(message);
                            dos.flush();

                            System.out.println("遍历");

                        } catch (IOException e) {
                            e.printStackTrace();
                            isRunning = false;
                            list.remove(this);
//                            CloseUtil.closeAll(socket);
                        }
                    }
                }
            }
        }
    }
}