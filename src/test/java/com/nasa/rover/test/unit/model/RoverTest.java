package com.nasa.rover.test.unit.model;

import com.nasa.rover.helper.INavigator;
import com.nasa.rover.model.Position;
import com.nasa.rover.model.Rover;
import com.nasa.rover.model.enums.CardinalPoint;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class RoverTest {
    @Mock
    private INavigator navigator;

    //TODO Write tests for Rover class
    /*@Test
    public void moveShouldSetRoverAtExpectedPositionWhenOrientedNorthAndMovedForward() {
        Rover rover = new Rover(new Position(2, 1), CardinalPoint.NORTH, navigator);
        Rover expectedRover = new Rover(new Position(2, 2), CardinalPoint.NORTH, navigator);
        String movements = "F";

        rover.move(movements);

        assertEquals(expectedRover, rover);
    }

    @Test
    public void moveShouldSetRoverAtExpectedPositionWhenOrientedNorthAndMovedBackward() {
        Rover rover = new Rover(new Position(2, 1), CardinalPoint.NORTH, navigator);
        Rover expectedRover = new Rover(new Position(2, 0), CardinalPoint.NORTH, navigator);
        String movements = "B";

        rover.move(movements);

        assertEquals(expectedRover, rover);
    }

    @Test
    public void moveShouldSetRoverAtExpectedPositionWhenOrientedNorthAndTurnedLeft() {
        Rover rover = new Rover(new Position(2, 1), CardinalPoint.NORTH, navigator);
        Rover expectedRover = new Rover(new Position(2, 1), CardinalPoint.WEST, navigator);
        String movements = "L";

        rover.move(movements);

        assertEquals(expectedRover, rover);
    }

    @Test
    public void moveShouldSetRoverAtExpectedPositionWhenOrientedNorthAndTurnedRight() {
        Rover rover = new Rover(new Position(2, 1), CardinalPoint.NORTH, navigator);
        Rover expectedRover = new Rover(new Position(2, 1), CardinalPoint.EAST, navigator);
        String movements = "R";

        rover.move(movements);

        assertEquals(expectedRover, rover);
    }

    @Test
    public void moveShouldSetRoverAtExpectedPosition() {
        Rover rover = new Rover(new Position(2, 1), CardinalPoint.NORTH, navigator);
        Rover expectedRover = new Rover(new Position(4, 5), CardinalPoint.SOUTH, navigator);
        String movements = "FFRFLFRBFFRB";

        rover.move(movements);

        assertEquals(expectedRover, rover);
    }*/
}
