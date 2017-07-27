package uk.co.mcguigan.trains.networkcalculators;

import uk.co.mcguigan.trains.RailwayNetwork;
import uk.co.mcguigan.trains.Station;

import java.util.List;

public class RailwayCalculator implements RailwayNetwork {

    private DistanceCalculator distanceCalculator;
    private NumberOfRoutesCalculator numberOfRoutesCalculator;

    public RailwayCalculator() {
        distanceCalculator = new DistanceCalculator();
        numberOfRoutesCalculator = new NumberOfRoutesCalculator();
    }

    public Integer calculateNumberOfRoutesUnderASetDistance(final Station startingStation, final Station terminatingStation,
                                                            final Integer maximumDistance) {
        return numberOfRoutesCalculator.calculateNumberOfRoutesUnderASetDistance(startingStation, terminatingStation, maximumDistance);
    }

    public String calculateShortestDistance(final Station startingStation, final Station terminatingStation) {
        return distanceCalculator.calculateShortestDistance(startingStation, terminatingStation);
    }

    public String calculateDistance(final List<Station> visitedStations) {
        return distanceCalculator.calculateDistance(visitedStations);
    }

    public Integer calculateNumberOfRoutesWithExactNumberOfStops(final Station startingStation,
                                                                 final Station terminatingStation,
                                                                 final Integer exactNumberOfStops) {
        return numberOfRoutesCalculator.calculateNumberOfRoutesWithExactNumberOfStops(startingStation, terminatingStation, exactNumberOfStops);
    }
}
