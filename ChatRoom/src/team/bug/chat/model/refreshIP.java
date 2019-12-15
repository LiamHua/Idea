package team.bug.chat.model;

import team.bug.chat.web.MyServiceImplService;
import team.bug.chat.web.MyServiceImplService_Service;

public class RefreshIP {
    public static String refreshIP(String username){
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        return service.getIP(username);
    }
}
