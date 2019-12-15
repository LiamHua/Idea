package per.liam.chatroom.test;

import team.bug.chat.dao.MyServiceImplService;
import team.bug.chat.dao.MyServiceImplService_Service;

public class Test {
    public static void main(String[] args) {
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        int i = service.delFriend("12345", "13617136120");
        System.out.println(i);
    }
}
