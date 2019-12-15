package team.t.course.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Student {
    public Button bt_addCourse;

    public void onClick_addCourse(ActionEvent actionEvent) throws IOException {
        Stage addCourse = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/team/t/course/view/AddCourse.fxml"));
        Scene scene = new Scene(root, 800, 500);
        addCourse.setScene(scene);
        addCourse.setTitle("AddCourse");
        addCourse.show();
        Stage current =(Stage)bt_addCourse.getScene().getWindow();
        current.close();
    }
}
