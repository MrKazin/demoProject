package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GroundTimeFilter implements Filterable{

    public static final long DEFAULT_TIME_LIMIT = 180;

    private long timeLimitInMinutes;

    public GroundTimeFilter() {
        this(DEFAULT_TIME_LIMIT);
    }

    public GroundTimeFilter(long timeLimitInMinutes) {
        this.timeLimitInMinutes = timeLimitInMinutes;
    }

    @Override
    public List<Flight> filter(List<Flight> originalList) {
        List<Flight> answer = new ArrayList<>();
        for (Flight flight : originalList){
            long groundTime = 0;
            for (int i = 1; i < flight.getSegments().size(); i++) {
                groundTime+=Duration.between(flight.getSegments().get(i-1).getArrivalDate(),flight.getSegments().get(i).getDepartureDate()).toMinutes();
            }
            if(groundTime >= timeLimitInMinutes)
                answer.add(flight);
        }
        return answer;
    }
}
