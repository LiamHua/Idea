package per.liam.stumanager.model;

import javafx.collections.ObservableList;
import per.liam.stumanager.dao.UpdateDao;
import per.liam.stumanager.dao.UpdateDaoImpl;
import per.liam.stumanager.utils.Course;
import per.liam.stumanager.utils.Student;

import java.util.ArrayList;

/**
 * @author liam
 * @date 19-12-19 下午12:51
 */
public class Insert {
    public ArrayList<Student> insertStu(ObservableList<Student> list){
        UpdateDao updateDao = new UpdateDaoImpl();
        return updateDao.insertStu(list);
    }

    public ArrayList<Course> insertCourse(ObservableList<Course> list){
        UpdateDao updateDao = new UpdateDaoImpl();
        return updateDao.insertCourse(list);
    }
}
