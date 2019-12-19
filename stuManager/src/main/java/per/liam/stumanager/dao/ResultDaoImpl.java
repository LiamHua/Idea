package per.liam.stumanager.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import per.liam.stumanager.utils.JdbcUtil;
import per.liam.stumanager.utils.SearchCondition;

import java.util.ArrayList;
import java.util.HashMap;
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
        String sql = "select * from student";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @Override
    public List<Map<String, Object>> search(SearchCondition condition) {
        String sql = "select * from student where Sno like ? and name like ? and sex like ? and institute like ? and major like ? " +
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
}
