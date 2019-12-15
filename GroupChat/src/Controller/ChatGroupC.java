package Controller;

import Model.CloseUtil;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatGroupC implements Initializable {
    public Button bt_send;
    public TextField tf_send;
    public TextField tf_receive;
    private Socket socket = null;

    public void onClick_send(ActionEvent actionEvent) {
            String name = null;
            DataOutputStream dos = null;
            boolean isRunning = true;
            try {
                dos = new DataOutputStream(socket.getOutputStream());
                name = InetAddress.getLocalHost().getHostAddress();
            } catch (IOException e) {
                e.printStackTrace();
//                isRunning = false;
                CloseUtil.closeAll(dos);
            }

                String message = tf_send.getText();
                try {
                    dos.writeUTF(name + ":" + message);
                } catch (IOException e) {
                    e.printStackTrace();
//                    CloseUtil.closeAll(dos);
                }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket("192.168.43.117", 8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            DataInputStream dis = null;
            boolean isRunning = true;
            try {
                ServerSocket serverSocket = new ServerSocket(8888);
                Socket accept = serverSocket.accept();
                System.out.println("kjkjk");
                dis = new DataInputStream(accept.getInputStream());
                System.out.println("11122222");
            } catch (IOException e) {
                e.printStackTrace();
                isRunning = false;
//                CloseUtil.closeAll(dis);
            }
            while (isRunning) {
                try {
                    String message = dis.readUTF();
                    tf_receive.setText(tf_receive.getText()+message);
                    System.out.println("成功收到消息");
                } catch (IOException e) {
                    e.printStackTrace();
                    isRunning = false;
                    CloseUtil.closeAll(dis);
                }
            }
        }).start();
    }
}