package per.liam.stumanager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import per.liam.stumanager.model.Change;
import per.liam.stumanager.model.ScoreFrameInit;
import per.liam.stumanager.utils.AlertDialog;
import per.liam.stumanager.utils.Course;
import per.liam.stumanager.utils.TemporaryStu;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author liam
 * @date 19-12-19 下午6:59
 */
public class ScoreC implements Initializable {
    @FXML
    private TableView<Course> scoreTable;
    @FXML
    private TableColumn<Course, Integer> serialCol;
    @FXML
    private TableColumn<Course, String> timeCol;
    @FXML
    private TableColumn<Course, String> cnoCol;
    @FXML
    private TableColumn<Course, String> nameCol;
    @FXML
    private TableColumn<Course, Integer> firstScoreCol;
    @FXML
    private TableColumn<Course, Integer> secondScoreCol;
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
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        cnoCol.setCellValueFactory(new PropertyValueFactory<>("cno"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        firstScoreCol.setCellValueFactory(new PropertyValueFactory<>("firstScore"));
        secondScoreCol.setCellValueFactory(new PropertyValueFactory<>("secondScore"));
        scoreTable.setItems(ScoreFrameInit.courses);
        ScoreFrameInit scoreFrameInit = new ScoreFrameInit();
        scoreFrameInit.setCourses();
    }

    @FXML
    public void onClickModify() {
        Course course = new Course(TemporaryStu.getStudent().getSno(), cno.getText(), courseName.getText(), time.getText(),
                Integer.parseInt(firstScore.getText()), Integer.parseInt(secondScore.getText()));
        System.out.println(course);
        Change change = new Change();
        int i = change.changeScoreInfo(course);
        if (i == 1){
            new AlertDialog().correctInformationDialog("修改成功！");
        }else {
            new AlertDialog().errorInformationDialog("修改失败！");
        }
    }

    public void insertStu() {

    }

    public void delStu() {

    }

    @FXML
    public void onClickScoreTable() {
        Course selectedItem = scoreTable.getSelectionModel().getSelectedItem();
        time.setText(selectedItem.getTime());
        cno.setText(selectedItem.getCno());
        firstScore.setText((selectedItem.getFirstScore()) + "");
        secondScore.setText(selectedItem.getSecondScore() + "");
    }
}
