package uk.co.mcguigan.trains.RailwayCalculators;

import uk.co.mcguigan.trains.Route;
import uk.co.mcguigan.trains.Station;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathCalculators {
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
}
