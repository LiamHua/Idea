package per.liam.stumanager.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import per.liam.stumanager.model.Insert;
import per.liam.stumanager.utils.Student;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author liam
 * @date 19-12-19 上午11:19
 */
public class InsertC implements Initializable {
    public TextField sno;
    public TextField name;
    public TextField sex;
    public TextField tel;
    public TextField birthday;
    public TextField address;
    public TextField institute;
    public TextField major;
    public TextField startYear;
    @FXML
    private TableView<Student> insertTable;
    @FXML
    private TableColumn<Student,String> snoCol;
    @FXML
    private TableColumn<Student,String> nameCol;
    @FXML
    private TableColumn<Student,String> sexCol;
    @FXML
    private TableColumn<Student,String> telCol;
    @FXML
    private TableColumn<Student,String> birthdayCol;
    @FXML
    private TableColumn<Student,String> addressCol;
    @FXML
    private TableColumn<Student,String> instituteCol;
    @FXML
    private TableColumn<Student,String> majorCol;
    @FXML
    private TableColumn<Student,String> startYearCol;

    ObservableList<Student> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        snoCol.setCellValueFactory(cellDate->cellDate.getValue().snoProperty());
        nameCol.setCellValueFactory(cellDate->cellDate.getValue().nameProperty());
        sexCol.setCellValueFactory(cellDate->cellDate.getValue().sexProperty());
        telCol.setCellValueFactory(cellDate->cellDate.getValue().telProperty());
        birthdayCol.setCellValueFactory(cellDate->cellDate.getValue().birthdayProperty());
        addressCol.setCellValueFactory(cellDate->cellDate.getValue().addressProperty());
        instituteCol.setCellValueFactory(cellDate->cellDate.getValue().instituteProperty());
        majorCol.setCellValueFactory(cellDate->cellDate.getValue().majorProperty());
        startYearCol.setCellValueFactory(cellDate->cellDate.getValue().startYearProperty());
        insertTable.setItems(list);
    }

    public void onClickAdd() {
     list.add(new Student(sno.getText(), name.getText(), sex.getText(), tel.getText(), birthday.getText(),
             address.getText(), institute.getText(), major.getText(), startYear.getText()));
     sno.setText("");
     name.setText("");
     sex.setText("");
     tel.setText("");
     birthday.setText("");
     address.setText("");
     institute.setText("");
     major.setText("");
     startYear.setText("");
    }

    public void onClickUpdate(ActionEvent actionEvent) {
        Insert in = new Insert();
        ArrayList<Student> failed = in.insert(list);
        list.clear();
    }
}
