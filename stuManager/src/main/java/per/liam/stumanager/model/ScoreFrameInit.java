package per.liam.stumanager.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import per.liam.stumanager.dao.ResultDaoImpl;
import per.liam.stumanager.utils.Score;
import per.liam.stumanager.utils.TemporaryStu;

import java.util.List;
import java.util.Map;

/**
 * @author liam
 * @date 19-12-27 上午12:27
 */
public class ScoreFrameInit {
    public static ObservableList<Score> scores = FXCollections.observableArrayList();

    public void setCourses() {
        // 清除残留信息

        scores.clear();
        int serialNo = 1;
        ResultDaoImpl resultDao = new ResultDaoImpl();
        List<Map<String, Object>> score = resultDao.getScore(TemporaryStu.getStudent());
        for (Map<String,Object> i : score){
            scores.add(new Score(serialNo++, TemporaryStu.getStudent().getSno(), i.get("Cno").toString(),
                    i.get("Cname").toString(), i.get("time").toString(),
                    Integer.parseInt(i.get("firstScore").toString()),
                    Integer.parseInt(i.get("secondScore").toString())));
        }
    }
}
