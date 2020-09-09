package uk.co.jamesmcguigan.election;

import java.time.LocalDateTime;

public class Vote {

    private final String candidate;
    private final LocalDateTime dateTime;


    public Vote(final String candidate, final LocalDateTime dateTime) {
        this.candidate = candidate;
        this.dateTime = dateTime;
    }

    public String getCandidate() {
        return candidate;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
