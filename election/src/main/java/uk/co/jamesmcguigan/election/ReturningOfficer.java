package uk.co.jamesmcguigan.election;

import org.joda.time.DateTime;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ReturningOfficer {

    private BallotBox ballotBox;

    public ReturningOfficer(final BallotBox ballotBox) {
        this.ballotBox = ballotBox;
    }


    public int getNumberOfVotes() {

        int numberOfVotes = 0;
        Vote vote = ballotBox.next();
        while (vote != null) {
            vote = ballotBox.next();
            numberOfVotes++;
        }
        return numberOfVotes;
    }

    public String calculateWinner() {
        Map<String, Integer> votes = new HashMap<String, Integer>();
        Vote vote = ballotBox.next();
        while (vote != null) {
            Integer currentTotal = 0;
            if (votes.containsKey(vote.getDecision())) {
                currentTotal = votes.get(vote.getDecision());
            }
            votes.put(vote.getDecision(), ++currentTotal);
            vote = ballotBox.next();
        }
        Map<String, Integer> sortedMap = sortByValue(votes);
        Map.Entry<String, Integer> entry = sortedMap.entrySet().iterator().next();
        return entry.getKey();
    }

    public static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap) {
        TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(new ValueComparator(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }

    public String calculateWinnerForAGivenTime(DateTime cutoff) {
        Map<String, Integer> votes = new HashMap<String, Integer>();
        Vote vote = ballotBox.next();
        while (vote != null && vote.getTimePlaced().isBefore(cutoff)) {
            Integer currentTotal = 0;
            if (votes.containsKey(vote.getDecision())) {
                currentTotal = votes.get(vote.getDecision());
            }
            votes.put(vote.getDecision(), ++currentTotal);
            vote = ballotBox.next();
        }
        Map<String, Integer> sortedMap = sortByValue(votes);
        Map.Entry<String, Integer> entry = sortedMap.entrySet().iterator().next();
        return entry.getKey();
    }
}

class ValueComparator implements Comparator {
    private Map<String, Integer> map;

    ValueComparator(Map<String, Integer> map) {
        this.map = map;
    }

    public int compare(Object keyA, Object keyB) {
        Comparable<Integer> valueA = map.get(keyA);
        Comparable valueB = map.get(keyB);
        return valueB.compareTo(valueA);
    }
}
