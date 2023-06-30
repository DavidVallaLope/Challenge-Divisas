package com.davidval.business;

public class Temperatura {
    private Temperaturas fromTemperatura;
    private Temperaturas toTemperatura;
    private double fromValue;
    private double toValue;

    public Temperatura() {
    }

    public Temperaturas getFromTemperatura() {
        return fromTemperatura;
    }

    public void setFromTemperatura(String fromTemperatura) {
        this.fromTemperatura = Temperaturas.valueOf(fromTemperatura);
    }

    public Temperaturas getToTemperatura() {
        return toTemperatura;
    }

    public void setToTemperatura(String toTemperatura) {
        this.toTemperatura = Temperaturas.valueOf(toTemperatura);
    }

    public double getFromValue() {
        return fromValue;
    }

    public void setFromValue(double fromValue) {
        this.fromValue = fromValue;
    }

    public double getToValue() {
        switch (this.getFromTemperatura()) {
            case CELSIUS -> {
                if (this.toTemperatura.equals(Temperaturas.CELSIUS)) {
                    return fromValue;
                }
                return this.fromValue * ( 9 / 5.0) + 32;
            }
            case FAHRENHEIT -> {
                if (this.toTemperatura.equals(Temperaturas.FAHRENHEIT)) {
                    return fromValue;
                }
                return (this.fromValue - 32) * (5 / 9.0);
            }
            default -> {
                return 0.0;
            }
        }

    }

    public void setToValue(double toValue) {
        this.toValue = toValue;
    }

    public enum Temperaturas {
        CELSIUS,FAHRENHEIT
    }
}
