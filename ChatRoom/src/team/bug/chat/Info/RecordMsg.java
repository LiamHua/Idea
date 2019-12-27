package team.bug.chat.Info;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liam
 */
public class RecordMsg {
    static ArrayList<String> userList = new ArrayList();
    /*static ObservableList<Friend> chatObj = FXCollections.observableArrayList();  //记录已生成的聊天对象*/
    /*static ObservableList<String> msg = FXCollections.observableArrayList();  //保存消息记录*/
    static Map<Friend, ObservableList<String>> chatMap = new HashMap<>();

    public static boolean isExist(Friend friend){
        return chatMap.containsKey(friend);
    }

    public static void addMsgList(Friend friend, ObservableList<String> msg){
        userList.add(friend.username);
        chatMap.put(friend,msg);
    }

    public static ObservableList<String> getMsgList(Friend friend){
        return chatMap.get(friend);
    }
}
