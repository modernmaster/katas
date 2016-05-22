package uk.co.mcguigan.trains;

public interface Vertex {
    String getName();

    void setEmanatingEdges(final Edge[] emanatingEdges);

    Edge[] getEmanatingEdges();

    Integer getMinimumDistance();

    void setMinimumDistance(final Integer distance);
}
