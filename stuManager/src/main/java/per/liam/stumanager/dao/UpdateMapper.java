package per.liam.stumanager.dao;

import javafx.collections.ObservableList;
import per.liam.stumanager.utils.Course;
import per.liam.stumanager.utils.Score;
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
     * @return 添加失败的学生
     */
    public ArrayList<Student> insertStu(ObservableList<Student> list);

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
     * @param score 学生成绩信息
     * @return 改变量
     */
    public int changeScore(Score score);

    /**
     * 修改课程信息
     * @param course 课程信息
     * @return 改变量
     */
    public int changeCourse(Course course);

    /**
     * 添加课程信息
     * @param list 准备添加的课程
     * @return 添加失败的课程
     */
    public ArrayList<Course> insertCourse(ObservableList<Course> list);
}
