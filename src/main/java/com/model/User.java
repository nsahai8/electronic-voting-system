package com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class User {

    private final UUID id;
    private final String name;
    private final Address address;
    private final String phn_no;
    private final String voter_id;
    private boolean isBlackListed;
    private boolean hasVoted;

    public static List<User> findAllUsersByAreaCode(List<User> userList) {//from dao
        User user1 = new User(UUID.randomUUID(), "Niharika", new Address("Gopal Kunj", 282005, State.findByName("Agra")), "", "voter_id_1", false, false);
        User user2 = new User(UUID.randomUUID(), "Shrey", new Address("Gopal Kunj", 282005, State.findByName("Agra")), "", "voter_id_2", false, false);
        User user4 = new User(UUID.randomUUID(), "Cde", new Address("Gopal Kunj", 282005, State.findByName("Agra")), "", "voter_id_4", false, false);

        userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user4);
        return userList;
    }
}
