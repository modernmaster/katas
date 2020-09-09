package uk.co.jamesmcguigan.election;

import java.time.LocalDateTime;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ElectionTest {

    private Election election;

    @Before
    public void setUp() {
        election = new Election();
    }

    @Test
    public void testWinnerForFullElection() {
        Vote vote = new Vote(Candidates.FREDDY, LocalDateTime.now());
        Vote vote2 = new Vote(Candidates.FREDDY, LocalDateTime.now());
        Vote vote3 = new Vote(Candidates.JANE, LocalDateTime.now());
        Vote vote4 = new Vote(Candidates.JANE, LocalDateTime.now());
        Vote vote5 = new Vote(Candidates.JANE, LocalDateTime.now());
        Vote vote6 = new Vote(Candidates.JOHN, LocalDateTime.now());
        Vote vote7 = new Vote(Candidates.JIM, LocalDateTime.now());
        Vote vote8 = new Vote(Candidates.JIM, LocalDateTime.now());
        BallotBox ballotBox = new BallotBox();
        ballotBox.addVote(vote);
        ballotBox.addVote(vote2);
        ballotBox.addVote(vote3);
        ballotBox.addVote(vote4);
        ballotBox.addVote(vote5);
        ballotBox.addVote(vote6);
        ballotBox.addVote(vote7);
        ballotBox.addVote(vote8);
        election.registerBallotBox(ballotBox);
        election.countVotes();
        Map<String, Integer> positions = election.getWinner();
        String winningCandidate = positions.entrySet().iterator().next().getKey();
        assertThat(winningCandidate, equalTo(Candidates.JANE));
    }

    @Test
    public void testWinnerAtCertainPointInTimeElection() {
        Vote vote = new Vote(Candidates.FREDDY, LocalDateTime.now().minusDays(1));
        Vote vote2 = new Vote(Candidates.FREDDY, LocalDateTime.now().minusDays(1));
        Vote vote3 = new Vote(Candidates.JANE, LocalDateTime.now().plusDays(1));
        Vote vote4 = new Vote(Candidates.JANE, LocalDateTime.now().plusDays(1));
        Vote vote5 = new Vote(Candidates.JANE, LocalDateTime.now().plusDays(1));
        Vote vote6 = new Vote(Candidates.JOHN, LocalDateTime.now().plusDays(1));
        Vote vote7 = new Vote(Candidates.JIM, LocalDateTime.now().minusDays(1));
        Vote vote8 = new Vote(Candidates.JIM, LocalDateTime.now().plusDays(1));
        BallotBox ballotBox = new BallotBox();
        ballotBox.addVote(vote);
        ballotBox.addVote(vote2);
        ballotBox.addVote(vote3);
        ballotBox.addVote(vote4);
        ballotBox.addVote(vote5);
        ballotBox.addVote(vote6);
        ballotBox.addVote(vote7);
        ballotBox.addVote(vote8);
        election.registerBallotBox(ballotBox);
        election.countVotes(LocalDateTime.now());
        Map<String, Integer> positions = election.getWinner();
        String winningCandidate = positions.entrySet().iterator().next().getKey();
        assertThat(winningCandidate, equalTo(Candidates.FREDDY));
    }

}
