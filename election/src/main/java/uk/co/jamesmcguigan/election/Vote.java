package uk.co.jamesmcguigan.election;

import java.time.LocalDateTime;

public class Vote {

  private String candidate;
  private LocalDateTime dateTime;


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
