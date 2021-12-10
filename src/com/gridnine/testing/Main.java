package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println(flights.toString());
        //1
        Filterable obj = new PastDepartureFilter();
        //2
        //Filterable obj = new ArriveBeforeDepartFilter();
        //3
        // Filterable obj = new GroundTimeFilter();


        List<Flight> filteredFlights = obj.filter(flights);
        System.out.println(filteredFlights.toString());
    }
}
