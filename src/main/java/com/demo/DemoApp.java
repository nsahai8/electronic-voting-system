package com.demo;

import com.model.Address;
import com.model.Party;
import com.model.State;
import com.model.User;
import com.service.MachineService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Create main class to test the whole code
 */
public class DemoApp {

    static List<User> userList;

    public static void main(String[] args) {
        User user1 = new User(UUID.randomUUID(), "Niharika", new Address("Gopal Kunj", 282005, State.findByName("Agra")), "", "voter_id_1", false, false);
        User user2 = new User(UUID.randomUUID(), "Shrey", new Address("Gopal Kunj", 282005, State.findByName("Agra")), "", "voter_id_2", false, false);
        User user3 = new User(UUID.randomUUID(), "Abc", new Address("Gopal Kunj", 282005, State.findByName("Agra")), "", "voter_id_3", false, false);
        User user4 = new User(UUID.randomUUID(), "Cde", new Address("Gopal Kunj", 282005, State.findByName("Agra")), "", "voter_id_4", false, false);

        prepareUserList(user1, user2, user4);
        Party party1 = new Party(UUID.randomUUID(), "party1", "https://party1.com");
        Party party2 = new Party(UUID.randomUUID(), "party2", "https://party2.com");
        Party party3 = new Party(UUID.randomUUID(), "party3", "https://party3.com");
        String stateName = "Agra";
        MachineService machineService = new MachineService(stateName, 282005);
        preparePartyList(machineService, party1, party2, party3);

        // cast vote
        machineService.vote(user1, party1);
        machineService.vote(user2, party1);
        machineService.vote(user3, party2);
        machineService.vote(user4, party3);

        // try voting again
        machineService.vote(user4, party3);

        // calculate the winner for state
        String partyName = machineService.findWinnerParty();
        if (null != partyName) {
            System.out.println("Congratulations, " + partyName + " You have won elections for " + stateName);
        } else {
            System.out.println("No individual party won");
        }


    }

    private static void prepareUserList(User user1, User user2, User user4) {
        userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user4);
    }

    private static void preparePartyList(MachineService machineService, Party party1, Party party2, Party party3) {
        machineService.addToPartyList(party1);
        machineService.addToPartyList(party2);
        machineService.addToPartyList(party3);
    }
}
