package uk.co.jamesmcguigan.election;

import java.util.ArrayList;
import java.util.List;

class BallotBox {

  private List<Vote> votes;

  BallotBox() {
    this.votes = new ArrayList<>();
  }

  public void addVote(final Vote vote) {
    votes.add(vote);
  }

  List<Vote> emptyBox() {
    return votes;
  }
}
