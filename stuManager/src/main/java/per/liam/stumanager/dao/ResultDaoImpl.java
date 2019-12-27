package per.liam.stumanager.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import per.liam.stumanager.utils.JdbcUtil;
import per.liam.stumanager.utils.SearchCondition;
import per.liam.stumanager.utils.Student;

import java.util.List;
import java.util.Map;

/**
 * @author liam
 * @date 19-12-18 下午11:36
 */
public class ResultDaoImpl implements ResultDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());



    @Override
    public List<Map<String, Object>> init() {
        String sql = "select Sno,name,sex,tel,birthday,address,institute.instituteName,major.majorName,start_year " +
                "from stuManager.student,stuManager.institute,stuManager.major " +
                "where student.instituteId=institute.instituteId and student.majorId=major.majorId";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @Override
    public List<Map<String, Object>> getInstitute() {
        String sql = "select * from institute";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> getMajor() {
        String sql = "select * from major";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> search(SearchCondition condition) {
        String sql = "select * from student where Sno like ? and name like ? and sex like ? and instituteId like ? and majorId like ? " +
                "and start_year like ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, condition.getSnoCondition(), condition.getNameCondition(),
                condition.getSexCondition(), condition.getInstituteCondition(), condition.getMajorCondition(),
                condition.getYearCondition());
        return maps;
    }

    @Override
    public int delStu(String sno) {
        String sql = "delete from student where Sno=?";
        return jdbcTemplate.update(sql, sno);
    }

    @Override
    public List<Map<String, Object>> getScore(Student student) {
        String sql = "select score.Cno,Cname,score.time,firstScore,secondScore from score,course where score.Cno = course.Cno and " +
                "Sno = ?";
        return jdbcTemplate.queryForList(sql, student.getSno());
    }
}
