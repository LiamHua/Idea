package pers.liam.ChatRoom.Test;

import team.bug.chat.web.MyServiceImplService;
import team.bug.chat.web.MyServiceImplService_Service;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        int i = service.delFriend("12345", "13617136120");
        System.out.println(i);
    }
}
