package test;

public class te implements Runnable {
    public String msg = "";

    public void setMsg(String str) {
        this.msg = str;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(msg);
        }

    }
}
