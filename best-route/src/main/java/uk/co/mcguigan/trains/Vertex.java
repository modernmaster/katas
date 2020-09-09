package uk.co.mcguigan.trains;

public interface Vertex {
    String getName();

    Edge[] getEmanatingEdges();

    void setEmanatingEdges(final Edge[] emanatingEdges);

    Integer getMinimumDistance();

    void setMinimumDistance(final Integer distance);
}
