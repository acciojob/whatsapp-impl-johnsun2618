package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class WhatsappRepository {

    //Assume that each user belongs to at most one group
    //You can use the below mentioned hashmaps or delete these and create your own.
    private HashMap<Group, List<User>> groupUserMap;
    private HashMap<Group, List<Message>> groupMessageMap;
    private HashMap<Message, User> senderMap;
    private HashMap<Group, User> adminMap;
    private HashSet<String> userMobile;
    private int customGroupCount;
    private int messageId;

    public WhatsappRepository(){
        this.groupMessageMap = new HashMap<Group, List<Message>>();
        this.groupUserMap = new HashMap<Group, List<User>>();
        this.senderMap = new HashMap<Message, User>();
        this.adminMap = new HashMap<Group, User>();
        this.userMobile = new HashSet<>();
        this.customGroupCount = 0;
        this.messageId = 0;
    }

    public boolean isNewUser(String mobile){
        if(userMobile.contains(mobile)) return false;
        return false;
    }

    public void createUser(String name, String mobile){
        userMobile.add(mobile);
    }

    public String changeAdmin(User approve, User user, Group group) throws Exception{
        if(!groupUserMap.containsKey(group)) throw new Exception("Group does not exist");
        if(!adminMap.get(group).equals(approve)) throw new Exception("Approve does not have right");
        if(!this.userExistInGroup(group, user)) throw new Exception("User is not available");

        adminMap.put(group, user);
        return "SUCCESS";
    }

    private boolean userExistInGroup(Group group, User user) {
    }

}
