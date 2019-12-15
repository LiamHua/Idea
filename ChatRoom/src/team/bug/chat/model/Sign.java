package team.bug.chat.model;

import team.bug.chat.dao.MyServiceImplService;
import team.bug.chat.dao.MyServiceImplService_Service;

/**
 * @author liam
 */
public class Sign {
    public int signIn(String username,String password){
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        return service.verifyUserInfo(username, password);
    }

    public int signUp(String nickname, String username, String password) {
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        return service.addUser(nickname, username, password);
    }
}
