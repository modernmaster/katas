package uk.co.jamesmcguigan.election;

import org.joda.time.DateTime;

public class Vote {

    private DateTime timePlaced;
    private String decision;
    private Vote next;

    public Vote (final DateTime timePlaced, final String decision) {
        this.timePlaced = timePlaced;
        this.decision = decision;
    }

    public DateTime getTimePlaced() {
        return timePlaced;
    }

    public String getDecision() {
        return decision;
    }

    public void setNext(Vote next) {
        this.next = next;
    }

    public Vote getNext() {
        return next;
    }
}
