package per.liam.stumanager.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import per.liam.stumanager.model.MainFrameInit;
import per.liam.stumanager.model.Search;
import per.liam.stumanager.utils.SearchCondition;
import per.liam.stumanager.utils.StageManage;
import per.liam.stumanager.utils.Student;
import per.liam.stumanager.utils.TemporaryStu;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author liam
 * @date 19-12-18 下午4:22
 */
public class MainC implements Initializable {
    @FXML
    private Menu menu;
    @FXML
    private Menu help;
    @FXML
    private TextField sno;
    @FXML
    private TextField name;
    @FXML
    private ComboBox<String> sexChoice;
    @FXML
    private ComboBox<String> instituteChoice;
    @FXML
    private ComboBox<String> majorChoice;
    @FXML
    private ComboBox<String> startYearChoice;
    @FXML
    private Button search;
    @FXML
    private TableView<Student> stuTable;
    @FXML
    private TableColumn<Student, String> snoCol;
    @FXML
    private TableColumn<Student, String> nameCol;
    @FXML
    private TableColumn<Student, String> sexCol;
    @FXML
    private TableColumn<Student, String> telCol;
    @FXML
    private TableColumn<Student, String> birthdayCol;
    @FXML
    private TableColumn<Student, String> addressCol;
    @FXML
    private TableColumn<Student, String> instituteCol;
    @FXML
    private TableColumn<Student, String> majorCol;
    @FXML
    private TableColumn<Student, String> startYearCol;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        snoCol.setCellValueFactory(cellDate -> cellDate.getValue().snoProperty());
        nameCol.setCellValueFactory(cellDate -> cellDate.getValue().nameProperty());
        sexCol.setCellValueFactory(cellDate -> cellDate.getValue().sexProperty());
        telCol.setCellValueFactory(cellDate -> cellDate.getValue().telProperty());
        birthdayCol.setCellValueFactory(cellDate -> cellDate.getValue().birthdayProperty());
        addressCol.setCellValueFactory(cellDate -> cellDate.getValue().addressProperty());
        instituteCol.setCellValueFactory(cellDate -> cellDate.getValue().instituteProperty());
        majorCol.setCellValueFactory(cellDate -> cellDate.getValue().majorProperty());
        startYearCol.setCellValueFactory(cellDate -> cellDate.getValue().startYearProperty());
        MainFrameInit mainFrameInit = new MainFrameInit();
        mainFrameInit.setStudents();
        mainFrameInit.setSexItems();
        mainFrameInit.setInstituteItems();
        mainFrameInit.setMajorItems();
        mainFrameInit.setStartYearItems();
        stuTable.setItems(MainFrameInit.students);
        sexChoice.setItems(mainFrameInit.getSexItems());
        instituteChoice.setItems(mainFrameInit.getInstituteItems());
        majorChoice.setItems(mainFrameInit.getMajorItems());
        startYearChoice.setItems(mainFrameInit.getStartYearItems());
    }

    public void onClickSearch() {
        SearchCondition searchCondition = new SearchCondition(sno.getText(), name.getText(),
                sexChoice.getSelectionModel().getSelectedItem(),
                MainFrameInit.instituteR.get(instituteChoice.getSelectionModel().getSelectedItem()),
                MainFrameInit.majorR.get(majorChoice.getSelectionModel().getSelectedItem()),
                startYearChoice.getSelectionModel().getSelectedItem());
        Search search = new Search(searchCondition);
        search.search("sift");
    }

    public void delStu() throws IOException {
        StageManage stageManage = new StageManage();
        stageManage.createNewStage("DeleteFrame.fxml", "删除");
    }

    public void insertStu() throws IOException {
        StageManage stageManage = new StageManage();
        stageManage.createNewStage("InsertFrame.fxml", "添加");
    }

    public void onClickChange() throws IOException {
        StageManage stageManage = new StageManage();
        stageManage.createNewStage("ChangeFrame.fxml", "修改");
    }

    public void onClickScoreManage() throws IOException {
        System.out.println(stuTable.getSelectionModel().getSelectedItem().getSno());
        /*StageManage stageManage = new StageManage();
        stageManage.createNewStage("ScoreFrame.fxml","学生成绩管理");*/
    }


    public void onClickRow(MouseEvent mouseEvent) throws IOException {
        int count = 2;
        if (mouseEvent.getClickCount() == count) {
            TemporaryStu.setStudent(stuTable.getSelectionModel().getSelectedItem());
            StageManage stageManage = new StageManage();
            stageManage.createNewStage("ScoreFrame.fxml","成绩管理");
        }
    }
}
