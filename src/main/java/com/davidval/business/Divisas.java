package com.davidval.business;

import java.util.Map;

public class Divisas {
    private Map<String, Double> mapOfDivisas;

    public Divisas(Map map) {
        this.mapOfDivisas = map;
    }

    public Map<String, Double> getMapOfDivisas() {
        return mapOfDivisas;
    }

    public void setMapOfDivisas(Map<String, Double> mapOfDivisas) {
        this.mapOfDivisas = mapOfDivisas;
    }

    public double getValueOfDivisa(String key) {
        return this.mapOfDivisas.getOrDefault(key,1.0);
    }
}
