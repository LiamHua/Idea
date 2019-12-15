package team.bug.chat.controller;

import javafx.application.Platform;
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
import team.bug.chat.itemUtils.AlertDialog;
import team.bug.chat.itemUtils.StageManage;
import team.bug.chat.model.FileStream;
import team.bug.chat.model.FriendManage;
import team.bug.chat.model.Message;
import team.bug.chat.model.MyInfo;
import team.bug.chat.model.refreshIP;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author liam
 */
public class ChatC implements Initializable {
    @FXML
    private Button bt_notice;
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
        friendList.setItems(flist);
        Message message = new Message();
        Thread receivemessage = message.receiveMessage();
        receivemessage.start();

        new Thread(() -> {
            while (true) {
                Platform.runLater(() -> {
                    MyInfo.getFriends(flist);
                });
                FriendManage friendManage = new FriendManage();
                ArrayList<String> friend = friendManage.checkFriend();
                int num = friend.size();
                if (num != 0) {
                    Platform.runLater(() -> {
                        bt_notice.setStyle("-fx-background-color: RED");
                    });
                }else {
                    bt_notice.setStyle("-fx-background-color: WHITE");
                }
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }

    @FXML
    public void btsent_onclick() {
        Message message = new Message();
        message.sentMessage(Text_sent.getText());
        list.add(MyInfo.nickName + ": " + Text_sent.getText());
        Text_sent.setText("");
    }

    @FXML
    public void sent_ENTER(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
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
        if (file != null) {
            FileStream fileStream = new FileStream();
            fileStream.sentFile(file, fileName);
        } else {
            //Stage stage = (Stage) bt_sentFile.getScene().getWindow();
            System.out.println("空文件");
        }
    }

    @FXML
    public void onClick_fList() {
        chatPane.setVisible(true);
        Friend friend = friendList.getSelectionModel().getSelectedItem();
        friend.address = refreshIP.refreshIP(friend.username);
        CurrentChatObj.isCurrentChatObj(friend);
        if (!recordMsg.isExist(friend)) {
            ObservableList<String> msg = FXCollections.observableArrayList();
            recordMsg.addMsgList(friend, msg);
            msgList.setItems(recordMsg.getMsgList(friend));
        } else {
            msgList.setItems(recordMsg.getMsgList(friend));
        }
    }

    public void onClick_addFriend() throws IOException {
        StageManage stageManage = new StageManage();
        stageManage.createNewStage("addFriend.fxml", "找朋友");
    }

    @FXML
    public void onClick_delFriend() {
        Thread thread = new Thread(() -> {
            AlertDialog alertDialog = new AlertDialog();
            boolean flag = alertDialog.delConfirmationDialog();
            if (flag) {
                FriendManage friendManage = new FriendManage();
                int i = friendManage.delFriend(CurrentChatObj.username);
                if (i != 1) {
                    alertDialog.errorInformationDialog("服务器异常，请联系管理员！");
                } else if (i == 1) {
                    Platform.runLater(() -> flist.remove(friendList.getSelectionModel().getSelectedItem()));
                }
            }
        });
        thread.start();
        bt_notice.setStyle("-fx-background-color: null");
    }

    public void onClick_notice() {
        FriendManage friendManage = new FriendManage();
        ArrayList<String> friend = friendManage.checkFriend();
        int num = friend.size();
        int i = 0;
        if (num != 0) {
            do {
                int finalI = i;
                Thread thread = new Thread(() -> {
                    AlertDialog alertDialog = new AlertDialog();
                    boolean flag = alertDialog.friendConfirmationDialog(friend.get(finalI));
                    if (flag) {
                        ArrayList<String> list = new ArrayList<>();
                        list.add(friend.get(finalI));
                        list.add(friend.get(finalI + 1));
                        list.add(friend.get(finalI + 2));
                        friendManage.confirm(list);
                        flist.add(new Friend(friend.get(finalI), friend.get(finalI + 1), friend.get(finalI + 2)));
                    }
                });
                thread.start();
                num -= 3;
                i += 3;
            } while (num > 0);
        } else {
            AlertDialog alertDialog = new AlertDialog();
            alertDialog.correctInformationDialog("暂时没有通知哦！");
        }
    }
}
