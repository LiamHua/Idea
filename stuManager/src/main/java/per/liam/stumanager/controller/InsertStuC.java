package per.liam.stumanager.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import per.liam.stumanager.model.Insert;
import per.liam.stumanager.model.MainFrameInit;
import per.liam.stumanager.utils.AlertDialog;
import per.liam.stumanager.utils.Student;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author liam
 * @date 19-12-19 上午11:19
 */
public class InsertStuC implements Initializable {
    @FXML
    private TextField sno;
    @FXML
    private TextField name;
    @FXML
    private ComboBox<String> sexChoice;
    @FXML
    private TextField tel;
    @FXML
    private TextField birthday;
    @FXML
    private TextField address;
    @FXML
    private ComboBox<String> instituteChoice;
    @FXML
    private ComboBox<String> majorChoice;
    @FXML
    private ComboBox<String> startYearChoice;
    @FXML
    private TableView<Student> insertTable;
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

    ObservableList<Student> list = FXCollections.observableArrayList();

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
        insertTable.setItems(list);
        sexChoice.setItems(MainFrameInit.sexItems);
        instituteChoice.setItems(MainFrameInit.instituteItems);
        majorChoice.setItems(MainFrameInit.majorItems);
        startYearChoice.setItems(MainFrameInit.startYearItems);
    }

    @FXML
    public void onClickAdd() {
        list.add(new Student(sno.getText(), name.getText(), sexChoice.getSelectionModel().getSelectedItem(), tel.getText(),
                birthday.getText(), address.getText(), instituteChoice.getSelectionModel().getSelectedItem(),
                majorChoice.getSelectionModel().getSelectedItem(), startYearChoice.getSelectionModel().getSelectedItem()));
        sno.setText("");
        name.setText("");
        sexChoice.setSelectionModel(null);
        tel.setText("");
        birthday.setText("");
        address.setText("");
        instituteChoice.setSelectionModel(null);
        majorChoice.setSelectionModel(null);
        startYearChoice.setSelectionModel(null);
    }

    @FXML
    public void onClickUpdate(ActionEvent actionEvent) {
        Insert in = new Insert();
        ArrayList<Student> failed = in.insertStu(list);
        if (failed.isEmpty()){
            new AlertDialog().correctInformationDialog("添加成功！");
        }else {
            new AlertDialog().errorInformationDialog(failed.toString() + "添加失败！");
        }
        list.clear();
    }
}
