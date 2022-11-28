package com.epam.aircompany;

import com.epam.aircompany.models.MilitaryType;
import com.epam.aircompany.planes.ExperimentalPlane;
import com.epam.aircompany.planes.MilitaryPlane;
import com.epam.aircompany.planes.PassengerPlane;
import com.epam.aircompany.planes.Plane;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private final List<? extends Plane> planesInAirport;

    public Airport(List<? extends Plane> planesInAirport) {
        this.planesInAirport = planesInAirport;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> listOfPassengerPlanesInAirport = new ArrayList<>();
        for (Plane plane : planesInAirport) {
            if (plane instanceof PassengerPlane) listOfPassengerPlanesInAirport.add((PassengerPlane) plane);
        }
        return listOfPassengerPlanesInAirport;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planesInAirport.stream().filter(MilitaryPlane.class::isInstance).map(MilitaryPlane.class::cast).collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity())
                planeWithMaxCapacity = passengerPlane;
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(militaryPlane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(militaryPlane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planesInAirport) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        planesInAirport.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }

    public Airport sortByMaxSpeed() {
        planesInAirport.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public void sortByMaxLoadCapacity() {
        planesInAirport.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }

    public List<? extends Plane> getPlanesInAirport() {
        return planesInAirport;
    }

    @Override
    public String toString() {
        return String.format("com.epam.aircompany.Airport { Planes = %s }", planesInAirport);
    }

}
