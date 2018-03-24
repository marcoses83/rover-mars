package com.nasa.rover.model;

import com.nasa.rover.model.enums.Orientation;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.valueOf(this.x)
                + String.valueOf(this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Position actual = (Position) obj;

        return getX() == actual.getX()
                && getY() == actual.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
