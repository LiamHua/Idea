package per.liam.stumanager.model;

import per.liam.stumanager.dao.UpdateDaoImpl;
import per.liam.stumanager.utils.Student;

/**
 * @author liam
 * @date 19-12-19 下午1:27
 */
public class Change {
    public int change(Student student){
        UpdateDaoImpl updateDao = new UpdateDaoImpl();
        return updateDao.change(student);
    }
}
