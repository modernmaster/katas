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

        final int stationDistanceAB = 5;
        final int stationDistanceAD = 5;
        final int stationDistanceAE = 7;
        final int stationDistanceBC = 4;
        final int stationDistanceCE = 2;
        final int stationDistanceCD = 8;
        final int stationDistanceDE = 6;
        final int stationDistanceDC = 8;
        final int stationDistanceEB = 3;
        STATION_A.setNextStations(new Route[]{new Route(STATION_B, stationDistanceAB), new Route(STATION_D, stationDistanceAD),
                new Route(STATION_E, stationDistanceAE)});
        STATION_B.setNextStations(new Route[]{new Route(STATION_C, stationDistanceBC)});
        STATION_C.setNextStations(new Route[]{new Route(STATION_E, stationDistanceCE), new Route(STATION_D, stationDistanceCD)});
        STATION_D.setNextStations(new Route[]{new Route(STATION_E, stationDistanceDE), new Route(STATION_C, stationDistanceDC)});
        STATION_E.setNextStations(new Route[]{new Route(STATION_B, stationDistanceEB)});
    }

}
