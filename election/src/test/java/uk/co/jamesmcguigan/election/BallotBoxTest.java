package uk.co.jamesmcguigan.election;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BallotBoxTest {

    private BallotBox ballotBox;

    @Before
    public void setUp() {
        ballotBox = new BallotBox();
    }

    @Test
    public void testShouldAddOneVoteAndReturnIt() {

        final String decision = "Jimmy";
        final DateTime placed = DateTime.now();
        Vote vote = new Vote(placed, decision);
        ballotBox.add(vote);
        assertThat(ballotBox.next(), equalTo(vote));
    }

    @Test
    public void testShouldAddTwoVoteAndReturnTheLastVoteIt() {

        final String decision = "Jimmy";
        final String decision2 = "Jimmy2";
        Vote vote1 = new Vote(DateTime.now(), decision);
        Vote vote2 = new Vote(DateTime.now(), decision2);
        ballotBox.add(vote1);
        ballotBox.add(vote2);
        ballotBox.reset();
        assertThat(ballotBox.next(), equalTo(vote1));
        assertThat(ballotBox.next(), equalTo(vote2));
    }

}
