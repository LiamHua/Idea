package team.bug.chat.model;

import javafx.collections.ObservableList;
import team.bug.chat.Info.Friend;
import team.bug.chat.itemUtils.IP;
import team.bug.chat.web.MyServiceImplService;
import team.bug.chat.web.MyServiceImplService_Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyInfo {
    public static String nickName;
    public static String username;
    public static Map<String,Friend> friendMap = new HashMap<>();

    public static void setInfo() {
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        nickName = service.getNickname(username);
        service.setIP(username,IP.getLocalIP());
    }

    public static void getFriends(ObservableList<Friend> flist){
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        List<team.bug.chat.web.Friends> friendList = service.getFriendList("999");
        for (team.bug.chat.web.Friends i : friendList){
            Friend friend = new Friend(i.getNickname(),i.getUsername(),i.getAddress());
            friendMap.put(friend.username,friend);
            flist.add(friend);
        }
    }
}
