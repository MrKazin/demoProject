package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PastDepartureFilter implements Filterable{

    @Override
    public List<Flight> filter(List<Flight> originalList) {
        List<Flight> answer = new ArrayList<>();
        LocalDateTime timeNow = LocalDateTime.now();
        for (Flight flight : originalList){
            for (Segment segment : flight.getSegments()){
                if (segment.getDepartureDate().isBefore(timeNow)){
                    answer.add(flight);
                    break;
                }
            }
        }
        return answer;
    }
}
