package test;

/**
 * @author liam
 */
public class sta {
    public static void main(String[] args) {
        te te = new te();
        Thread thread = new Thread(te);
        thread.start();
        te.setMsg("nihao");
    }
}
