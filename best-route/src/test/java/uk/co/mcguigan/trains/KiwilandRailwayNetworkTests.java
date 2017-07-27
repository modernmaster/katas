package uk.co.mcguigan.trains;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class KiwilandRailwayNetworkTests {

    private RailwayNetwork kiwilandRailwayNetwork;

    @Before
    public void setUp() {
        kiwilandRailwayNetwork = constructRailwayNetwork();
    }

    @Test
    public void testCalculationOfTheDistanceOfRouteABCAs9() {
        //Given
        List<Station> railwayJourney = new LinkedList<Station>();
        railwayJourney.add(kiwilandRailwayNetwork.getStation("A"));
        railwayJourney.add(kiwilandRailwayNetwork.getStation("B"));
        railwayJourney.add(kiwilandRailwayNetwork.getStation("C"));
        //When
        String distance = kiwilandRailwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #1: %s\n", distance);
        assertThat(distance, equalTo("9"));
    }

    @Test
    public void testCalculationOfTheDistanceOfRouteADAs5() {
        //Given
        List<Station> railwayJourney = new LinkedList<Station>();
        railwayJourney.add(kiwilandRailwayNetwork.getStation("A"));
        railwayJourney.add(kiwilandRailwayNetwork.getStation("D"));
        //When
        String distance = kiwilandRailwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #2: %s\n", distance);
        assertThat(distance, equalTo("5"));
    }

    @Test
    public void testCalculationOfTheDistanceOfRouteADCAs13() {
        //Given
        List<Station> railwayJourney = new LinkedList<Station>();
        railwayJourney.add(kiwilandRailwayNetwork.getStation("A"));
        railwayJourney.add(kiwilandRailwayNetwork.getStation("D"));
        railwayJourney.add(kiwilandRailwayNetwork.getStation("C"));
        //When
        String distance = kiwilandRailwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #3: %s\n", distance);
        assertThat(distance, equalTo("13"));
    }

    @Test
    public void testCalculationOfTheDistanceOfRouteAEBCDAs22() {
        //Given
        List<Station> railwayJourney = new LinkedList<Station>();
        railwayJourney.add(kiwilandRailwayNetwork.getStation("A"));
        railwayJourney.add(kiwilandRailwayNetwork.getStation("E"));
        railwayJourney.add(kiwilandRailwayNetwork.getStation("B"));
        railwayJourney.add(kiwilandRailwayNetwork.getStation("C"));
        railwayJourney.add(kiwilandRailwayNetwork.getStation("D"));
        //When
        String distance = kiwilandRailwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #4: %s\n", distance);
        assertThat(distance, equalTo("22"));
    }

    @Test
    public void testCalculationOfTheDistanceOfRouteAEDAsNoSuchRoute() {
        //Given
        List<Station> railwayJourney = new LinkedList<Station>();
        railwayJourney.add(kiwilandRailwayNetwork.getStation("A"));
        railwayJourney.add(kiwilandRailwayNetwork.getStation("E"));
        railwayJourney.add(kiwilandRailwayNetwork.getStation("D"));
        //When
        String distance = kiwilandRailwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #5: %s\n", distance);
        assertThat(distance, equalTo("NO SUCH ROUTE"));
    }

    @Test
    public void testCalculationOfTheNumberOfTripsStartingAndFinishingAtCWithMaxThreeStopsAs2() {
        //Given
        Station start = kiwilandRailwayNetwork.getStation("C");
        Station finish = kiwilandRailwayNetwork.getStation("C");
        final Integer maximumNumberStops = 3;
        Integer currentNumberOfStops = 0;
        //When
        Integer numberOfRoutes = kiwilandRailwayNetwork.calculateNumberOfRoutesWithExactNumberOfStops(start, finish, maximumNumberStops, currentNumberOfStops);
        //Then
        assertThat(numberOfRoutes, equalTo(2));
        System.out.printf("Output #6: %s\n", numberOfRoutes);
    }

    @Test
    public void testCalculationTheNumberOfTripsStartingAtAAndFinishingAtCWithExactlyFourStopsAs3() {
        //Given
        Station start = kiwilandRailwayNetwork.getStation("A");
        Station finish = kiwilandRailwayNetwork.getStation("C");
        final Integer maximumNumberStops = 4;
        Integer currentNumberOfStops = 0;
        //When
        Integer numberOfRoutes = kiwilandRailwayNetwork.calculateNumberOfRoutesWithExactNumberOfStops(start, finish, maximumNumberStops, currentNumberOfStops);
        //Then
        assertThat(numberOfRoutes, equalTo(3));
        System.out.printf("Output #7: %s\n", numberOfRoutes);
    }

    @Test
    public void testCalculationOfTheShortestRouteFromAtoCInTermsOfDistanceToTravelAs9() {
        //Given
        Station startStation = kiwilandRailwayNetwork.getStation("A");
        Station endStation = kiwilandRailwayNetwork.getStation("C");
        //When
        Integer distance = kiwilandRailwayNetwork.calculateShortestDistance(startStation, endStation);
        //Then
        System.out.printf("Output #8: %s\n", distance);
        assertThat(distance, equalTo(9));
    }

    @Test
    public void testCalculationOfTheShortestRouteFromBtoBInTermsOfDistanceToTravelAs9() {
        //Given
        final Station startStation = kiwilandRailwayNetwork.getStation("B");
        final Station endStation = kiwilandRailwayNetwork.getStation("B");
        //When
        Integer distance = kiwilandRailwayNetwork.calculateShortestDistance(startStation, endStation);
        //Then
        assertThat(distance, equalTo(9));
        System.out.printf("Output #9: %s\n", distance);
    }

    @Test
    public void testCalculateTheNumberOfDifferentRoutesFromCToCWithADistanceOfLessThan30As7() {
        //Given
        final Station start = kiwilandRailwayNetwork.getStation("C");
        final Station finish = kiwilandRailwayNetwork.getStation("C");
        final Integer maximumNumberDistance = 30;
        //When
        Integer numberOfRoutes = kiwilandRailwayNetwork.calculateNumberOfRoutesUnderASetDistance(start, finish, maximumNumberDistance);
        //Then
        assertThat(numberOfRoutes, equalTo(7));
        System.out.printf("Output #10: %s\n", numberOfRoutes);
    }

    private KiwilandRailwayNetwork constructRailwayNetwork() {
        Station A = new Station("A");
        Station B = new Station("B");
        Station C = new Station("C");
        Station D = new Station("D");
        Station E = new Station("E");

        A.setNextStations(new Route[]{new Route(B, 5), new Route(D, 5), new Route(E, 7)});
        B.setNextStations(new Route[]{new Route(C, 4)});
        C.setNextStations(new Route[]{new Route(E, 2), new Route(D, 8)});
        D.setNextStations(new Route[]{new Route(E, 6), new Route(C, 8)});
        E.setNextStations(new Route[]{new Route(B, 3)});

        return new KiwilandRailwayNetwork.RailwayNetworkBuilder()
                .withStation(A)
                .withStation(B)
                .withStation(C)
                .withStation(D)
                .withStation(E)
                .build();
    }
}
