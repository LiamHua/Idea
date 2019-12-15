package team.bug.chat.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import team.bug.chat.itemUtils.AlertDialog;
import team.bug.chat.itemUtils.StageManage;
import team.bug.chat.model.Sign;
import team.bug.chat.model.MyInfo;

import javax.xml.ws.WebServiceException;
import java.io.IOException;

/**
 * @author liam
 */
public class LoginC {
    @FXML
    private Button bt_login;
    @FXML
    private Button bt_signUp;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    @FXML
    public void onClick_login(ActionEvent actionEvent) throws IOException {
        Sign sign = new Sign();
        AlertDialog alertDialog = new AlertDialog();
        try{
            int loginReturn = sign.signIn(username.getText(), password.getText());
            if (loginReturn == 0) {
                alertDialog.errorInformationDialog("服务器异常，请联系管理员！");
            } else if (loginReturn == 1){
                alertDialog.errorInformationDialog("该用户不存在,请重新输入！");
            }else if (loginReturn == 2){
                alertDialog.errorInformationDialog("密码错误，请重新输入!");
            } else if (loginReturn == 3){
                MyInfo.username = username.getText();
                MyInfo.setInfo();
                StageManage stageManage = new StageManage();
                stageManage.createNewStage("Chat.fxml", "Chat");
                stageManage.closeCurrentStage(bt_login);
            }
        }catch (WebServiceException e){
            alertDialog.errorInformationDialog("无法连接服务器，请联系管理员！");
        }
    }

    @FXML
    public void onClick_signUp() throws IOException {
        StageManage stageManage = new StageManage();
        stageManage.createNewStage("SignUp.fxml", "注册");
        stageManage.closeCurrentStage(bt_signUp);
    }
}