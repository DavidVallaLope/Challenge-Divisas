package com.davidval.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Divisas {

    @JsonIgnoreProperties({"result", "documentation", "terms_of_use","time_last_update_unix",
    "time_last_update_utc","time_next_update_unix","time_next_update_utc","base_code"})
    public abstract class MixIn { }
    @JsonProperty("conversion_rates")
    private Map<String, Map<String , Double>> mapOfDivisas;

    private String fromCurrency;
    private String toCorrency;
    private double fromValue;
    private double toValue;

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCorrency() {
        return toCorrency;
    }

    public void setToCorrency(String toCorrency) {
        this.toCorrency = toCorrency;
    }

    public double getFromValue() {
        return fromValue;
    }

    public void setFromValue(double fromValue) {
        this.fromValue = fromValue;
    }

    public double getToValue() {
        if (this.fromCurrency.equals("MXN")) {
            return this.fromValue * this.getValueOfDivisa(this.toCorrency);
        } else {
            return (this.fromValue / this.getValueOfDivisa(this.fromCurrency)) * this.getValueOfDivisa(this.toCorrency);
        }
    }

    public void setToValue(double toValue) {
        this.toValue = toValue;
    }

    public Divisas(Map map) {
        this.mapOfDivisas = map;
    }


    public Map<String , Double> getMapOfDivisas() {
        return mapOfDivisas.get("conversion_rates");
    }

    public void setMapOfDivisas(Map<String, Map<String , Double>> mapOfDivisas) {
        this.mapOfDivisas = mapOfDivisas;
    }

    public double getValueOfDivisa(String key) {
        try {
            return mapOfDivisas.get("conversion_rates").getOrDefault(key,1.0);
        } catch (ClassCastException e) {
            return 1.0;
        }

    }

}
