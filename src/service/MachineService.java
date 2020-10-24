package service;

import model.*;

import java.util.List;
import java.util.Map;

public class MachineService {

    Machine machine;

    public MachineService(String state, Integer areaCode) {
        this.machine = new Machine(state, areaCode);
    }

    public boolean vote(User user, Party party) {

        if (!user.isBlackListed() && machine.allowedVotingHere(user)) {
            if (user.hasVoted()) {
                System.out.println(user.getName() + ", You have voted again"); //  for now marking all votes voting twice as blacklisted even voting the same party in same area
                user.markBlackListed();
                return false;
            }
            Vote vote = new Vote(user, party);
            if (!validParty(party)) {
                return false;
            }
            machine.addVoteCountToParty(party.getName(), 1);
            user.setAsVoted();
            System.out.println(user.getName() + " voted successfully");
            return true;
        }
        if (!machine.allowedVotingHere(user)) {
            System.out.println(user.getName() + ", You are not in voters list");
        }
        return false;
    }

    public String findWinnerParty() {

        List<Party> partyList = machine.getPartyList();
        List<Vote> voteList = machine.getVotedList();
        Map<String, Integer> partyVoteCountList = machine.getPartyVoteCountMap();


        int voteCount = 0;
        String winner = null;
        int winnerPartyCount = 0;
        for (Map.Entry maping : partyVoteCountList.entrySet()) {

            if ((int) maping.getValue() > voteCount) {
                voteCount = (int) maping.getValue();
                winnerPartyCount = 1;
                winner = (String) maping.getKey();
            } else if ((int) maping.getValue() == voteCount) {
                winnerPartyCount++;
            }

            if (winnerPartyCount > 1) {
                winner = null;
            }
        }

        return winner;
    }

    public void addToPartyList(Party party) {
        if (party != null) {
            machine.addToPartyList(party);
        }
    }

    private boolean validParty(Party party) {
        for (Party partyFromList : machine.getPartyList()) {
            if (partyFromList.getName().equalsIgnoreCase(party.getName())) {
                return true;
            }
        }
        return false;
    }
}
