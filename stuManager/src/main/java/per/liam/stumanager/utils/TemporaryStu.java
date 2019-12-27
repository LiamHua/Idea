package per.liam.stumanager.utils;

/**
 * @author liam
 * @date 19-12-26 下午11:57
 * @Description 在双击学生时临时保存该学生的信息
 */

public class TemporaryStu {
    private static Student student = null;

    private TemporaryStu() {
    }

    public static Student getStudent() {
        return student;
    }

    public static void setStudent(Student student) {
        TemporaryStu.student = student;
    }
}
