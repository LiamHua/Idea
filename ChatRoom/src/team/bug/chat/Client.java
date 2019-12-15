package team.bug.chat;

import javafx.application.Application;
import javafx.stage.Stage;
import team.bug.chat.itemUtils.StageManage;
import java.io.IOException;

/**
 * @author liam
 */
public class Client extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        StageManage stageManage = new StageManage();
        stageManage.createNewStage("Login.fxml","登录");
    }
}
