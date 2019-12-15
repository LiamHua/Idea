package pers.liam.calculater;

import java.util.ArrayList;

public class Calculate {
    public static double calculate(ArrayList list) {
        /*Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj.toString().equals("(")) {
            }
        }*/
        double result = Double.parseDouble(list.get(0).toString());
        int n = list.size();
        for (int i = 2; i < n; i += 2) {
//            String c = list.get(i).toString();
            switch (list.get(i - 1).toString()) {
                case "+":
                    result = Operater.add(result, Double.parseDouble(list.get(i).toString()));
                    break;
                /*case "-":
                    result = Operater.sub(result, Double.parseDouble(list.get(i).toString()));
                    break;
                case "*":
                    result = Operater.mul(result, Double.parseDouble(list.get(i).toString()));
                    break;
                case "/":
                    result = Operater.div(result, Double.parseDouble(list.get(i).toString()));
                    break;*/
            }
        }
        return result;
    }
}
