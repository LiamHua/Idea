package per.liam.stumanager.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import per.liam.stumanager.model.Init;
import per.liam.stumanager.model.Search;
import per.liam.stumanager.utils.SearchCondition;
import per.liam.stumanager.utils.StageManage;
import per.liam.stumanager.utils.Student;

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
        Init init = new Init();
        init.setStudents();
        init.setSexItems();
        init.setInstituteItems();
        init.setMajorItems();
        init.setStartYearItems();
        stuTable.setItems(Init.students);
        sexChoice.setItems(init.getSexItems());
        instituteChoice.setItems(init.getInstituteItems());
        majorChoice.setItems(init.getMajorItems());
        startYearChoice.setItems(init.getStartYearItems());
    }

    public void onClickSearch() {
        SearchCondition searchCondition = new SearchCondition(sno.getText(), name.getText(),
                sexChoice.getSelectionModel().getSelectedItem(), instituteChoice.getSelectionModel().getSelectedItem(),
                majorChoice.getSelectionModel().getSelectedItem(),
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
}
