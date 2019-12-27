package team.bug.chat.model;

import team.bug.chat.dao.MyServiceImplService;
import team.bug.chat.dao.MyServiceImplService_Service;

/**
 * @author liam
 */
public class RefreshIP {
    public static String refreshIP(String username){
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        return service.getIP(username);
    }
}
