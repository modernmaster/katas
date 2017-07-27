package uk.co.mcguigan.trains;

import java.util.List;

public interface Graph {

    Vertex getVertex(String name);

    Integer calculateNumberOfRoutesWithExactNumberOfStops(final Vertex startingStation, final Vertex terminatingStation,
                                                          final Integer exactNumberOfStops, Integer currentNumberOfMatches);

    Integer calculateShortestDistance(final Vertex sourceVertex, final Vertex targetVertex);

    String calculateDistance(final List<Vertex> visitedVertices);

    Integer calculateNumberOfRoutesUnderASetDistance(final Vertex sourceVertex, final Vertex targetVertex, final Integer distanceRemaining);
}
