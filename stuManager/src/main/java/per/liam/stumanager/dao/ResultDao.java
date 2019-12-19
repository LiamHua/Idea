package per.liam.stumanager.dao;

import per.liam.stumanager.utils.SearchCondition;

import java.util.List;
import java.util.Map;

/**
 * @author liam
 * @date 19-12-18 下午11:33
 */
public interface ResultDao {

    /**
     * 初始化
     * @return 所有学生的集合
     */
    public List<Map<String,Object>> init();

    /**
     * 通过条件查询学生信息
     * @param condition 条件集合，分别为： 学号 姓名 性别 学院 专业 入学年份
     * @return 查询结果集
     */
    public List<Map<String,Object>> search(SearchCondition condition);

    /**
     * 删除一个学生的信息
     * @param sno 学号
     * @return 数据库改变量
     */
    public int delStu(String sno);
}
