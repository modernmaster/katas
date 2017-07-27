package uk.co.mcguigan.trains.RailwayCalculators;

import uk.co.mcguigan.trains.Route;
import uk.co.mcguigan.trains.Station;

import java.util.Iterator;
import java.util.List;

import static uk.co.mcguigan.trains.RailwayCalculators.RailwayCalculator.NO_SUCH_ROUTE;

public class DistanceCalculator {

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

}
