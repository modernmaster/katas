package uk.co.jamesmcguigan.election;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturningOfficerTest {

    private ReturningOfficer returningOfficer;
    private BallotBox ballotBox;
    private final static String CANDIDATE_1 = "Jimmy";
    private final static String CANDIDATE_2 = "Sara";


    @Before
    public void setUp() {
        ballotBox = mock(BallotBox.class);
        returningOfficer = new ReturningOfficer(ballotBox);
    }

    @Test
    public void testCountNumberOfVotesInSystem() {
        when(ballotBox.next()).thenReturn(
                new Vote(DateTime.now(), CANDIDATE_1),
                new Vote(DateTime.now(), CANDIDATE_1),
                new Vote(DateTime.now(), CANDIDATE_1),
                new Vote(DateTime.now(), CANDIDATE_1),
                new Vote(DateTime.now(), CANDIDATE_1),
                null);
        int numberOfVotes = returningOfficer.getNumberOfVotes();
        verify(ballotBox, times(6)).next();
        assertThat(numberOfVotes, equalTo(numberOfVotes));
    }

    @Test
    public void testWinnerShouldBeCandidate1() {
        when(ballotBox.next()).thenReturn(
                new Vote(DateTime.now(), CANDIDATE_1),
                new Vote(DateTime.now(), CANDIDATE_1),
                new Vote(DateTime.now(), CANDIDATE_1),
                new Vote(DateTime.now(), CANDIDATE_2),
                new Vote(DateTime.now(), CANDIDATE_2),
                null);

        String winningCandidate = returningOfficer.calculateWinner();

        assertThat(winningCandidate, equalTo(CANDIDATE_1));
    }

    @Test
    public void testWinnerShouldBeCandidate1ForAGivenTime() {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        DateTime cutoff = formatter.parseDateTime("01/01/2000 01:00:03");
        when(ballotBox.next()).thenReturn(
                new Vote(formatter.parseDateTime("01/01/2000 01:00:01"), CANDIDATE_1),
                new Vote(formatter.parseDateTime("01/01/2000 01:00:02"), CANDIDATE_1),
                new Vote(formatter.parseDateTime("01/01/2000 01:00:03"), CANDIDATE_1),
                new Vote(formatter.parseDateTime("01/01/2000 01:00:04"), CANDIDATE_2),
                new Vote(formatter.parseDateTime("01/01/2000 01:00:05"), CANDIDATE_2),
                new Vote(formatter.parseDateTime("01/01/2000 01:00:06"), CANDIDATE_2),
                new Vote(formatter.parseDateTime("01/01/2000 01:00:07"), CANDIDATE_2),
                null);

        String winningCandidate = returningOfficer.calculateWinnerForAGivenTime(cutoff);

        assertThat(winningCandidate, equalTo(CANDIDATE_1));
    }

    @Test
    public void testWinnerShouldBeCandidate2ForAGivenTime() {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        DateTime cutoff = formatter.parseDateTime("01/01/2000 01:00:10");
        when(ballotBox.next()).thenReturn(
                new Vote(formatter.parseDateTime("01/01/2000 01:00:01"), CANDIDATE_1),
                new Vote(formatter.parseDateTime("01/01/2000 01:00:02"), CANDIDATE_1),
                new Vote(formatter.parseDateTime("01/01/2000 01:00:03"), CANDIDATE_1),
                new Vote(formatter.parseDateTime("01/01/2000 01:00:04"), CANDIDATE_2),
                new Vote(formatter.parseDateTime("01/01/2000 01:00:05"), CANDIDATE_2),
                new Vote(formatter.parseDateTime("01/01/2000 01:00:06"), CANDIDATE_2),
                new Vote(formatter.parseDateTime("01/01/2000 01:00:07"), CANDIDATE_2),
                null);

        String winningCandidate = returningOfficer.calculateWinnerForAGivenTime(cutoff);

        assertThat(winningCandidate, equalTo(CANDIDATE_2));
    }
}