package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Vote {

    private UUID id;
    private User user;
    private Party party;

    public Vote(User user, Party party){
        this.id = UUID.randomUUID();
        this.user = user;
        this.party = party;
    }

    public User getUser() {
        return user;
    }

    public Party getParty() {
        return party;
    }

    public static List<Vote> getVoterListByAreaCode(List<User> userList ){ // list will come from dao
        List<Vote> voterList = new ArrayList<>();
        for(User user: User.findAllUsersByAreaCode(userList)){
            voterList.add(new Vote(user, null));
        }
        return voterList;
    }
}
