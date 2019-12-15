package pers.liam.calculater;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store {

    public static ArrayList setList() {
        ArrayList list = new ArrayList();
        int num = 0;
        Scanner input = new Scanner(System.in);
        String str = input.next();
        //拆分字符串
        String symbol = "[-+*/=]";
        Pattern r = Pattern.compile(symbol);
        Matcher m = r.matcher(str);
        while (m.find()) {
            list.add(str.substring(0, m.start() - num));
            list.add(str.substring(m.start() - num, m.end() - num));
            str = str.substring(m.end() - num);
            num = m.end();
        }
//        list.removeIf(obj -> obj.toString().length() == 0);
        return list;
    }
}
