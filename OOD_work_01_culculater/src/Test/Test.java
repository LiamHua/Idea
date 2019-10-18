package Test;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static ArrayList<String> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        /*String str = "abcd";
        System.out.println(str.charAt(0));
        if (str.charAt(0) == 'a')
            System.out.println("!!!");

        String s = "1+2-3=";
        String symbol = " .*\\D.*";
        System.out.println(symbol);
        boolean matches = Pattern.matches(symbol, s);
        if (matches){
            System.out.println("999");
        }*/


        /*int num = 0;
        String str = "12+22+32+42=";
        String symbol = "\\D";
        Pattern r = Pattern.compile(symbol);
        Matcher m = r.matcher(str);
        while (m.find()) {
            list.add(str.substring(0,m.start() - num));
            list.add(str.substring(m.start() - num,m.end() - num));
            str = str.substring(m.end() - num);
            num = m.end();
        }
        System.out.println(list);*/

        ArrayList list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);
        list.remove("c");
        System.out.println(list);

    }
}
