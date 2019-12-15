package team.bug.chat.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import team.bug.chat.itemUtils.AlertDialog;
import team.bug.chat.model.FriendManage;
import team.bug.chat.model.MyInfo;
import java.util.List;

/**
 * @author liam
 */
public class AddFriendC {

    @FXML
    private Pane search_succeed;
    @FXML
    private Pane search_failed;
    @FXML
    private TextField search_username;
    @FXML
    private TextField result_friend;

    public void onClick_searchFriend() {
        FriendManage friendManage = new FriendManage();
        List<String> friend = friendManage.searchFriend(search_username.getText());
        if (friend == null) {
            search_succeed.setVisible(false);
            search_failed.setVisible(true);
        } else {
            search_failed.setVisible(false);
            search_succeed.setVisible(true);
            FriendManage.username = friend.get(1);
            result_friend.setText(friend.get(0));
        }
    }

    public void onClick_addFriend() {
        AlertDialog alertDialog = new AlertDialog();
        if (FriendManage.username.equals(MyInfo.username)){
            alertDialog.errorInformationDialog("你想要上天吗？");
        }else {
            FriendManage friendManage = new FriendManage();
            int i = friendManage.addFriend(FriendManage.username);
            if (i == 1) {
                alertDialog.errorInformationDialog("该用户已经是您的好友！");
            } else if (i == 2) {
                alertDialog.correctInformationDialog("已发送添加请求！");
            }
        }
    }
}
