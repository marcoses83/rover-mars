package com.nasa.rover.helper;

import com.nasa.rover.model.Position;
import com.nasa.rover.model.Rover;
import com.nasa.rover.model.enums.Movement;
import com.nasa.rover.model.enums.Orientation;

import java.util.stream.IntStream;

public class CommandParser {
    public Rover parse(String commandSequence) {
        Rover rover = null;

        if (validate(commandSequence)) {
            rover = new Rover(getPosition(commandSequence),
                    Orientation.getName(commandSequence.charAt(2)));
        }

        return rover;
    }

    private Position getPosition(String commandSequence) {
        return new Position(Character.getNumericValue(commandSequence.charAt(0)),
                Character.getNumericValue(commandSequence.charAt(1)));
    }

    private boolean validate(String commandSequence) {
        return commandSequence.length() > 2
                && Character.isDigit(commandSequence.charAt(0))
                && Character.isDigit(commandSequence.charAt(1))
                && Orientation.getValues().contains(commandSequence.charAt(2))
                && IntStream
                    .range(3, commandSequence.length())
                    .allMatch(i -> Movement.getValues().contains(commandSequence.charAt(i)));
    }
}
