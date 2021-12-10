package com.gridnine.testing;

import java.util.List;

public interface Filterable {
    public List<Flight> filter(List<Flight> originalList);
}
