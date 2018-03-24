package com.nasa.rover.model;

import com.nasa.rover.model.enums.Orientation;

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
}
