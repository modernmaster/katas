package uk.co.mcguigan.trains;

import static java.lang.Integer.MAX_VALUE;

public class Station implements Vertex, Comparable<Vertex>  {
    private final String name;
    private Edge[] emanatingEdges;
    private Integer minDistance;

    public Station(final String station) {
        name = station;
        minDistance = MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public Integer getMinimumDistance() {
        return minDistance;
    }

    public void setMinimumDistance(final Integer distance) {
        this.minDistance = distance;
    }

    public Edge[] getEmanatingEdges() {
        return emanatingEdges;
    }

    public void setEmanatingEdges(final Edge[] emanatingEdges) {
        this.emanatingEdges = emanatingEdges;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Vertex other) {
        return Integer.compare(minDistance, other.getMinimumDistance());
    }
}
