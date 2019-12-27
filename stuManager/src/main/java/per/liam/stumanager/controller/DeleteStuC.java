package per.liam.stumanager.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import per.liam.stumanager.model.Delete;
import per.liam.stumanager.model.MainFrameInit;
import per.liam.stumanager.model.Search;
import per.liam.stumanager.utils.AlertDialog;
import per.liam.stumanager.utils.SearchCondition;
import per.liam.stumanager.utils.Student;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author liam
 * @date 19-12-19 上午2:39
 */
public class DeleteStuC implements Initializable {
    @FXML
    private TextField sno;
    @FXML
    private TableView<Student> stu;
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
        stu.setItems(MainFrameInit.delStu);
    }

    @FXML
    public void onClickSearch() {
        SearchCondition searchCondition = new SearchCondition(sno.getText(), "", null, null, null, null);
        Search search = new Search(searchCondition);
        search.search("del");
    }

    @FXML
    public void onClickDelete() {
        AlertDialog alertDialog = new AlertDialog();
        Delete del = new Delete();
        int i = del.delete();
        System.out.println(i);
        if (i == 1) {
            alertDialog.correctInformationDialog("删除成功！");
        } else {
            alertDialog.errorInformationDialog("删除失败！");
        }
    }
}
