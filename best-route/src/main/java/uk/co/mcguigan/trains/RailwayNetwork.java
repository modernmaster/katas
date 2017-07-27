package uk.co.mcguigan.trains;

import java.util.List;

public interface RailwayNetwork {

    Station getStation(String name);

    Integer calculateNumberOfRoutesWithExactNumberOfStops(final Station startingStation, final Station terminatingStation,
                                                          final Integer exactNumberOfStops, final Integer currentNumberOfMatches);

    Integer calculateShortestDistance(final Station startingStation, final Station terminatingStation);

    String calculateDistance(final List<Station> visitedStations);

    Integer calculateNumberOfRoutesUnderASetDistance(final Station startingStation, final Station terminatingStation, final Integer distanceRemaining);
}
