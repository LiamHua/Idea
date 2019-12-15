package team.bug.chat.itemUtils;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liam
 */
public class AlertDialog {
    public void errorInformationDialog(String tip){
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("错误");
            alert.setHeaderText(null);
            alert.setContentText(tip);
            alert.showAndWait();
        });
    }

    public void correctInformationDialog(String tip){
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successful!");
            alert.setHeaderText(null);
            alert.setContentText(tip);
            alert.showAndWait();
        });
    }

    public boolean fileConfirmationDialog(){
        FutureTask<Boolean> dialog = new FutureTask<>(new Callable<Boolean>() {
            Boolean flag;
            @Override
            public Boolean call() {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("接收文件");
                alert.setHeaderText("您的好友向您发送一个文件...");
                alert.setContentText("请确认是否接收？");
                Optional<ButtonType> result = alert.showAndWait();
                flag = result.get() == ButtonType.OK;
                return flag;
            }
        });
        Boolean flag = null;
        try {
            //Platform.runLater() 不会阻塞线程
            Platform.runLater(dialog);
            flag = dialog.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delConfirmationDialog(){
        FutureTask<Boolean> dialog = new FutureTask<>(new Callable<Boolean>() {
            Boolean flag;
            @Override
            public Boolean call() {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("删除好友");
                alert.setHeaderText("您将要删除一个好友...");
                alert.setContentText("请确认是否删除？");
                Optional<ButtonType> result = alert.showAndWait();
                flag = result.get() == ButtonType.OK;
                return flag;
            }
        });

        Boolean flag = null;
        try {
            Platform.runLater(dialog);
            flag = dialog.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean friendConfirmationDialog(String nickname){
        FutureTask<Boolean> dialog = new FutureTask<>(new Callable<Boolean>() {
            Boolean flag;
            @Override
            public Boolean call() {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("通知");
                alert.setHeaderText(nickname + " 想要添加您为好友...");
                alert.setContentText("请确认是否同意？");
                Optional<ButtonType> result = alert.showAndWait();
                flag = result.get() == ButtonType.OK;
                return flag;
            }
        });
        Boolean flag = null;
        try {
            Platform.runLater(dialog);
            flag = dialog.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
