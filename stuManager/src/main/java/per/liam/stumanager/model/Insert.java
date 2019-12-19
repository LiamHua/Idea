package per.liam.stumanager.model;

import javafx.collections.ObservableList;
import per.liam.stumanager.dao.UpdateDao;
import per.liam.stumanager.dao.UpdateDaoImpl;
import per.liam.stumanager.utils.Student;

import java.util.ArrayList;

/**
 * @author liam
 * @date 19-12-19 下午12:51
 */
public class Insert {
    public ArrayList<Student> insert(ObservableList<Student> list){
        UpdateDao updateDao = new UpdateDaoImpl();
        return updateDao.insert(list);
    }
}
