package per.liam.stumanager.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * @author liam
 * @date 19-12-18 下午4:20
 */
public class StageManage {
    public void createNewStage(String fxml, String title) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(StageManage.class.getResource("/view/" +fxml));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    public void closeCurrentStage(Button bt){
        javafx.stage.Stage current =(javafx.stage.Stage)bt.getScene().getWindow();
        current.close();
    }
}
