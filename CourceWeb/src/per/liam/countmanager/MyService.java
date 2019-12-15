package per.liam.countmanager;

import per.liam.countmanager.friend.Friend;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

/**
 * @author liam
 */
@WebService(serviceName = "MyService")
public interface MyService {

    @WebMethod
    int addUser(String nickname, String username, String password);

    @WebMethod
    boolean modifyUserInfo();

    @WebMethod
    String getNickname(String username);

    @WebMethod
    int changeUserInfo(String address);

    @WebMethod
    int verifyUserInfo(String username, String password);

    @WebMethod
    int setIP(String username, String ip);

    @WebMethod
    String getIP(String username);

    @WebMethod
    ArrayList<Friend> getFriendList(String username);

    @WebMethod
    ArrayList<String> searchFriend(String username);

    @WebMethod
    int addFriendMsg(ArrayList<String> friend, String username);

    @WebMethod
    int delFriend(String username1,String username2);

    @WebMethod
    ArrayList<String> checkFriend(String username);

    @WebMethod
    int addFriend(ArrayList<String> list1, ArrayList<String> list2);
}
