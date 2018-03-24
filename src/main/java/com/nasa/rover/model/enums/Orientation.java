package com.nasa.rover.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Orientation {
    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W');

    private char value;

    Orientation(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static Orientation getName(char value) {
        for (Orientation orientation : Orientation.values())
            if (orientation.value == value)
                return orientation;

        return null;
    }

    public static List<Character> getValues() {
        return Arrays.stream(Orientation.values())
                .map(Orientation::getValue)
                .collect(Collectors.toList());
    }
}
