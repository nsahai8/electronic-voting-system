package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private Address address;
    private String phn_no;
    private String voter_id;
    private boolean isBlackListed;
    private boolean hasVoted;


    public User(String name, String voter_id, String stateName, String streetName, Integer areaCode){
        this.name = name;
        this.voter_id = voter_id;
        this.address = new Address(streetName, areaCode, stateName);
        this.isBlackListed = false;
    }

    public String getVoter_id() {
        return voter_id;
    }

    public String getName() {
        return name;
    }

    public boolean isBlackListed() {
        return isBlackListed;
    }

    public void markBlackListed() {
        isBlackListed = true;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setAsVoted() {
        this.hasVoted = true;
    }

    public static List<User> findAllUsersByAreaCode(List<User> userList){//from dao
        User user1 = new User("Niharika", "123Abc", "Agra", "Gopal Kunj", 282005);
        User user2 = new User("Shrey", "234Abc", "Agra", "Gopal Kunj", 282005);
        User user4 = new User("Shail", "423Abc", "Agra", "Gopal Kunj", 282005);
        userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user4);
        return userList;
    }
}
