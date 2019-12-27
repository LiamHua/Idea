package per.liam.stumanager.dao;

import javafx.collections.ObservableList;
import org.omg.CORBA.PUBLIC_MEMBER;
import per.liam.stumanager.utils.Course;
import per.liam.stumanager.utils.Student;

import java.util.ArrayList;

/**
 * @author liam
 * @date 19-12-19 下午12:37
 */
public interface UpdateDao {

    /**
     * 添加学生信息
     * @param list 学生信息列表
     * @return 改变量
     */
    public ArrayList<Student> insert(ObservableList<Student> list);

    /**
     * 删除学生信息
     * @param stu 学生
     * @return 改变量
     */
    public int delete(Student stu);

    /**
     * 修改学生信息
     * @param stu 学生
     * @return 改变量
     */
    public int changeStu(Student stu);

    /**
     * 修改学生成绩信息
     * @param course 学生学习的课程及成绩信息
     * @return 改变量
     */
    public int changeScore(Course course);
}
