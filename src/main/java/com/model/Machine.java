package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {

    private State state;
    private Integer areaCode;
    private List<Vote> votedList;
    private List<Party> partyList;
    private Map<String,Integer> partyVoteCountMap;

    public Machine(String stateName, Integer areaCode){
        this.state = State.findByName(stateName);
        this.areaCode = areaCode;
        partyVoteCountMap = new HashMap<>();
        votedList = Vote.getVoterListByAreaCode(new ArrayList<>());
        partyList = new ArrayList<>();
    }

    public void addToVotedList(Vote vote){
        votedList.add(vote);
    }

    public boolean allowedVotingHere(User user){
        for(Vote vote: votedList){
            if(vote.getUser().getVoter_id() == user.getVoter_id()){
                return true;
            }
        }
        return false;
    }

    public List<Party> getPartyList() {
        // get Party list for all areaCode for the state
        return partyList;
    }

    public List<Vote> getVotedList() {
        //get all vote from different areaCode for state
        return votedList;
    }
    public void addToPartyList(Party party) {
        this.partyList.add(party);
    }

    public Map<String, Integer> getPartyVoteCountMap() {
        return partyVoteCountMap;
    }

    public void addVoteCountToParty(String partyName, Integer increment) {
        if(!partyVoteCountMap.containsKey(partyName)){
            partyVoteCountMap.put(partyName,increment);
        }else{
            partyVoteCountMap.put(partyName, partyVoteCountMap.get(partyName)+1);
        }
    }
}
