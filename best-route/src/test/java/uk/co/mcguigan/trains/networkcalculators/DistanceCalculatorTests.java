package uk.co.mcguigan.trains.networkcalculators;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import uk.co.mcguigan.trains.Route;
import uk.co.mcguigan.trains.Station;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static uk.co.mcguigan.trains.networkcalculators.DistanceCalculator.NO_SUCH_ROUTE;

public class DistanceCalculatorTests {

    private static final Station STATION_A = new Station("A");
    private static final Station STATION_B = new Station("B");
    private static final Station STATION_C = new Station("C");
    private static final Station STATION_D = new Station("D");
    private static final Station STATION_E = new Station("E");
    private DistanceCalculator distanceCalculator;

    @Before
    public void setup() {
        distanceCalculator = new DistanceCalculator();
    }

    @Test
    public void testNullWillReturnNoSuchRoute() {

        String distance = distanceCalculator.calculateDistance(null);
        assertThat(distance, equalTo(NO_SUCH_ROUTE));
    }

    @Test
    public void testEmptyWillReturnNoSuchRoute() {

        List<Station> stationList = new LinkedList<Station>();
        String distance = distanceCalculator.calculateDistance(stationList);
        assertThat(distance, equalTo(NO_SUCH_ROUTE));
    }

    @Test
    public void testInvalidRouteWillReturnNoSuchRoute() {

        STATION_A.setNextStations(new Route[]{new Route(STATION_B, 5), new Route(STATION_D, 5), new Route(STATION_E, 7)});
        List<Station> stationsToBeVisited = new LinkedList<Station>();
        stationsToBeVisited.add(STATION_D);
        stationsToBeVisited.add(STATION_E);
        String distance = distanceCalculator.calculateDistance(stationsToBeVisited);
        assertThat(distance, equalTo(NO_SUCH_ROUTE));
    }

    @Test
    public void testValidRouteBetweenTwoStationsWillReturnDistanceOf7() {

        STATION_A.setNextStations(new Route[]{new Route(STATION_B, 5), new Route(STATION_D, 5), new Route(STATION_E, 7)});
        STATION_D.setNextStations(new Route[]{new Route(STATION_C, 10)});
        List<Station> stationsToBeVisited = new LinkedList<Station>();
        stationsToBeVisited.add(STATION_A);
        stationsToBeVisited.add(STATION_E);
        String distance = distanceCalculator.calculateDistance(stationsToBeVisited);
        assertThat(distance, equalTo("7"));
    }

    @Test
    public void testValidBetweenThreeStationsRouteWillReturnDistanceOf15() {

        STATION_A.setNextStations(new Route[]{new Route(STATION_B, 5), new Route(STATION_D, 5), new Route(STATION_E, 7)});
        STATION_D.setNextStations(new Route[]{new Route(STATION_C, 10)});
        List<Station> stationsToBeVisited = new LinkedList<Station>();
        stationsToBeVisited.add(STATION_A);
        stationsToBeVisited.add(STATION_D);
        stationsToBeVisited.add(STATION_C);
        String distance = distanceCalculator.calculateDistance(stationsToBeVisited);
        assertThat(distance, equalTo("15"));
    }

    @Test
    public void testNullWillReturnNoSuchRouteForShortestDistance() {
        String distance = distanceCalculator.calculateShortestDistance(null, STATION_B);
        assertThat(distance, equalTo(NO_SUCH_ROUTE));
    }

    @Test
    public void testEmptyWillReturnNoSuchRouteForShortestDistance() {
        String distance = distanceCalculator.calculateShortestDistance(STATION_A, null);
        assertThat(distance, equalTo(NO_SUCH_ROUTE));
    }

    @Test
    public void testValidRouteForCalculatingShortestPathWillReturnX() {
        STATION_A.setNextStations(new Route[]{new Route(STATION_B, 5), new Route(STATION_D, 5), new Route(STATION_E, 7)});
        STATION_D.setNextStations(new Route[]{new Route(STATION_C, 10)});
        String distance = distanceCalculator.calculateShortestDistance(STATION_A, STATION_D);
        assertThat(distance, Matchers.equalTo("5"));
    }

    @Test
    public void testValidRouteForCalculatingShortestPathWillReturnNoSuchRoute() {
        STATION_A.setNextStations(new Route[]{new Route(STATION_B, 5), new Route(STATION_D, 5), new Route(STATION_E, 7)});
        STATION_D.setNextStations(new Route[]{new Route(STATION_C, 10)});
        String distance = distanceCalculator.calculateShortestDistance(STATION_C, STATION_A);
        assertThat(distance, Matchers.equalTo(NO_SUCH_ROUTE));
    }

}
