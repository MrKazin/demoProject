package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class ArriveBeforeDepartFilter implements Filterable{
    @Override
    public List<Flight> filter(List<Flight> originalList) {
        List<Flight> answer = new ArrayList<>();
        for (Flight flight : originalList){
            for (Segment segment : flight.getSegments()){
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())){
                    answer.add(flight);
                    break;
                }
            }
        }
        return answer;
    }
}
