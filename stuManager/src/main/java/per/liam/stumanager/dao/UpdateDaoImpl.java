package per.liam.stumanager.dao;

import javafx.collections.ObservableList;
import org.springframework.jdbc.core.JdbcTemplate;
import per.liam.stumanager.utils.JdbcUtil;
import per.liam.stumanager.utils.Student;

import java.util.ArrayList;

/**
 * @author liam
 * @date 19-12-19 下午12:40
 */
public class UpdateDaoImpl implements UpdateDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public ArrayList<Student> insert(ObservableList<Student> list) {
        ArrayList<Student> failed = new ArrayList<>();
        String sql = "insert into student values(?,?,?,?,?,?,?,?,?)";
        for (Student stu : list){
            int update = jdbcTemplate.update(sql, stu.getSno(), stu.getName(), stu.getSex(), stu.getTel(), stu.getBirthday(),
                    stu.getAddress(), stu.getInstitute(), stu.getMajor(), stu.getStartYear());
            if (update != 1){
                failed.add(stu);
            }
        }
        return failed;
    }

    @Override
    public int delete(Student stu) {
        String sql = "delede from student where Sno=?";
        return jdbcTemplate.update(sql, stu.getSno());
    }

    @Override
    public int change(Student stu) {
        String sql = "update student set name=?,sex=?,tel=?,birthday=?,address=?,institute=?,major=?,start_year=? where Sno=?";
        return jdbcTemplate.update(sql,stu.getName(),stu.getSex(), stu.getTel(), stu.getBirthday(),
                stu.getAddress(), stu.getInstitute(), stu.getMajor(), stu.getStartYear(), stu.getSno());
    }
}
