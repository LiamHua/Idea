package per.liam.stumanager.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import per.liam.stumanager.dao.ResultDaoImpl;
import per.liam.stumanager.utils.Student;
import java.util.List;
import java.util.Map;

/**
 * @author liam
 * @date 19-12-19 上午12:03
 */
public class Init {
    List<Map<String, Object>> result;
    public static ObservableList<Student> students = FXCollections.observableArrayList();
    public static ObservableList<Student> delStu = FXCollections.observableArrayList();
    private ObservableList<String> sexItems = FXCollections.observableArrayList();
    private ObservableList<String> instituteItems = FXCollections.observableArrayList();
    private ObservableList<String> majorItems = FXCollections.observableArrayList();
    private ObservableList<String> startYearItems = FXCollections.observableArrayList();

    public Init(){
        this.result = new ResultDaoImpl().init();
    }

    public void setStudents() {
        for (Map<String,Object> i : result){
            students.add(new Student(i.get("Sno").toString(), i.get("name").toString(), i.get("sex").toString(),
                    i.get("tel").toString(), i.get("birthday").toString(), i.get("address").toString(),
                    i.get("institute").toString(), i.get("major").toString(), i.get("start_year").toString()));
        }
    }

    public ObservableList<String> getSexItems() {
        return sexItems;
    }

    public void setSexItems() {
        for (Map<String,Object> i : result){
            if (!sexItems.contains(i.get("sex").toString())){
                sexItems.add(i.get("sex").toString());
            }
        }
    }

    public ObservableList<String> getInstituteItems() {
        return instituteItems;
    }

    public void setInstituteItems() {
        for (Map<String,Object> i : result){
            if (!instituteItems.contains(i.get("institute").toString())){
                instituteItems.add(i.get("institute").toString());
            }
        }
    }

    public ObservableList<String> getMajorItems() {
        return majorItems;
    }

    public void setMajorItems() {
        for (Map<String,Object> i : result){
            if (!majorItems.contains(i.get("major").toString())){
                majorItems.add(i.get("major").toString());
            }
        }
    }

    public ObservableList<String> getStartYearItems() {
        return startYearItems;
    }

    public void setStartYearItems() {
        for (Map<String,Object> i : result){
            if (!startYearItems.contains(i.get("start_year").toString())){
                startYearItems.add(i.get("start_year").toString());
            }
        }
    }
}
