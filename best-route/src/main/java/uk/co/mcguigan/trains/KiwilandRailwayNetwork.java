package uk.co.mcguigan.trains;

class KiwilandRailwayNetwork {

    static final Station STATION_A = new Station("A");
    static final Station STATION_B = new Station("B");
    static final Station STATION_C = new Station("C");
    static final Station STATION_D = new Station("D");
    static final Station STATION_E = new Station("E");

    KiwilandRailwayNetwork() {
        constructRailwayNetwork();
    }

    private void constructRailwayNetwork() {
        STATION_A.setNextStations(new Route[]{new Route(STATION_B, 5), new Route(STATION_D, 5), new Route(STATION_E, 7)});
        STATION_B.setNextStations(new Route[]{new Route(STATION_C, 4)});
        STATION_C.setNextStations(new Route[]{new Route(STATION_E, 2), new Route(STATION_D, 8)});
        STATION_D.setNextStations(new Route[]{new Route(STATION_E, 6), new Route(STATION_C, 8)});
        STATION_E.setNextStations(new Route[]{new Route(STATION_B, 3)});
    }

}
