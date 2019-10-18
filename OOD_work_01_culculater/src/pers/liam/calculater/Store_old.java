package pers.liam.calculater;

import java.util.ArrayList;
import java.util.Scanner;

public class Store_old {
    public static ArrayList<String> list;
    public static void setList(){
        list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String i;
        do{
            i  = input.next();
            list.add(i);
        }while(!i.equals("="));
    }
}
