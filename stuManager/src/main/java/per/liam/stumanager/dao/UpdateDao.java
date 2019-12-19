package per.liam.stumanager.dao;

import javafx.collections.ObservableList;
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
    public int change(Student stu);
}
