package team.bug.chat.model;

import team.bug.chat.dao.MyServiceImplService;
import team.bug.chat.dao.MyServiceImplService_Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liam
 */
public class FriendManage {
    //临时保存搜索出的用户名
    public static String username;

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
        ArrayList<String> list = new ArrayList<>();
        list.add(MyInfo.nickName);
        list.add(MyInfo.username);
        list.add(MyInfo.address);
        return service.addFriendMsg(list,username);
    }

    public int delFriend(String username){
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        return service.delFriend(MyInfo.username, username);
    }

    public ArrayList<String> checkFriend(){
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        return (ArrayList<String>) service.checkFriend(MyInfo.username);
    }

    public void confirm(ArrayList<String> list1){
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        ArrayList<String> list2 = new ArrayList<>();
        list2.add(MyInfo.nickName);
        list2.add(MyInfo.username);
        list2.add(MyInfo.address);
        int i = service.addFriend(list1, list2);
    }
}
