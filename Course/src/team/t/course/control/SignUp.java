package team.t.course.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import team.t.course.web.MyServiceImplService;
import team.t.course.web.MyServiceImplService_Service;

import java.io.IOException;

public class SignUp {
    public Button bt_signup;
    public TextField username_reg;
    public TextField password_reg;

    public void onclick_signup(ActionEvent actionEvent) throws IOException {
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        int regReturn = service.addUser(username_reg.getText(), password_reg.getText());

        if (regReturn != 2){
            System.out.println("注册失败");
        }else{
            Stage Student = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/team/t/course/view/Login.fxml"));
            Scene scene = new Scene(root, 600, 400);
            Student.setScene(scene);
            Student.setTitle("Login");
            Student.show();
            Stage current =(Stage)bt_signup.getScene().getWindow();
            current.close();
        }
    }
}
