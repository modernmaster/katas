package uk.co.mcguigan.trains;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class RailwayNetworkTests {

    private Graph railwayNetwork;

    @Before
    public void setUp() {
        railwayNetwork = constructRailwayNetwork();
    }

    @Test
    public void shouldCalculateTheDistanceOfRouteABC() {
        //Given
        List<Vertex> railwayJourney = new LinkedList<Vertex>();
        railwayJourney.add(railwayNetwork.getVertex("A"));
        railwayJourney.add(railwayNetwork.getVertex("B"));
        railwayJourney.add(railwayNetwork.getVertex("C"));
        //When
        String distance = railwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #1: %s\n", distance);
        Assert.assertThat(distance, equalTo("9"));
    }

    @Test
    public void shouldCalculateTheDistanceOfRouteAD() {
        //Given
        List<Vertex> railwayJourney = new LinkedList<Vertex>();
        railwayJourney.add(railwayNetwork.getVertex("A"));
        railwayJourney.add(railwayNetwork.getVertex("D"));
        //When
        String distance = railwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #2: %s\n", distance);
        Assert.assertThat(distance, equalTo("5"));
    }

    @Test
    public void shouldCalculateTheDistanceOfRouteADC() {
        //Given
        List<Vertex> railwayJourney = new LinkedList<Vertex>();
        railwayJourney.add(railwayNetwork.getVertex("A"));
        railwayJourney.add(railwayNetwork.getVertex("D"));
        railwayJourney.add(railwayNetwork.getVertex("C"));
        //When
        String distance = railwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #3: %s\n", distance);
        Assert.assertThat(distance, equalTo("13"));
    }

    @Test
    public void shouldCalculateTheDistanceOfRouteAEBCD() {
        //Given
        List<Vertex> railwayJourney = new LinkedList<Vertex>();
        railwayJourney.add(railwayNetwork.getVertex("A"));
        railwayJourney.add(railwayNetwork.getVertex("E"));
        railwayJourney.add(railwayNetwork.getVertex("B"));
        railwayJourney.add(railwayNetwork.getVertex("C"));
        railwayJourney.add(railwayNetwork.getVertex("D"));
        //When
        String distance = railwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #4: %s\n", distance);
        Assert.assertThat(distance, equalTo("22"));
    }

    @Test
    public void shouldCalculateTheDistanceOfRouteAED() {
        //Given
        List<Vertex> railwayJourney = new LinkedList<Vertex>();
        railwayJourney.add(railwayNetwork.getVertex("A"));
        railwayJourney.add(railwayNetwork.getVertex("E"));
        railwayJourney.add(railwayNetwork.getVertex("D"));
        //When
        String distance = railwayNetwork.calculateDistance(railwayJourney);
        //Then
        System.out.printf("Output #5: %s\n", distance);
        Assert.assertThat(distance, equalTo("NO SUCH ROUTE"));
    }

    @Test
    public void shouldCalculateTheNumberOfTripsStartingAndFinishingAtCWithMaxThreeStops() {
        //Given
        Vertex start = railwayNetwork.getVertex("C");
        Vertex finish = railwayNetwork.getVertex("C");
        final Integer maximumNumberStops = 3;
        Integer currentNumberOfStops = 0;
        //When
        Integer numberOfRoutes = railwayNetwork.calculateNumberOfRoutesWithExactNumberOfStops(start, finish, maximumNumberStops, currentNumberOfStops);
        //Then
        Assert.assertThat(numberOfRoutes, equalTo(2));
        System.out.printf("Output #6: %s\n", numberOfRoutes);
    }

    @Test
    public void shouldCalculateTheNumberOfTripsStartingAtAAndFinishingAtCWithExactlyFourStops() {
        //Given
        Vertex start = railwayNetwork.getVertex("A");
        Vertex finish = railwayNetwork.getVertex("C");
        final Integer maximumNumberStops = 4;
        Integer currentNumberOfStops = 0;
        //When
        Integer numberOfRoutes = railwayNetwork.calculateNumberOfRoutesWithExactNumberOfStops(start, finish, maximumNumberStops, currentNumberOfStops);
        //Then
        Assert.assertThat(numberOfRoutes, equalTo(3));
        System.out.printf("Output #7: %s\n", numberOfRoutes);
    }

    @Test
    public void shouldCalculateTheShortestRouteFromAtoCInTermsOfDistanceToTravel() {
        //Given
        Vertex startStation = railwayNetwork.getVertex("A");
        Vertex endStation = railwayNetwork.getVertex("C");
        //When
        Integer distance = railwayNetwork.calculateShortestDistance(startStation, endStation);
        //Then
        System.out.printf("Output #8: %s\n", distance);
        Assert.assertThat(distance, equalTo(9));
    }

    @Test
    public void shouldCalculateTheShortestRouteFromBtoBInTermsOfDistanceToTravel() {
        //Given
        final Vertex startStation = railwayNetwork.getVertex("B");
        final Vertex endStation = railwayNetwork.getVertex("B");
        //When
        Integer distance = railwayNetwork.calculateShortestDistance(startStation, endStation);
        //Then
        Assert.assertThat(distance, equalTo(9));
        System.out.printf("Output #9: %s\n", distance);
    }

    @Test
    public void shouldCalculateTheNumberOfDifferentRoutesFromCToCWithADistanceOfLessThan30() {
        //Given
        final Vertex start = railwayNetwork.getVertex("C");
        final Vertex finish = railwayNetwork.getVertex("C");
        final Integer maximumNumberDistance = 30;
        //When
        Integer numberOfRoutes = railwayNetwork.calculateNumberOfRoutesUnderASetDistance(start, finish, maximumNumberDistance);
        //Then
        Assert.assertThat(numberOfRoutes, equalTo(7));
        System.out.printf("Output #10: %s\n", numberOfRoutes);
    }

    private RailwayNetwork constructRailwayNetwork() {
        Station A = new Station("A");
        Station B = new Station("B");
        Station C = new Station("C");
        Station D = new Station("D");
        Station E = new Station("E");

        A.setEmanatingEdges(new Edge[]{new Route(B, 5), new Route(D, 5), new Route(E, 7)});
        B.setEmanatingEdges(new Edge[]{new Route(C, 4)});
        C.setEmanatingEdges(new Edge[]{new Route(E, 2), new Route(D, 8)});
        D.setEmanatingEdges(new Edge[]{new Route(E, 6), new Route(C, 8)});
        E.setEmanatingEdges(new Edge[]{new Route(B, 3)});

        return new RailwayNetwork.RailwayNetworkBuilder()
                .withStation(A)
                .withStation(B)
                .withStation(C)
                .withStation(D)
                .withStation(E)
                .build();
    }
}
