package uk.co.mcguigan.trains.networkcalculatorservices;

import uk.co.mcguigan.trains.Route;
import uk.co.mcguigan.trains.Station;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class DistanceCalculator {

    static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

    String calculateShortestDistance(final Station startingStation, final Station terminatingStation) {
        if (startingStation == null || terminatingStation == null) {
            return NO_SUCH_ROUTE;
        }
        Queue<Station> queue = new LinkedList<Station>();
        startingStation.setMinimumDistance(0);
        queue.add(startingStation);
        breadthFirstSearch(queue, terminatingStation);
        if (terminatingStation.getMinimumDistance() == 0) {
            return NO_SUCH_ROUTE;
        }
        return terminatingStation.getMinimumDistance().toString();
    }

    private static void breadthFirstSearch(final Queue<Station> stationsToVisit, final Station terminatingStation) {
        if (stationsToVisit.isEmpty()) {
            return;
        }
        Station currentStation = stationsToVisit.remove();
        if (currentStation == null) {
            return;
        }
        Route[] routes = currentStation.getNextStations();
        if (routes == null) {
            return;
        }
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

    String calculateDistance(final List<Station> visitedStations) {
        if (visitedStations == null || visitedStations.isEmpty()) {
            return NO_SUCH_ROUTE;
        }
        Integer currentDistance = 0;
        Iterator<Station> iterator = visitedStations.iterator();
        Station currentStation = iterator.next();
        while (iterator.hasNext()) {
            boolean matched = false;
            Route[] routes = currentStation.getNextStations();
            if (routes == null) {
                return NO_SUCH_ROUTE;
            }
            Station nextStation = iterator.next();
            for (Route route : routes) {
                if (nextStation.getName().equals(route.getNextStation().getName())) {
                    currentDistance += route.getDistance();
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                return NO_SUCH_ROUTE;
            }
            currentStation = nextStation;
        }
        return currentDistance.toString();
    }
}
