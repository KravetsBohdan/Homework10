package com.bkravets;


import java.util.Objects;

public class Cat extends Predator{
    private String breed;

    public Cat(String color, double weight, String breed) {
        super(color, weight);
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        Cat cat = (Cat) o;

        return Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (breed != null ? breed.hashCode() : 0);
        return result;
    }

    @Override
    public String sleep() {
        return "I'm sleeping";
    }

    @Override
    public String hunt() {
        return "I'm hunting";
    }

    public String makeLove() {
        return "I'm doing staff";
    }

    public String lickBalls() {
        return "I'm licking balls";
    }


    public String doOn(DayOfWeek day) {
        return switch (day) {
            case MONDAY, WEDNESDAY, FRIDAY -> sleep();
            case TUESDAY, THURSDAY, SATURDAY -> hunt();
            case SUNDAY -> makeLove();
            default -> lickBalls();
        };
    }
}
