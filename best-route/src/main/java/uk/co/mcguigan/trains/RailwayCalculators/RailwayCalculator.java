package uk.co.mcguigan.trains.RailwayCalculators;

import uk.co.mcguigan.trains.RailwayNetwork;
import uk.co.mcguigan.trains.Station;

import java.util.List;

public class RailwayCalculator implements RailwayNetwork {

    public static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

    private ShortestPathCalculators shortestPathCalculators;
    private DistanceCalculator distanceCalculator;
    private NumberOfRoutesCalculator numberOfRoutesCalculator;

    public RailwayCalculator() {
        shortestPathCalculators = new ShortestPathCalculators();
        distanceCalculator = new DistanceCalculator();
        numberOfRoutesCalculator = new NumberOfRoutesCalculator();
    }

    public Integer calculateNumberOfRoutesUnderASetDistance(final Station startingStation, final Station terminatingStation,
                                                            final Integer distanceRemaining) {
        return numberOfRoutesCalculator.calculateNumberOfRoutesUnderASetDistance(startingStation, terminatingStation, distanceRemaining);
    }

    public Integer calculateShortestDistance(Station startingStation, Station terminatingStation) {
        return shortestPathCalculators.calculateShortestDistance(startingStation, terminatingStation);
    }

    public String calculateDistance(final List<Station> visitedStations) {
        return distanceCalculator.calculateDistance(visitedStations);
    }

    public Integer calculateNumberOfRoutesWithExactNumberOfStops(final Station startingStation,
                                                                 final Station terminatingStation,
                                                                 final Integer exactNumberOfStops, final Integer numberOfMatches) {
        return numberOfRoutesCalculator.calculateNumberOfRoutesWithExactNumberOfStops(startingStation, terminatingStation, exactNumberOfStops, numberOfMatches);
    }
}
