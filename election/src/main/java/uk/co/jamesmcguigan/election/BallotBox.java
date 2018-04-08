package uk.co.jamesmcguigan.election;

public class BallotBox {

    private Vote head;
    private Vote current;


    public void add(Vote vote) {
        if(head == null) {
            head = vote;
        } else {
            current.setNext(vote);
        }
        current = vote;
    }

    public Vote next() {
        Vote prev = current;
        current = prev.getNext();
        return prev;
    }

    public void reset() {
        current = head;
    }



}
