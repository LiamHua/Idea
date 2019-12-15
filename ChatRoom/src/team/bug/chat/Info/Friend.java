package team.bug.chat.Info;

public class Friend {
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
}
