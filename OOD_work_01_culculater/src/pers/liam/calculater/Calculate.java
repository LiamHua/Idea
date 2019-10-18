package pers.liam.calculater;

import java.util.ArrayList;
import java.util.Iterator;

public class Calculate {
    public static double calculate(ArrayList list){
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            if (obj.toString().equals("(")){
                
            }
        }


        double result = Double.parseDouble(list.get(0).toString());
        int n = list.size();
        for (int i=2; i<n; i+=2){
            String c = list.get(i).toString();
            if (list.get(i-1).toString().equals("+")){
                result = Operater.add(result,Double.parseDouble(list.get(i).toString()));
            }
            else if (list.get(i-1).toString().equals("-")){
                result = Operater.sub(result,Double.parseDouble(list.get(i).toString()));
            }
            else if (list.get(i-1).toString().equals("*")){
                result = Operater.mul(result,Double.parseDouble(list.get(i).toString()));
            }
            else if (list.get(i-1).toString().equals("/")){
                result = Operater.div(result,Double.parseDouble(list.get(i).toString()));
            }
        }
        return result;
    }
}
