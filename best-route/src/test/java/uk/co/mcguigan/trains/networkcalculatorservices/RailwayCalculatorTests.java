package uk.co.mcguigan.trains.networkcalculatorservices;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;
import uk.co.mcguigan.trains.RailwayNetworkService;
import uk.co.mcguigan.trains.Station;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RailwayCalculatorTests {

    private static final Station STATION_A = new Station("A");
    private static final Station STATION_B = new Station("B");
    private RailwayNetworkService railwayNetworkService;
    @Mock
    private DistanceCalculator distanceCalculator;
    @Mock
    private NumberOfRoutesCalculator numberOfRoutesCalculator;

    @Before
    public void setUp() {
        railwayNetworkService = new RailwayNetworkServiceImpl();
        Whitebox.setInternalState(railwayNetworkService, "distanceCalculator", distanceCalculator);
        Whitebox.setInternalState(railwayNetworkService, "numberOfRoutesCalculator", numberOfRoutesCalculator);
    }

    @Test
    public void testCalculateNumberOfRoutesUnderASetDistanceToCallConcreteImplementation() {
        int maximumDistance = 1;
        railwayNetworkService.calculateNumberOfRoutesUnderASetDistance(STATION_A, STATION_B, maximumDistance);
        verify(numberOfRoutesCalculator, times(1)).calculateNumberOfRoutesUnderASetDistance(STATION_A, STATION_B, maximumDistance);
    }

    @Test
    public void testCalculateShortestDistanceToCallConcreteImplementation() {
        railwayNetworkService.calculateShortestDistance(STATION_A, STATION_B);
        verify(distanceCalculator, times(1)).calculateShortestDistance(STATION_A, STATION_B);
    }

    @Test
    public void testCalculateDistanceToCallConcreteImplementation() {
        List<Station> stationList = new LinkedList<Station>();
        railwayNetworkService.calculateDistance(stationList);
        verify(distanceCalculator, times(1)).calculateDistance(stationList);
    }

    @Test
    public void testCalculateNumberOfRoutesWithExactNumberOfStopsToCallConcreteImplementation() {
        int numberOfStops = 1;
        railwayNetworkService.calculateNumberOfRoutesWithExactNumberOfStops(STATION_A, STATION_B, numberOfStops);
        verify(numberOfRoutesCalculator, times(1)).calculateNumberOfRoutesWithExactNumberOfStops(STATION_A, STATION_B, numberOfStops);
    }
}