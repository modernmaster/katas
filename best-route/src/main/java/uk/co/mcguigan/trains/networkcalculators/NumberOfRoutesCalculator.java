package uk.co.mcguigan.trains.networkcalculators;

import uk.co.mcguigan.trains.Route;
import uk.co.mcguigan.trains.Station;

class NumberOfRoutesCalculator {

    private static Integer depthFirstTraversal(final Station startingStation, final Station terminatingStation,
                                               final Integer distanceRemaining, final Integer matches) {
        if (startingStation == null || terminatingStation == null) {
            return 0;
        }

        Integer currentMatches = matches;
        Route[] routes = startingStation.getNextStations();
        if (routes == null) {
            return currentMatches;
        }

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

    Integer calculateNumberOfRoutesWithExactNumberOfStops(final Station startingStation,
                                                          final Station terminatingStation,
                                                          final Integer exactNumberOfStops) {
        int numberOfMatches = 0;
        return calculateNumberOfRoutesWithExactNumberOfStops(startingStation, terminatingStation, exactNumberOfStops, numberOfMatches);
    }

    private Integer calculateNumberOfRoutesWithExactNumberOfStops(final Station startingStation,
                                                                  final Station terminatingStation,
                                                                  final Integer exactNumberOfStops, final Integer numberOfMatches) {
        int currentNumberOfMatches = numberOfMatches;
        if (startingStation == null || terminatingStation == null) {
            return 0;
        }
        if (exactNumberOfStops >= 0) {
            Route[] routes = startingStation.getNextStations();
            if (routes == null) {
                return 0;
            }
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

    Integer calculateNumberOfRoutesUnderASetDistance(final Station startingStation, final Station terminatingStation,
                                                     final Integer maximumDistance) {
        Integer matches = 0;
        return depthFirstTraversal(startingStation, terminatingStation, maximumDistance, matches);
    }
}
