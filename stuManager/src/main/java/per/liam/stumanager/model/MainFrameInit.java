package per.liam.stumanager.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import per.liam.stumanager.dao.ResultDaoImpl;
import per.liam.stumanager.utils.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liam
 * @date 19-12-19 上午12:03
 */
public class MainFrameInit {
    List<Map<String, Object>> result;
    public static ObservableList<Student> students = FXCollections.observableArrayList();
    public static ObservableList<Student> delStu = FXCollections.observableArrayList();
    public static Map<String,String> institute = new HashMap<>();
    public static Map<String,String> major = new HashMap<>();
    public static Map<String,String> instituteR = new HashMap<>();
    public static Map<String,String> majorR = new HashMap<>();
    private ObservableList<String> sexItems = FXCollections.observableArrayList();
    private ObservableList<String> instituteItems = FXCollections.observableArrayList();
    private ObservableList<String> majorItems = FXCollections.observableArrayList();
    private ObservableList<String> startYearItems = FXCollections.observableArrayList();



    public MainFrameInit(){
        ResultDaoImpl resultDao = new ResultDaoImpl();
        this.result = resultDao.init();
        for (Map<String, Object> i : resultDao.getInstitute()){
            instituteR.put(i.get("instituteName").toString(),i.get("instituteId").toString());
            institute.put(i.get("instituteId").toString(),i.get("instituteName").toString());
        }
        for (Map<String, Object> i : resultDao.getMajor()){
            majorR.put(i.get("majorName").toString(),i.get("majorId").toString());
            major.put(i.get("majorId").toString(),i.get("majorName").toString());
        }
    }

    public void setStudents() {
        for (Map<String,Object> i : result){
            students.add(new Student(i.get("Sno").toString(), i.get("name").toString(), i.get("sex").toString(),
                    i.get("tel").toString(), i.get("birthday").toString(), i.get("address").toString(),
                    i.get("instituteName").toString(), i.get("majorName").toString(), i.get("start_year").toString()));
        }
    }

    public ObservableList<String> getSexItems() {
        return sexItems;
    }

    public void setSexItems() {
        sexItems.add("全部");
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
        instituteItems.add("全部");
        for (Map<String,Object> i : result){
            if (!instituteItems.contains(i.get("instituteName").toString())){
                instituteItems.add(i.get("instituteName").toString());
            }
        }
    }

    public ObservableList<String> getMajorItems() {
        return majorItems;
    }

    public void setMajorItems() {
        majorItems.add("全部");
        for (Map<String,Object> i : result){
            if (!majorItems.contains(i.get("majorName").toString())){
                majorItems.add(i.get("majorName").toString());
            }
        }
    }

    public ObservableList<String> getStartYearItems() {
        return startYearItems;
    }

    public void setStartYearItems() {
        startYearItems.add("全部");
        for (Map<String,Object> i : result){
            if (!startYearItems.contains(i.get("start_year").toString())){
                startYearItems.add(i.get("start_year").toString());
            }
        }
    }
}
