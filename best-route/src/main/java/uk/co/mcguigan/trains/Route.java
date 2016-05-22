package uk.co.mcguigan.trains;

public class Route implements Edge {
    private final Vertex target;
    private final Integer weight;

    public Route(final Vertex target, final Integer weight) {
        this.target = target;
        this.weight = weight;
    }

    public Vertex getTargetVertex() {
        return target;
    }

    public Integer getWeight() {
        return weight;
    }
}
