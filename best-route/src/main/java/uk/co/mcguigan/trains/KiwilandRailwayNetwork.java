package uk.co.mcguigan.trains;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KiwilandRailwayNetwork implements RailwayNetwork {

    private final Station[] stations;
    private static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

    public KiwilandRailwayNetwork(final Station[] stations) {
        this.stations = stations;
    }

    public Station getStation(final String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        return null;
    }

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

    public String calculateDistance(final List<Station> visitedStations) {
        Integer weight = 0;
        Iterator<Station> iterator = visitedStations.iterator();
        Station currentStation = iterator.next();
        while (iterator.hasNext()) {
            boolean matched = false;
            Route[] routes = currentStation.getNextStations();
            Station next = iterator.next();
            for (Route route : routes) {
                if (next.getName().equals(route.getNextStation().getName())) {
                    weight += route.getDistance();
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                return NO_SUCH_ROUTE;
            }
            currentStation = next;
        }
        return weight.toString();
    }

    public Integer calculateShortestDistance(final Station startingStation, final Station terminatingStation) {
        Queue<Station> queue = new LinkedList<Station>();
        startingStation.setMinimumDistance(0);
        queue.add(startingStation);
        breadthFirstSearch(queue, terminatingStation);
        return terminatingStation.getMinimumDistance();
    }

    private static void breadthFirstSearch(final Queue<Station> stationsToVisit, final Station terminatingStation) {
        if (stationsToVisit.isEmpty()) {
            return;
        }
        Station currentStation = stationsToVisit.remove();
        Route[] routes = currentStation.getNextStations();
        for (Route route : routes) {
            Station nextStation = route.getNextStation();
            if (nextStation.getMinimumDistance() == 0 || nextStation.getMinimumDistance() >= route.getDistance() + currentStation.getMinimumDistance()) {
                nextStation.setMinimumDistance(route.getDistance() + currentStation.getMinimumDistance());
                if (!route.getNextStation().equals(terminatingStation)) {
                    stationsToVisit.add(route.getNextStation());
                }
            }
        }
        breadthFirstSearch(stationsToVisit, terminatingStation);
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

    public static class RailwayNetworkBuilder {
        private final List<Station> stations;

        public RailwayNetworkBuilder() {
            this.stations = new LinkedList<Station>();
        }

        public RailwayNetworkBuilder withStation(final Station station) {
            this.stations.add(station);
            return this;
        }

        public KiwilandRailwayNetwork build() {

            return new KiwilandRailwayNetwork(this.stations.toArray(new Station[stations.size()]));
        }
    }

}
