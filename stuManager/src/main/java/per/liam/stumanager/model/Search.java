package per.liam.stumanager.model;

import javafx.collections.ObservableList;
import per.liam.stumanager.dao.ResultDao;
import per.liam.stumanager.dao.ResultDaoImpl;
import per.liam.stumanager.utils.SearchCondition;
import per.liam.stumanager.utils.Student;

import java.util.List;
import java.util.Map;
import static per.liam.stumanager.model.MainFrameInit.delStu;
import static per.liam.stumanager.model.MainFrameInit.students;

/**
 * @author liam
 * @date 19-12-18 下午11:38
 */
public class Search {
    private SearchCondition condition;
    private ObservableList<Student> list;
    ResultDao resultDao = new ResultDaoImpl();

    public Search(SearchCondition condition) {
        this.condition = condition;
    }

    public void search(String flag) {
        List<Map<String, Object>> result = resultDao.search(condition);
        if ("sift".equals(flag)) {
            students.clear();
            list = students;
        } else if ("del".equals(flag)) {
            delStu.clear();
            list = delStu;
        }

        for (Map<String, Object> i : result) {
            list.add(new Student(i.get("Sno").toString(), i.get("name").toString(), i.get("sex").toString(),
                    i.get("tel").toString(), i.get("birthday").toString(), i.get("address").toString(),
                    MainFrameInit.institute.get(i.get("instituteId").toString()), MainFrameInit.major.get(i.get("majorId").toString()),
                    i.get("start_year").toString()));
        }
    }

    public Student check(){
        List<Map<String, Object>> result = resultDao.search(condition);
        for (Map<String, Object> i : result) {
            return new Student(i.get("Sno").toString(), i.get("name").toString(), i.get("sex").toString(),
                    i.get("tel").toString(), i.get("birthday").toString(), i.get("address").toString(),
                    MainFrameInit.institute.get(i.get("instituteId").toString()), MainFrameInit.major.get(i.get("majorId").toString()),
                    i.get("start_year").toString());
        }
        return null;
    }
}
