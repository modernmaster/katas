package uk.co.mcguigan.trains.RailwayCalculators;

import uk.co.mcguigan.trains.Route;
import uk.co.mcguigan.trains.Station;

public class NumberOfRoutesCalculator {

    public Integer calculateNumberOfRoutesWithExactNumberOfStops(final Station startingStation,
                                                                 final Station terminatingStation,
                                                                 final Integer exactNumberOfStops, final Integer numberOfMatches) {
        int currentNumberOfMatches = numberOfMatches;
        if (exactNumberOfStops >= 0) {
            Route[] routes = startingStation.getNextStations();
            for (Route route : routes) {
                currentNumberOfMatches = calculateNumberOfRoutesWithExactNumberOfStops(route.getNextStation(),
                        terminatingStation, exactNumberOfStops - 1, currentNumberOfMatches);
            }
        } else if (startingStation.getName().equals(terminatingStation.getName())) {
            currentNumberOfMatches += 1;
            return currentNumberOfMatches;
        }
        return currentNumberOfMatches;
    }

    public Integer calculateNumberOfRoutesUnderASetDistance(final Station startingStation, final Station terminatingStation,
                                                            final Integer distanceRemaining) {
        Integer matches = 0;
        return depthFirstTraversal(startingStation, terminatingStation, distanceRemaining, matches);
    }

    private static Integer depthFirstTraversal(final Station startingStation, final Station terminatingStation,
                                               final Integer distanceRemaining, final Integer matches) {
        Integer currentMatches = matches;
        Route[] routes = startingStation.getNextStations();
        for (Route route : routes) {
            if (route.getDistance() < distanceRemaining) {
                if (route.getNextStation().equals(terminatingStation)) {
                    currentMatches += 1;
                }
                currentMatches = depthFirstTraversal(route.getNextStation(), terminatingStation, distanceRemaining - route.getDistance(), currentMatches);
            }
        }
        return currentMatches;
    }
}
