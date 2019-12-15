package pers.liam.reflect;

public class Test1 {
    public static void main(String[] args){
        try{
            Class c = Class.forName("pers.liam.reflect.Simple");
            Simple s = (Simple)c.newInstance();
            s.message("Hello Java");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
