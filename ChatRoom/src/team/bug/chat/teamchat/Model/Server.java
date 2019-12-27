package Model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private  List<ClientHandle> list = new ArrayList<>();

    public static void main(String[] args) {
        new Server().connect();
    }

    public  void connect() {
        try{
            serverSocket = new ServerSocket(8888);
            while(true) {
                socket = serverSocket.accept();
                System.out.println("一个客户端连接上来了");
                ClientHandle clientHandle = new ClientHandle(socket);
                list.add(clientHandle);
                new Thread(clientHandle).start();
            }
        } catch(BindException e) {
            System.out.println("端口已被占用");
        } catch(Exception e) {
            e.printStackTrace();
            CloseUtil.closeall(serverSocket);
        }
    }

    class ClientHandle implements Runnable {
        private DataOutputStream dos = null;
        private DataInputStream dis = null;
        private boolean isRunning= true;

        public ClientHandle(Socket socket) {
            try {
                dos = new DataOutputStream(socket.getOutputStream());
                dis = new DataInputStream(socket.getInputStream());
            } catch (Exception e) {
                e.printStackTrace();
                isRunning = false;
                CloseUtil.closeall(dos, dis);
            }
        }
        @Override
        public void run() {
            while(isRunning) {
                sendOthers();
            }
        }
        public String  receive() {
            String message = "";
            try {

                /*dis.readUTF();
                dis.readUTF();*/
                message = dis.readUTF();
                System.out.println(message);
            } catch(EOFException e) {
                System.out.println("一个用户退出");
                isRunning = false;
                CloseUtil.closeall(dos, dis);
                list.remove(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return message;
        }
        public void sendOthers() {
            String msg = receive();
            for (ClientHandle clientHandle : list) {
                if (clientHandle == this) {
                    continue;
                }
                clientHandle.send(msg);
            }
        }
        public void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch(Exception e) {
                e.printStackTrace();
                isRunning = false;
                CloseUtil.closeall(dos, dis);
                list.remove(this);
            }
        }
    }
}