package uk.co.mcguigan.trains.networkcalculatorservices;

import org.junit.Before;
import org.junit.Test;
import uk.co.mcguigan.trains.Route;
import uk.co.mcguigan.trains.Station;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class NumberOfRoutesCalculatorTests {
    private static final Station STATION_A = new Station("A");
    private static final Station STATION_B = new Station("B");
    private static final Station STATION_C = new Station("C");
    private static final Station STATION_D = new Station("D");
    private static final Station STATION_E = new Station("E");
    private NumberOfRoutesCalculator numberOfRoutesCalculator;

    @Before
    public void setUp() {
        numberOfRoutesCalculator = new NumberOfRoutesCalculator();
    }

    @Test
    public void testZeroStopsForValidRouteWillReturn1Route() {
        Integer numberOfStops = 0;
        STATION_A.setNextStations(new Route[]{new Route(STATION_B, 5), new Route(STATION_D, 5), new Route(STATION_E, 7)});
        int distance = numberOfRoutesCalculator.calculateNumberOfRoutesWithExactNumberOfStops(STATION_A, STATION_B, numberOfStops);
        assertThat(distance, equalTo(1));
    }

    @Test
    public void testZeroStopsForInvalidRouteWillReturn0Route() {
        Integer numberOfStops = 0;
        STATION_A.setNextStations(new Route[]{new Route(STATION_B, 5), new Route(STATION_D, 5), new Route(STATION_E, 7)});
        int distance = numberOfRoutesCalculator.calculateNumberOfRoutesWithExactNumberOfStops(STATION_A, STATION_C, numberOfStops);
        assertThat(distance, equalTo(0));
    }

    @Test
    public void testNullStartStationWillReturn0Distance() {
        Integer integer = 0;
        int distance = numberOfRoutesCalculator.calculateNumberOfRoutesWithExactNumberOfStops(null, STATION_B, integer);
        assertThat(distance, equalTo(0));
    }

    @Test
    public void testNullTerminatingStationWillReturn0Distance() {
        Integer integer = 0;
        int distance = numberOfRoutesCalculator.calculateNumberOfRoutesWithExactNumberOfStops(STATION_A, null, integer);
        assertThat(distance, equalTo(0));
    }

    @Test
    public void testTenStopsUnderASetDistanceForValidRouteWillReturn1Route() {
        Integer numberOfStops = 10;
        STATION_A.setNextStations(new Route[]{new Route(STATION_B, 5), new Route(STATION_D, 5), new Route(STATION_E, 7)});
        int distance = numberOfRoutesCalculator.calculateNumberOfRoutesUnderASetDistance(STATION_A, STATION_B, numberOfStops);
        assertThat(distance, equalTo(1));
    }

    @Test
    public void testZeroStopsUnderASetDistanceForInvalidRouteWillReturn0Route() {
        Integer maximumDistance = 0;
        STATION_A.setNextStations(new Route[]{new Route(STATION_B, 5), new Route(STATION_D, 5), new Route(STATION_E, 7)});
        int distance = numberOfRoutesCalculator.calculateNumberOfRoutesUnderASetDistance(STATION_A, STATION_C, maximumDistance);
        assertThat(distance, equalTo(0));
    }

    @Test
    public void testNullStartStationUnderASetDistanceWillReturn0Distance() {
        Integer maximumDistance = 0;
        int distance = numberOfRoutesCalculator.calculateNumberOfRoutesUnderASetDistance(null, STATION_B, maximumDistance);
        assertThat(distance, equalTo(0));
    }

    @Test
    public void testNullTerminatingStationUnderASetDistanceWillReturn0Distance() {
        Integer maximumDistance = 0;
        int distance = numberOfRoutesCalculator.calculateNumberOfRoutesUnderASetDistance(STATION_A, null, maximumDistance);
        assertThat(distance, equalTo(0));
    }

}