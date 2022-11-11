package com.bkravets;

import java.util.Objects;

public abstract class Predator {
    private String color;
    private double weight;

    public Predator(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Predator predator)) return false;

        if (Double.compare(predator.weight, weight) != 0) return false;
        return Objects.equals(color, predator.color);
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + Double.hashCode(weight);
        return result;
    }

    public abstract String sleep();

    public abstract String hunt();
}

