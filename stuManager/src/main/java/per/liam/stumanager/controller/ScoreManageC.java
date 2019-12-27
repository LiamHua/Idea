package per.liam.stumanager.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import per.liam.stumanager.model.Change;
import per.liam.stumanager.model.ScoreFrameInit;
import per.liam.stumanager.utils.AlertDialog;
import per.liam.stumanager.utils.Score;
import per.liam.stumanager.utils.TemporaryStu;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author liam
 * @date 19-12-19 下午6:59
 */
public class ScoreManageC implements Initializable {
    @FXML
    private TableView<Score> scoreTable;
    @FXML
    private TableColumn<Score, Integer> serialCol;
    @FXML
    private TableColumn<Score, String> timeCol;
    @FXML
    private TableColumn<Score, String> cnoCol;
    @FXML
    private TableColumn<Score, String> nameCol;
    @FXML
    private TableColumn<Score, Integer> firstScoreCol;
    @FXML
    private TableColumn<Score, Integer> secondScoreCol;
    @FXML
    private TextField serial;
    @FXML
    private TextField time;
    @FXML
    private TextField cno;
    @FXML
    private TextField courseName;
    @FXML
    private TextField firstScore;
    @FXML
    private TextField secondScore;
    @FXML
    private Button modify;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        serialCol.setCellValueFactory(new PropertyValueFactory<>("serialNo"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        cnoCol.setCellValueFactory(new PropertyValueFactory<>("cno"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        firstScoreCol.setCellValueFactory(new PropertyValueFactory<>("firstScore"));
        secondScoreCol.setCellValueFactory(new PropertyValueFactory<>("secondScore"));
        scoreTable.setItems(ScoreFrameInit.scores);
        ScoreFrameInit scoreFrameInit = new ScoreFrameInit();
        scoreFrameInit.setCourses();
    }

    @FXML
    public void onClickModify() {
        Score score = new Score(1, TemporaryStu.getStudent().getSno(), cno.getText(), courseName.getText(),
                time.getText(), Integer.parseInt(firstScore.getText()), Integer.parseInt(secondScore.getText()));
        System.out.println(score);
        Change change = new Change();
        int i = change.changeScoreInfo(score);
        if (i == 1){
            new AlertDialog().correctInformationDialog("修改成功！");
        }else {
            new AlertDialog().errorInformationDialog("修改失败！");
        }
    }

    @FXML
    public void onClickScoreTable() {
        Score selectedItem = scoreTable.getSelectionModel().getSelectedItem();
        time.setText(selectedItem.getTime());
        cno.setText(selectedItem.getCno());
        courseName.setText(selectedItem.getName());
        firstScore.setText((selectedItem.getFirstScore()) + "");
        secondScore.setText(selectedItem.getSecondScore() + "");
    }
}
