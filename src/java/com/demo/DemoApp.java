package demo;

import model.Party;
import model.State;
import model.User;
import service.MachineService;

import java.util.ArrayList;
import java.util.List;

public class DemoApp {

    static List<User> userList;

    public static void main(String[] args) {

        User user1 = new User("Niharika", "123Abc", "Agra", "Gopal Kunj", 282005);
        User user2 = new User("Shrey", "234Abc", "Agra", "Gopal Kunj", 282005);
        User user3 = new User("Mayank", "897aab", "Indore", "Mayank Apartment", 565001);
        User user4 = new User("Shail", "423Abc", "Agra", "Gopal Kunj", 282005);
        prepareUserList(user1, user2, user4);
        Party party1 = new Party("party1","https://party1.com") ;
        Party party2 = new Party("party2","https://party2.com") ;
        Party party3 = new Party("party3","https://party3.com") ;
        String stateName  = "Agra";
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
        if(partyName!=null){
            System.out.println("Congratulations, "+partyName+" You have won elections for "+ stateName);
        }else {
            System.out.println("No individual party won");
        }


    }

    private static void prepareUserList(User user1, User user2, User user4){
        userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user4);
    }

    private static void preparePartyList(MachineService machineService,Party party1, Party party2, Party party3){
        machineService.addToPartyList(party1);
        machineService.addToPartyList(party2);
        machineService.addToPartyList(party3);
    }
}
