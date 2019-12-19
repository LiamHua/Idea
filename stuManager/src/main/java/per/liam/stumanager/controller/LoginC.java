package per.liam.stumanager.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import per.liam.stumanager.model.Login;
import per.liam.stumanager.utils.AlertDialog;
import per.liam.stumanager.utils.StageManage;

import javax.xml.ws.WebServiceException;
import java.io.IOException;

/**
 * @author liam
 * @date 19-12-18 下午2:53
 */
public class LoginC {

    public TextField username;
    public TextField password;
    public Button login;

    public void onClickLogin() {
        Login login = new Login();
        AlertDialog alertDialog = new AlertDialog();
        try{
            int loginReturn = login.login(username.getText(), password.getText());
            if (loginReturn == 0) {
                alertDialog.errorInformationDialog("服务器异常，请联系管理员！");
            } else if (loginReturn == 1){
                alertDialog.errorInformationDialog("该用户不存在,请重新输入！");
            }else if (loginReturn == 2){
                alertDialog.errorInformationDialog("密码错误，请重新输入!");
            } else if (loginReturn == 3){
                StageManage stageManage = new StageManage();
                stageManage.createNewStage("MainFrame.fxml", "学籍管理系统");
                stageManage.closeCurrentStage(this.login);
            }
        }catch (WebServiceException | IOException e){
            alertDialog.errorInformationDialog("无法连接服务器，请联系管理员！");
        }
    }
}
