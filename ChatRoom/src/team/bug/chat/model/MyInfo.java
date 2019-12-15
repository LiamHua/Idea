package team.bug.chat.model;

import com.sun.javaws.IconUtil;
import javafx.collections.ObservableList;
import team.bug.chat.Info.Friend;
import team.bug.chat.itemUtils.IP;
import team.bug.chat.dao.MyServiceImplService;
import team.bug.chat.dao.MyServiceImplService_Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liam
 */
public class MyInfo {
    public static String nickName;
    public static String username;
    public static String address;
    public static Map<String,Friend> friendMap = new HashMap<>();

    public static void setInfo() {
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        nickName = service.getNickname(username);
        address = IP.getLocalIP();
        service.setIP(username,IP.getLocalIP());
    }

    public static void getFriends(ObservableList<Friend> flist){
        MyServiceImplService service = new MyServiceImplService_Service().getMyServiceImplServicePort();
        List<team.bug.chat.dao.Friend> friendList = service.getFriendList(username);
        if (friendList.size() < flist.size()){
            flist.clear();
        }
        for (team.bug.chat.dao.Friend i : friendList){
            Friend friend = new Friend(i.getNickname(),i.getUsername(),i.getAddress());
            if (!flist.contains(friend)){
                friendMap.put(friend.username,friend);
                flist.add(friend);
            }

        }
    }
}
