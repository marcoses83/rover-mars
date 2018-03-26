package com.nasa.rover.model;

import com.nasa.rover.helper.Navigator;
import com.nasa.rover.model.enums.CardinalPoint;
import com.nasa.rover.model.enums.Movement;

import java.util.Objects;

public class Rover {
    private Position position;
    private CardinalPoint orientation;
    private Navigator navigator;

    public Rover(Position position, CardinalPoint orientation) {
        this.position = position;
        this.orientation = orientation;
        this.navigator = new Navigator();
    }

    public void move(String movements) {
        movements.chars().forEach(movement ->
        {
            if (movement == Movement.BACKWARD.getValue()) {
                navigator.moveBackward(position, orientation);
            } else if (movement == Movement.FORWARD.getValue()) {
                navigator.moveForward(position, orientation);
            } else if (movement == Movement.LEFT.getValue()) {
                orientation = navigator.rotateLeft(orientation);
            } else if (movement == Movement.RIGHT.getValue()) {
                orientation = navigator.rotateRight(orientation);
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
