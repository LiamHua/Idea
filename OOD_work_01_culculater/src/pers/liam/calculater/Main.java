package pers.liam.calculater;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        while (true){
            System.out.println("计算器开始运行，输入 = 结束：");
            ArrayList list = Store.setList();
            double result = Calculate.calculate(list);
            System.out.println(result);
        }
    }
}
