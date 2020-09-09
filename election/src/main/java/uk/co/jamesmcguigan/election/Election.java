package uk.co.jamesmcguigan.election;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Election {

    private final List<BallotBox> ballotBoxes;
    private final Map<String, Integer> candidates;

    public Election() {
        candidates = new HashMap<>();
        ballotBoxes = new ArrayList<>();
    }

    public void registerBallotBox(final BallotBox box) {
        ballotBoxes.add(box);
    }

    public void countVotes() {
        BallotBox ballotBox = ballotBoxes.get(0);
        List<Vote> votes = ballotBox.emptyBox();
        for (Vote vote : votes) {
            addVote(vote);
        }
    }

    public void countVotes(final LocalDateTime dateTime) {
        BallotBox ballotBox = ballotBoxes.get(0);
        List<Vote> votes = ballotBox.emptyBox();
        for (Vote vote : votes) {
            if (vote.getDateTime().isBefore(dateTime)) {
                addVote(vote);
            }
        }
    }

    private void addVote(final Vote vote) {
        String candidate = vote.getCandidate();
        Integer candidateVotes = 1;
        if (candidates.containsKey(candidate)) {
            candidateVotes = candidates.get(candidate);
            candidateVotes++;
        }
        candidates.put(candidate, candidateVotes);
    }

    public Map<String, Integer> getWinner() {

        return candidates.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

    }

}
