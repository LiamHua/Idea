package Controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatGroupC implements Initializable {
    public Button bt_send;
    public TextField tf_send;
    public ListView LV_receive;
    private Socket socket = null;
    private ObservableList<String> list= FXCollections.observableArrayList();

    public void onClick_send(ActionEvent actionEvent) {
        String name=null;
        DataOutputStream dos=null;
        boolean isRunning=true;
        try {
            dos=new DataOutputStream(socket.getOutputStream());
            name=InetAddress.getLocalHost().getHostAddress();
        } catch (IOException e) {
            e.printStackTrace();
            isRunning=false;
        }
        if(isRunning)
        {
            String message=tf_send.getText();
            try {
                dos.writeUTF(name+":"+message);
                tf_send.setText(null);
                list.add(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void send_ENTER(KeyEvent keyEvent) {
        if(keyEvent.getCode()== KeyCode.ENTER)
        {
            String name=null;
            DataOutputStream dos=null;
            boolean isRunning=true;
            try {
                dos=new DataOutputStream(socket.getOutputStream());
                name=InetAddress.getLocalHost().getHostAddress();
            } catch (IOException e) {
                e.printStackTrace();
                isRunning=false;
            }
            if(isRunning)
            {
                String message=tf_send.getText();
                try {
                    dos.writeUTF(name+":"+message);
                    tf_send.setText(null);
                    list.add(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket("localhost", 8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(new Receive(socket)).start();
    }

    class Receive implements Runnable{
    private DataInputStream dis=null;
    private boolean isRunning=true;

    public Receive(Socket socket) {
        try {
            dis=new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            isRunning=false;
        }
    }
    public void receive(){
        try {
            String message=dis.readUTF();
            Platform.runLater(()->{
                list.add(message);
            });

        } catch (IOException e) {
            e.printStackTrace();
            isRunning=false;
        }
    }
    @Override
    public void run() {
        LV_receive.setItems(list);
        while (isRunning)
        {
            receive();
        }
    }
}
}