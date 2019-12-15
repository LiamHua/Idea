package team.bug.chat.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import team.bug.chat.Info.CurrentChatObj;
import team.bug.chat.Info.Friend;
import team.bug.chat.Info.recordMsg;
import team.bug.chat.model.FileStream;
import team.bug.chat.model.Message;
import team.bug.chat.model.MyInfo;
import team.bug.chat.model.RefreshIP;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Chat implements Initializable {
    @FXML
    private Pane chatPane;
    @FXML
    private Label welcome;
    @FXML
    private ListView<Friend> friendList;
    @FXML
    private Button bt_sentFile;
    @FXML
    private ListView<String> msgList;
    @FXML
    private Button bt_receive;
    @FXML
    private Button bt_sent;
    @FXML
    private TextField Text_sent;

    private ObservableList<String> list = FXCollections.observableArrayList();
    private ObservableList<Friend> flist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        welcome.setText("欢迎您，" + MyInfo.nickName);
        chatPane.setVisible(false);
        //msgList.setItems(list);
        friendList.setItems(flist);
        MyInfo.getFriends(flist);
        Message message = new Message();
        Thread receivemessage = message.receiveMessage();
        receivemessage.start();
    }

    @FXML
    public void btsent_onclick() {
        Message message = new Message();
        message.sentMessage(Text_sent.getText());
        list.add(MyInfo.nickName+": " +Text_sent.getText());
        Text_sent.setText("");
    }

    @FXML
    public void sent_ENTER(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            Message message = new Message();
            message.sentMessage(Text_sent.getText());
            list.add(MyInfo.nickName + ": " + Text_sent.getText());
            Text_sent.setText("");
        }
    }

    @FXML
    public void onClick_sentFile() throws IOException {
        Stage fileStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(fileStage);
        String fileName = file.getName();
        if (file != null){
            FileStream fileStream = new FileStream();
            fileStream.sentFile(file,fileName);
        }else {
            //Stage stage = (Stage) bt_sentFile.getScene().getWindow();
            System.out.println("空文件");
        }
    }

    @FXML
    public void onClick_fList() {
        chatPane.setVisible(true);
        Friend friend = friendList.getSelectionModel().getSelectedItem();
        friend.address = RefreshIP.refreshIP(friend.username);
        CurrentChatObj.isCurrentChatObj(friend);
        if (!recordMsg.isExist(friend)){
            ObservableList<String> msg = FXCollections.observableArrayList();
            recordMsg.addMsgList(friend,msg);
        }else {
            msgList.setItems(recordMsg.getMsgList(friend));
        }
    }
}
