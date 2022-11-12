package com.bkravets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {

    Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat("grey", 10.5, "persian");
    }

    @Test
    void shouldNotBeEqualWhenWeightDifferent() {

        Cat cat1 = new Cat("grey", 10.6, "persian");

        boolean isEqual = cat.equals(cat1);

        assertFalse(isEqual);
    }

    @Test
    void shouldNotBeEqualWhenColorDifferent() {

        Cat cat1 = new Cat("white", 10.5, "persian");

        boolean isEqual = cat.equals(cat1);

        assertFalse(isEqual);
    }

    @Test
    void shouldNotBeEqualWhenBreedDifferent() {

        Cat cat1 = new Cat("grey", 10.5, "siamese");

        boolean isEqual = cat.equals(cat1);

        assertFalse(isEqual);
    }

    @Test
    void shouldBeEqualWhenFieldsIdentical() {

        Cat cat1 = new Cat("grey", 10.5, "persian");

        boolean isEqual = cat.equals(cat1);

        assertTrue(isEqual);
    }



    @Test
    void shouldBeEqualWhenTheSameObject() {
        Cat cat1 = cat;

        boolean isEquals = cat.equals(cat1);

        assertTrue(isEquals);
    }


    @Test
    void shouldNotBeEqualNull() {

        boolean isEqual = cat.equals(null);

        assertFalse(isEqual);
    }


    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"MONDAY", "WEDNESDAY", "FRIDAY"})
    void shouldSleepOnMondayWednesdayFriday(DayOfWeek day) {

        String doOn = cat.doOn(day);

        assertEquals("I'm sleeping", doOn);
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY", "SATURDAY"})
    void shouldHuntOnTuesdayThursdaySaturday(DayOfWeek day) {

        String doOn = cat.doOn(day);

        assertEquals("I'm hunting", doOn);
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"SUNDAY"})
    void shouldMakeLoveOnSunday(DayOfWeek day) {

        String doOn = cat.doOn(day);

        assertEquals("I'm doing staff", doOn);
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"NOT_VALID"})
    void shouldLickBallsWhenDayNotValid(DayOfWeek day) {

        String doOn = cat.doOn(day);

        assertEquals("I'm licking balls", doOn);
    }

}