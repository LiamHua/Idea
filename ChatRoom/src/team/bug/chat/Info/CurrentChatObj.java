package team.bug.chat.Info;

/**
 * @author liam
 */
public class CurrentChatObj {
    public static String nickname;
    public static String username;
    public static String address;

    public static void isCurrentChatObj(Friend friend){
        nickname = friend.nickname;
        username = friend.username;
        address = friend.address;
    }
}
