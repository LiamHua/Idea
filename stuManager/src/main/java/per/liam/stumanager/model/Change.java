package per.liam.stumanager.model;

import per.liam.stumanager.dao.UpdateDaoImpl;
import per.liam.stumanager.utils.Course;
import per.liam.stumanager.utils.Student;

/**
 * @author liam
 * @date 19-12-19 下午1:27
 */
public class Change {
    UpdateDaoImpl updateDao = new UpdateDaoImpl();
    public int changeStuInfo(Student student){
        return updateDao.changeStu(student);
    }

    public int changeScoreInfo(Course course){
        return updateDao.changeScore(course);
    }
}
