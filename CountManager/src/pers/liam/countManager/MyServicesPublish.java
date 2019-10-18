package pers.liam.countManager;

import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyServicesPublish {
    public static void main(String[] args){
        InputStream resource = MyServicesPublish.class.getClassLoader().getResourceAsStream("db.properties");
        Properties p = new Properties();
        try {
            p.load(resource);
        } catch (IOException e) {
            System.out.println("加载流文件(URL)失败！");
            e.printStackTrace();
        }
        String address = p.getProperty("url");
        Endpoint.publish(address, new MyServicesImpl());
        System.out.println("服务发布成功！");
    }
}
