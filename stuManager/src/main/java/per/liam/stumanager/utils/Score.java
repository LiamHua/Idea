package per.liam.stumanager.utils;

/**
 * @author liam
 * @date 19-12-26 下午11:05
 */
public class Score {
    private int serialNo;
    private String sno;
    private String cno;
    private String name;
    private String time;
    private int firstScore;
    private int secondScore;

    public Score(int serialNo, String sno, String cno, String name, String time, int firstScore, int secondScore) {
        this.serialNo = serialNo;
        this.sno = sno;
        this.cno = cno;
        this.name = name;
        this.time = time;
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getFirstScore() {
        return firstScore;
    }

    public void setFirstScore(int firstScore) {
        this.firstScore = firstScore;
    }

    public int getSecondScore() {
        return secondScore;
    }

    public void setSecondScore(int secondScore) {
        this.secondScore = secondScore;
    }


    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }
}
