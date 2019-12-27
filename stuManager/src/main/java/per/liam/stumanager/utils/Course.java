package per.liam.stumanager.utils;

/**
 * @author liam
 * @date 19-12-27 下午8:27
 */
public class Course {
    private String cno;
    private String name;
    private String institute;
    private String teacher;
    private String tel;

    public Course(String cno, String name, String institute, String teacher, String tel) {
        this.cno = cno;
        this.name = name;
        this.institute = institute;
        this.teacher = teacher;
        this.tel = tel;
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

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
