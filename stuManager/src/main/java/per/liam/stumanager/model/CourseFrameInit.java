package per.liam.stumanager.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import per.liam.stumanager.dao.ResultDaoImpl;
import per.liam.stumanager.utils.Course;
import per.liam.stumanager.utils.Score;
import per.liam.stumanager.utils.TemporaryStu;

import java.util.List;
import java.util.Map;

/**
 * @author liam
 * @date 19-12-27 下午8:19
 */
public class CourseFrameInit {
    public static ObservableList<Course> courses = FXCollections.observableArrayList();

    public void setCourses() {
        // 清除残留信息
        courses.clear();

        ResultDaoImpl resultDao = new ResultDaoImpl();
        List<Map<String, Object>> mapList = resultDao.getCourse();
        for (Map<String,Object> i : mapList){
            courses.add(new Course(i.get("Cno").toString(), i.get("Cname").toString(), i.get("instituteName").toString(),
                    i.get("teacher").toString(), i.get("tel").toString()));
        }
    }
}
