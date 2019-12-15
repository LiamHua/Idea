package pers.liam.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class Test2 {
    public static void main(String[] args){
        try{
            Class c2 = Class.forName("pers.liam.reflect.Simple");
            Method[] methods = c2.getDeclaredMethods();
            for ( Method m: methods){
                System.out.println("MethodsName: "+m.getName());
                System.out.println("ReturnType: "+m.getReturnType());
                for (Type c3 : m.getGenericParameterTypes()){
                    System.out.println("ParameterTypes: "+c3);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
