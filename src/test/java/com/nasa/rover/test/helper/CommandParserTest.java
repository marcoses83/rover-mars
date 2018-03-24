package com.nasa.rover.test.helper;

import com.nasa.rover.helper.CommandParser;
import com.nasa.rover.model.Position;
import com.nasa.rover.model.Rover;
import com.nasa.rover.model.enums.Orientation;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CommandParserTest {
    @Test
    public void parseShouldReturnRoverInstanceWhenValidPositionOrientationMovement() {
        String command = "21NFFRFRFFLF";
        Rover expectedRover = new Rover(new Position(2, 1), Orientation.NORTH);

        Rover result = new CommandParser().parse(command);

        assertTrue(result.equals(expectedRover));
    }

    @Test
    public void parseShouldReturnRoverInstanceWhenNoMovement() {
        String command = "21N";
        Rover expectedRover = new Rover(new Position(2, 1), Orientation.NORTH);

        Rover result = new CommandParser().parse(command);

        assertTrue(result.equals(expectedRover));
    }

    @Test
    public void parseShouldReturnNullWhenXPositionNotValid() {
        String command = "X1NFFRFRFFLF";

        Rover result = new CommandParser().parse(command);

        assertTrue(result == null);
    }

    @Test
    public void parseShouldReturnNullWhenYPositionNotValid() {
        String command = "2YNFFRFRFFLF";

        Rover result = new CommandParser().parse(command);

        assertTrue(result == null);
    }

    @Test
    public void parseShouldReturnNullWhenOrientationNotValid() {
        String command = "21XFFRFRFFLF";

        Rover result = new CommandParser().parse(command);

        assertTrue(result == null);
    }
}
