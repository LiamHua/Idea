package pers.liam.calculator.Factory;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

    private String oper;      //符号名 ，如Add
    private String ope = "";  //符号，如 +
    public  String str;

    public double calculator() throws Exception {
        ArrayList list = new ArrayList();
        int num = 0;
        //拆分字符串
        System.out.println(str);
        String symbol = "[-+*/=]";
        Pattern r = Pattern.compile(symbol);
        Matcher m = r.matcher(str);
        while (m.find()) {
            list.add(str.substring(0, m.start() - num));
            list.add(str.substring(m.start() - num, m.end() - num));
            str = str.substring(m.end() - num);
            num = m.end();
        }
        System.out.println(list);
        ope = list.get(1).toString();
        Properties pps = new Properties();
        pps.load(new FileReader("src/operator.properties"));
        oper = pps.getProperty(ope);
        System.out.println(oper);
        InterfaceOperatorFactory op = (InterfaceOperatorFactory) Class.forName("pers.liam.calculator.Factory." + oper + "Factory").newInstance();
        Operator operatorFactory = op.createOperatorFactory();
        operatorFactory.setFirstNumber(Double.parseDouble(list.get(0).toString()));
        operatorFactory.setSecondNumber(Double.parseDouble(list.get(2).toString()));
        return operatorFactory.getResult();
    }
}
