package com.epam.aircompany;

import com.epam.aircompany.models.ClassificationLevel;
import com.epam.aircompany.models.MilitaryType;
import com.epam.aircompany.planes.ExperimentalPlane;
import com.epam.aircompany.planes.MilitaryPlane;
import com.epam.aircompany.planes.PassengerPlane;
import com.epam.aircompany.planes.Plane;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static final List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ClassificationLevel.TOP_SECRET)
    );

    private static final PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            Assert.assertEquals(militaryPlane.getType(), MilitaryType.TRANSPORT);
        }
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity, planeWithMaxPassengerCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(planes);
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanesInAirport();
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            Assert.assertFalse(currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity());
        }
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(planes);
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            Assert.assertEquals(militaryPlane.getType(), MilitaryType.BOMBER);
        }
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified() {
        Airport airport = new Airport(planes);
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        for (ExperimentalPlane experimentalPlane : experimentalPlanes) {
            Assert.assertFalse(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED);
        }
    }
}
