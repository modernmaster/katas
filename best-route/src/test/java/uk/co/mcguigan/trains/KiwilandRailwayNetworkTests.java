package uk.co.mcguigan.trains;

import org.junit.Before;
import org.junit.Test;
import uk.co.mcguigan.trains.networkcalculators.RailwayCalculator;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class KiwilandRailwayNetworkTests {

    private RailwayNetwork railwayNetwork;

    @Before
    public void setUp() {
        new KiwilandRailwayNetwork();
        railwayNetwork = new RailwayCalculator();
    }

    @Test
    public void testCalculationOfTheDistanceOfRouteABCAs9() {
        //Given
        List<Station> railwayJourney = new LinkedList<Station>();
        railwayJourney.add(KiwilandRailwayNetwork.STATION_A);
        railwayJourney.add(KiwilandRailwayNetwork.STATION_B);
        railwayJourney.add(KiwilandRailwayNetwork.STATION_C);
        //When
        String distance = railwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #1: %s\n", distance);
        assertThat(distance, equalTo("9"));
    }

    @Test
    public void testCalculationOfTheDistanceOfRouteADAs5() {
        //Given
        List<Station> railwayJourney = new LinkedList<Station>();
        railwayJourney.add(KiwilandRailwayNetwork.STATION_A);
        railwayJourney.add(KiwilandRailwayNetwork.STATION_D);
        //When
        String distance = railwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #2: %s\n", distance);
        assertThat(distance, equalTo("5"));
    }

    @Test
    public void testCalculationOfTheDistanceOfRouteADCAs13() {
        //Given
        List<Station> railwayJourney = new LinkedList<Station>();
        railwayJourney.add(KiwilandRailwayNetwork.STATION_A);
        railwayJourney.add(KiwilandRailwayNetwork.STATION_D);
        railwayJourney.add(KiwilandRailwayNetwork.STATION_C);
        //When
        String distance = railwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #3: %s\n", distance);
        assertThat(distance, equalTo("13"));
    }

    @Test
    public void testCalculationOfTheDistanceOfRouteAEBCDAs22() {
        //Given
        List<Station> railwayJourney = new LinkedList<Station>();
        railwayJourney.add(KiwilandRailwayNetwork.STATION_A);
        railwayJourney.add(KiwilandRailwayNetwork.STATION_E);
        railwayJourney.add(KiwilandRailwayNetwork.STATION_B);
        railwayJourney.add(KiwilandRailwayNetwork.STATION_C);
        railwayJourney.add(KiwilandRailwayNetwork.STATION_D);
        //When
        String distance = railwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #4: %s\n", distance);
        assertThat(distance, equalTo("22"));
    }

    @Test
    public void testCalculationOfTheDistanceOfRouteAEDAsNoSuchRoute() {
        //Given
        List<Station> railwayJourney = new LinkedList<Station>();
        railwayJourney.add(KiwilandRailwayNetwork.STATION_A);
        railwayJourney.add(KiwilandRailwayNetwork.STATION_E);
        railwayJourney.add(KiwilandRailwayNetwork.STATION_D);
        //When
        String distance = railwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #5: %s\n", distance);
        assertThat(distance, equalTo("NO SUCH ROUTE"));
    }

    @Test
    public void testCalculationOfTheNumberOfTripsStartingAndFinishingAtCWithMaxThreeStopsAs2() {
        //Given
        Station start = KiwilandRailwayNetwork.STATION_C;
        Station finish = KiwilandRailwayNetwork.STATION_C;
        final Integer maximumNumberStops = 3;
        //When
        Integer numberOfRoutes = railwayNetwork.calculateNumberOfRoutesWithExactNumberOfStops(start, finish, maximumNumberStops);
        //Then
        assertThat(numberOfRoutes, equalTo(2));
        System.out.printf("Output #6: %s\n", numberOfRoutes);
    }

    @Test
    public void testCalculationTheNumberOfTripsStartingAtAAndFinishingAtCWithExactlyFourStopsAs3() {
        //Given
        Station start = KiwilandRailwayNetwork.STATION_A;
        Station finish = KiwilandRailwayNetwork.STATION_C;
        final Integer maximumNumberStops = 4;
        //When
        Integer numberOfRoutes = railwayNetwork.calculateNumberOfRoutesWithExactNumberOfStops(start, finish, maximumNumberStops);
        //Then
        assertThat(numberOfRoutes, equalTo(3));
        System.out.printf("Output #7: %s\n", numberOfRoutes);
    }

    @Test
    public void testCalculationOfTheShortestRouteFromAtoCInTermsOfDistanceToTravelAs9() {
        //Given
        Station startStation = KiwilandRailwayNetwork.STATION_A;
        Station endStation = KiwilandRailwayNetwork.STATION_C;
        //When
        String distance = railwayNetwork.calculateShortestDistance(startStation, endStation);
        //Then
        System.out.printf("Output #8: %s\n", distance);
        assertThat(distance, equalTo("9"));
    }

    @Test
    public void testCalculationOfTheShortestRouteFromBtoBInTermsOfDistanceToTravelAs9() {
        //Given
        final Station startStation = KiwilandRailwayNetwork.STATION_B;
        final Station endStation = KiwilandRailwayNetwork.STATION_B;
        //When
        String distance = railwayNetwork.calculateShortestDistance(startStation, endStation);
        //Then
        assertThat(distance, equalTo("9"));
        System.out.printf("Output #9: %s\n", distance);
    }

    @Test
    public void testCalculateTheNumberOfDifferentRoutesFromCToCWithADistanceOfLessThan30As7() {
        //Given
        final Station start = KiwilandRailwayNetwork.STATION_C;
        final Station finish = KiwilandRailwayNetwork.STATION_C;
        final Integer maximumNumberDistance = 30;
        //When
        Integer numberOfRoutes = railwayNetwork.calculateNumberOfRoutesUnderASetDistance(start, finish, maximumNumberDistance);
        //Then
        assertThat(numberOfRoutes, equalTo(7));
        System.out.printf("Output #10: %s\n", numberOfRoutes);
    }

}
