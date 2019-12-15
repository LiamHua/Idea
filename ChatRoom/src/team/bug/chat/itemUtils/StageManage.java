package team.bug.chat.itemUtils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class Stage {

    public static void createnewstage(String fxml,String title) throws IOException {
        javafx.stage.Stage signUp = new javafx.stage.Stage();
        Parent root = FXMLLoader.load(Stage.class.getResource("/team/bug/chat/view/"+fxml));
        Scene scene = new Scene(root, 600, 400);
        signUp.setScene(scene);
        signUp.setTitle(title);
        signUp.show();
    }

    public static void closecurrentstage(Button bt){
        javafx.stage.Stage current =(javafx.stage.Stage)bt.getScene().getWindow();
        current.close();
    }
}
