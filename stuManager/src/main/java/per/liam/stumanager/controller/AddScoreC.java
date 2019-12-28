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
import javafx.scene.control.cell.PropertyValueFactory;
import per.liam.stumanager.model.CourseFrameInit;
import per.liam.stumanager.model.Insert;
import per.liam.stumanager.model.MainFrameInit;
import per.liam.stumanager.utils.AlertDialog;
import per.liam.stumanager.utils.Course;
import per.liam.stumanager.utils.Student;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author liam
 * @date 19-12-27 下午8:03
 */
public class AddScoreC implements Initializable {
    @FXML
    private TableView<Course> insertTable;
    @FXML
    private ComboBox<String> instituteChoice;
    @FXML
    private TableColumn<Course, String> cnoCol;
    @FXML
    private TableColumn<Course, String> nameCol;
    @FXML
    private TableColumn<Course, String> instituteCol;
    @FXML
    private TableColumn<Course, String> teacherCol;
    @FXML
    private TableColumn<Course, String> telCol;
    @FXML
    private TextField cno;
    @FXML
    private TextField name;
    @FXML
    private TextField institute;
    @FXML
    private TextField teacher;
    @FXML
    private TextField tel;

    private ObservableList<Course> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cnoCol.setCellValueFactory(new PropertyValueFactory<>("cno"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        instituteCol.setCellValueFactory(new PropertyValueFactory<>("institute"));
        teacherCol.setCellValueFactory(new PropertyValueFactory<>("teacher"));
        telCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
        insertTable.setItems(list);
        instituteChoice.setItems(MainFrameInit.instituteItems);
    }

    public void onClickAdd(ActionEvent actionEvent) {
        list.add(new Course(cno.getText(), name.getText(), instituteChoice.getSelectionModel().getSelectedItem(),
                teacher.getText(), tel.getText()));
        cno.setText("");
        name.setText("");
        instituteChoice.setSelectionModel(null);
        teacher.setText("");
        tel.setText("");
    }

    public void onClickUpdate(ActionEvent actionEvent) {
        Insert in = new Insert();
        ArrayList<Course> failed = in.insertCourse(list);
        if (failed.isEmpty()){
            new AlertDialog().correctInformationDialog("添加成功！");
        }else {
            new AlertDialog().errorInformationDialog(failed.toString() + "添加失败！");
        }
        list.clear();
    }
}
