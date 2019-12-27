package per.liam.stumanager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import per.liam.stumanager.model.Change;
import per.liam.stumanager.model.CourseFrameInit;
import per.liam.stumanager.utils.AlertDialog;
import per.liam.stumanager.utils.Course;
import per.liam.stumanager.utils.StageManage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author liam
 * @date 19-12-27 下午8:02
 */
public class CourseManageC implements Initializable {
    @FXML
    private TableView<Course> courseTable;
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
    @FXML
    private Button modify;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cnoCol.setCellValueFactory(new PropertyValueFactory<>("cno"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        instituteCol.setCellValueFactory(new PropertyValueFactory<>("institute"));
        teacherCol.setCellValueFactory(new PropertyValueFactory<>("teacher"));
        telCol.setCellValueFactory(new PropertyValueFactory<>("tel"));
        courseTable.setItems(CourseFrameInit.courses);
        CourseFrameInit courseFrameInit = new CourseFrameInit();
        courseFrameInit.setCourses();
    }

    @FXML
    public void onClickModify() {
        Course course = new Course(cno.getText(), name.getText(), institute.getText(), teacher.getText(), tel.getText());
        Change change = new Change();
        int i = change.changeCourseInfo(course);
        if (i == 1) {
            new AlertDialog().correctInformationDialog("修改成功！");
        } else {
            new AlertDialog().errorInformationDialog("修改失败！");
        }
    }

    @FXML
    public void onClickCourseTable() {
        Course selectedItem = courseTable.getSelectionModel().getSelectedItem();
        cno.setText(selectedItem.getCno());
        name.setText(selectedItem.getName());
        institute.setText(selectedItem.getInstitute());
        teacher.setText(selectedItem.getTeacher());
        tel.setText(selectedItem.getTel());
    }

    public void onClickAddCourse(ActionEvent actionEvent) throws IOException {
        StageManage stageManage = new StageManage();
        stageManage.createNewStage("AddCourse.fxml", "添加课程");
    }
}
