package com.nasa.rover.test.unit.helper;

import com.nasa.rover.helper.CommandParser;
import com.nasa.rover.helper.Navigator;
import com.nasa.rover.model.Position;
import com.nasa.rover.model.Rover;
import com.nasa.rover.model.enums.CardinalPoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CommandParserTest {
    @Test
    public void parseShouldReturnRoverInstanceWhenValidPositionOrientationMovement() {
        String command = "21NFFRBRFFLF";
        Rover expectedRover = new Rover(new Position(2, 1), CardinalPoint.NORTH, new Navigator());

        Rover result = new CommandParser().parse(command);

        assertEquals(expectedRover, result);
    }

    @Test
    public void parseShouldReturnRoverInstanceWhenLowercase() {
        String command = "21nFFRbRFFlF";
        Rover expectedRover = new Rover(new Position(2, 1), CardinalPoint.NORTH, new Navigator());

        Rover result = new CommandParser().parse(command);

        assertEquals(expectedRover, result);
    }

    @Test
    public void parseShouldReturnRoverInstanceWhenNoMovement() {
        String command = "21N";
        Rover expectedRover = new Rover(new Position(2, 1), CardinalPoint.NORTH, new Navigator());

        Rover result = new CommandParser().parse(command);

        assertEquals(expectedRover, result);
    }

    @Test
    public void parseShouldReturnNullWhenXPositionNotValid() {
        String command = "X1NFFRBRFFLF";

        Rover result = new CommandParser().parse(command);

        assertNull(result);
    }

    @Test
    public void parseShouldReturnNullWhenYPositionNotValid() {
        String command = "2YNFFRBRFFLF";

        Rover result = new CommandParser().parse(command);

        assertNull(result);
    }

    @Test
    public void parseShouldReturnNullWhenOrientationNotValid() {
        String command = "21XFFRBRFFLF";

        Rover result = new CommandParser().parse(command);

        assertNull(result);
    }
}
