package team.bug.chat.teamchat.Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * @author liam
 * @date 19-12-21 上午2:01
 */
public class TeamChat {
    public void teamChat() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(Client.class.getResource("/team/bug/chat/teamchat/View/ChatGroup.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
