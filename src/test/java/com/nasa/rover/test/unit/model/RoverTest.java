package com.nasa.rover.test.unit.model;

import com.nasa.rover.model.Position;
import com.nasa.rover.model.Rover;
import com.nasa.rover.model.enums.Orientation;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RoverTest {
    @Test
    public void moveShouldSetRoverAtExpectedPositionWhenOrientedNorthAndMovedForward() {
        Rover rover = new Rover(new Position(2, 1), Orientation.NORTH);
        Rover expectedRover = new Rover(new Position(2, 2), Orientation.NORTH);
        String movements = "F";

        rover.move(movements);

        assertTrue(rover.equals(expectedRover));
    }

    @Test
    public void moveShouldSetRoverAtExpectedPositionWhenOrientedNorthAndMovedBackward() {
        Rover rover = new Rover(new Position(2, 1), Orientation.NORTH);
        Rover expectedRover = new Rover(new Position(2, 0), Orientation.NORTH);
        String movements = "B";

        rover.move(movements);

        assertTrue(rover.equals(expectedRover));
    }

    @Test
    public void moveShouldSetRoverAtExpectedPositionWhenOrientedNorthAndTurnedLeft() {
        Rover rover = new Rover(new Position(2, 1), Orientation.NORTH);
        Rover expectedRover = new Rover(new Position(2, 1), Orientation.WEST);
        String movements = "L";

        rover.move(movements);

        assertTrue(rover.equals(expectedRover));
    }

    @Test
    public void moveShouldSetRoverAtExpectedPositionWhenOrientedNorthAndTurnedRight() {
        Rover rover = new Rover(new Position(2, 1), Orientation.NORTH);
        Rover expectedRover = new Rover(new Position(2, 1), Orientation.EAST);
        String movements = "R";

        rover.move(movements);

        assertTrue(rover.equals(expectedRover));
    }

    @Test
    public void moveShouldSetRoverAtExpectedPosition() {
        Rover rover = new Rover(new Position(2, 1), Orientation.NORTH);
        Rover expectedRover = new Rover(new Position(4, 5), Orientation.SOUTH);
        String movements = "FFRFLFRBFFRB";

        rover.move(movements);

        assertTrue(rover.equals(expectedRover));
    }
}
