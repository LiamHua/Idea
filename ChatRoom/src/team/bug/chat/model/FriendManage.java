package team.bug.chat.model;

import team.bug.chat.web.MyServiceImplService;
import team.bug.chat.web.MyServiceImplService_Service;

import java.util.List;

public class AddFriend {
    public static String username;  //临时保存搜索出的用户名

    public List<String> searchFriend(String username){
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        List<String> friend = service.searchFriend(username);
        if (friend.isEmpty()){
            return null;
        }else {
            return friend;
        }

    }

    public int addFriend(String username){
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        return service.addFriend(MyInfo.username, MyInfo.nickName, username);

    }
}
