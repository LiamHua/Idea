package team.bug.chat.Info;

import java.util.Objects;

/**
 * @author liam
 */
public class Friend extends team.bug.chat.dao.Friend {
    public String nickname;
    public String username;
    public String address;

    public Friend(String nickname, String username,String address){
        this.nickname = nickname;
        this.username = username;
        this.address = address;
    }

    @Override
    public String toString(){
        return nickname + "  " + username;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Friend friend = (Friend) o;
        return username.equals(friend.username);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nickname,username);
    }
}
