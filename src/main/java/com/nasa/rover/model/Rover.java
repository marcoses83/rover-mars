package com.nasa.rover.model;

import com.nasa.rover.model.enums.Movement;
import com.nasa.rover.model.enums.Orientation;

import java.util.Objects;

public class Rover {
    private Position position;
    private Orientation orientation;

    public Rover(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void move(String movements) {
        movements.chars().forEach(movement ->
        {
            if (movement == Movement.BACKWARD.getValue()) {
                if (orientation.equals(Orientation.NORTH)) position.decreaseY();
                else if (orientation.equals(Orientation.EAST)) position.decreaseX();
                else if (orientation.equals(Orientation.SOUTH)) position.increaseY();
                else if (orientation.equals(Orientation.WEST)) position.increaseX();
            } else if (movement == Movement.FORWARD.getValue()) {
                if (orientation.equals(Orientation.NORTH)) position.increaseY();
                else if (orientation.equals(Orientation.EAST)) position.increaseX();
                else if (orientation.equals(Orientation.SOUTH)) position.decreaseY();
                else if (orientation.equals(Orientation.WEST)) position.decreaseX();
            } else if (movement == Movement.LEFT.getValue()) {
                if (orientation.equals(Orientation.NORTH)) orientation = Orientation.WEST;
                else if (orientation.equals(Orientation.EAST)) orientation = Orientation.NORTH;
                else if (orientation.equals(Orientation.SOUTH)) orientation = Orientation.EAST;
                else if (orientation.equals(Orientation.WEST)) orientation = Orientation.SOUTH;
            } else if (movement == Movement.RIGHT.getValue()) {
                if (orientation.equals(Orientation.NORTH)) orientation = Orientation.EAST;
                else if (orientation.equals(Orientation.EAST)) orientation = Orientation.SOUTH;
                else if (orientation.equals(Orientation.SOUTH)) orientation = Orientation.WEST;
                else if (orientation.equals(Orientation.WEST)) orientation = Orientation.NORTH;
            }
        });
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Rover actual = (Rover) obj;

        return position.equals(actual.position)
                && orientation.equals(actual.orientation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, orientation);
    }
}
