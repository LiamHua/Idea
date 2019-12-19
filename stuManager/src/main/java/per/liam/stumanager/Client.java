package per.liam.stumanager;

import javafx.application.Application;
import javafx.stage.Stage;
import per.liam.stumanager.utils.StageManage;

/**
 * @author liam
 * @date 19-12-18 下午4:30
 */
public class Client extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        StageManage stageManage = new StageManage();
        stageManage.createNewStage("LoginFrame.fxml","登录");
    }
}
