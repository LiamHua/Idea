package team.t.course.control;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import team.t.course.web.MyServiceImplService;
import team.t.course.web.MyServiceImplService_Service;


import java.io.IOException;

public class Login extends Application {

    @FXML
    public Button bt_adminLogin;
    public Button bt_signUp;
    public Button bt_login;
    public TextField username;
    public TextField password;

    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/team/t/course/view/Login.fxml"));
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();
    }

    public void onClick_login(ActionEvent actionEvent) throws IOException {
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        int loginReturn = service.verifyUserInfo(username.getText(), password.getText());

        if (loginReturn != 3){
            System.out.println("密码错误");
        }else{
            Stage Student = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/team/t/course/view/Student.fxml"));
            Scene scene = new Scene(root, 1000, 500);
            Student.setScene(scene);
            Student.setTitle("Student");
            Student.show();
            Stage current =(Stage)bt_login.getScene().getWindow();
            current.close();
        }
    }

    public void onClick_adminLogin(ActionEvent actionEvent) throws IOException {
        Stage adminLogin = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/team/t/course/view/AdminLogin.fxml"));
        Scene scene = new Scene(root, 600, 400);
        adminLogin.setScene(scene);
        adminLogin.setTitle("AdminLogin");
        adminLogin.show();
        Stage current =(Stage)bt_adminLogin.getScene().getWindow();
        current.close();
    }

    public void onClick_signUp(ActionEvent actionEvent) throws IOException {
        Stage signUp = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/team/t/course/view/SignUp.fxml"));
        Scene scene = new Scene(root, 600, 400);
        signUp.setScene(scene);
        signUp.setTitle("SignUp");
        signUp.show();
        Stage current =(Stage)bt_signUp.getScene().getWindow();
        current.close();
    }
}
