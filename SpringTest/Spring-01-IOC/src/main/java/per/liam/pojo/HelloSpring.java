package per.liam.pojo;

/**
 * @author liam
 * @date 19-12-22 下午12:50
 */
public class HelloSpring {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "HelloSpring{" +
                "str='" + str + '\'' +
                '}';
    }
}
