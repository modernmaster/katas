package uk.co.mcguigan.trains;

public interface Edge {

    Vertex getNextStation();

    Integer getDistance();
}
