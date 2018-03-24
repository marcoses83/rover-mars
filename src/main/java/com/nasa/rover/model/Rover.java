package com.nasa.rover.model;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Rover actual = (Rover) obj;

        return getPosition() == actual.getPosition()
                && getOrientation() == actual.getOrientation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, orientation);
    }
}
