package uk.co.mcguigan.trains;

public class Route {
    private final Station nextStation;
    private final Integer distance;

    public Route(final Station nextStation, final Integer distance) {
        this.nextStation = nextStation;
        this.distance = distance;
    }

    public Station getNextStation() {
        return nextStation;
    }

    public Integer getDistance() {
        return distance;
    }
}
