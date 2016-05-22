package uk.co.mcguigan.trains;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RailwayNetwork implements Graph {

    private static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

    public RailwayNetwork(final Vertex[] stations) {
        this.stations = stations;
    }

    private final Vertex[] stations;

    public Vertex getVertex(final String name) {
        for (Vertex station : stations) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        return null;
    }

    public Integer calculateNumberOfRoutesWithExactNumberOfStops(final Vertex startingStation,
                                                                 final Vertex terminatingStation,
                                                                 final Integer exactNumberOfStops, Integer currentNumberOfMatches) {
        if (exactNumberOfStops >= 0) {
            Edge[] routes = startingStation.getEmanatingEdges();
            for (Edge route : routes) {
                currentNumberOfMatches = calculateNumberOfRoutesWithExactNumberOfStops(route.getTargetVertex(),
                        terminatingStation, exactNumberOfStops - 1, currentNumberOfMatches);
            }
        } else if (startingStation.getName().equals(terminatingStation.getName())) {
            currentNumberOfMatches += 1;
            return currentNumberOfMatches;
        }
        return currentNumberOfMatches;
    }

    public Integer calculateNumberOfRoutesUnderASetDistance(final Vertex startingStation, final Vertex terminatingStation,
                                                            final Integer distanceRemaining) {
        Integer matches = 0;
        return depthFirstTraversal(startingStation, terminatingStation, distanceRemaining, matches);
    }

    public String calculateDistance(final List<Vertex> visitedStations) {
        Integer weight = 0;
        Iterator<Vertex> iterator = visitedStations.iterator();
        Vertex currentStation = iterator.next();
        while (iterator.hasNext()) {
            boolean matched = false;
            Edge[] routes = currentStation.getEmanatingEdges();
            Vertex next = iterator.next();
            for (Edge route : routes) {
                if (next.getName().equals(route.getTargetVertex().getName())) {
                    weight += route.getWeight();
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

    public Integer calculateShortestDistance(final Vertex startingStation, final Vertex terminatingStation) {
        Queue<Vertex> queue = new LinkedList<Vertex>();
        startingStation.setMinimumDistance(0);
        queue.add(startingStation);
        breadthFirstSearch(queue, terminatingStation);
        return terminatingStation.getMinimumDistance();
    }

    private static void breadthFirstSearch(final Queue<Vertex> stationsToVisit, final Vertex terminatingStation) {
        if (stationsToVisit.isEmpty()) {
            return;
        }
        Vertex currentStation = stationsToVisit.remove();
        Edge[] routes = currentStation.getEmanatingEdges();
        for (Edge route : routes) {
            Vertex nextStation = route.getTargetVertex();
            if (nextStation.getMinimumDistance() == 0 || nextStation.getMinimumDistance() >= route.getWeight() + currentStation.getMinimumDistance()) {
                nextStation.setMinimumDistance(route.getWeight() + currentStation.getMinimumDistance());
                if (!route.getTargetVertex().equals(terminatingStation)) {
                    stationsToVisit.add(route.getTargetVertex());
                }
            }
        }
        breadthFirstSearch(stationsToVisit, terminatingStation);
    }

    private static Integer depthFirstTraversal(final Vertex startingStation, final Vertex terminatingStation,
                                               final Integer distanceRemaining, Integer matches) {
        Edge[] routes = startingStation.getEmanatingEdges();
        for (Edge route : routes) {
            if (route.getWeight() < distanceRemaining) {
                if (route.getTargetVertex().equals(terminatingStation)) {
                    matches += 1;
                }
                matches = depthFirstTraversal(route.getTargetVertex(), terminatingStation, distanceRemaining - route.getWeight(), matches);
            }
        }
        return matches;
    }

    public static class RailwayNetworkBuilder {
        private final List<Vertex> stations;

        public RailwayNetworkBuilder() {
            this.stations = new LinkedList<Vertex>();
        }

        public RailwayNetworkBuilder withStation(final Station station) {
            this.stations.add(station);
            return this;
        }

        public RailwayNetwork build() {

            return new RailwayNetwork(this.stations.toArray(new Vertex[stations.size()]));
        }
    }

}
