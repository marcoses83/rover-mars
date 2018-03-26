package com.nasa.rover.helper;

import com.nasa.rover.model.Position;
import com.nasa.rover.model.enums.CardinalPoint;
import com.nasa.rover.util.CircularArrayList;

public class Navigator implements INavigator {
    private CircularArrayList<CardinalPoint> orientationList;

    public Navigator() {
        orientationList = new CircularArrayList<>();
        orientationList.add(CardinalPoint.NORTH);
        orientationList.add(CardinalPoint.EAST);
        orientationList.add(CardinalPoint.SOUTH);
        orientationList.add(CardinalPoint.WEST);
    }

    public CardinalPoint rotateLeft(CardinalPoint currentOrientation) {
        return orientationList.getPrevious(orientationList.indexOf(currentOrientation));
    }

    public CardinalPoint rotateRight(CardinalPoint currentOrientation) {
        return orientationList.getNext(orientationList.indexOf(currentOrientation));
    }

    public void moveForward(Position currentPosition, CardinalPoint currentOrientation) {
        //TODO
        if (currentOrientation.equals(CardinalPoint.NORTH)) currentPosition.increaseY();
        else if (currentOrientation.equals(CardinalPoint.EAST)) currentPosition.increaseX();
        else if (currentOrientation.equals(CardinalPoint.SOUTH)) currentPosition.decreaseY();
        else if (currentOrientation.equals(CardinalPoint.WEST)) currentPosition.decreaseX();
    }

    public void moveBackward(Position currentPosition, CardinalPoint currentOrientation) {
        //TODO
        if (currentOrientation.equals(CardinalPoint.NORTH)) currentPosition.decreaseY();
        else if (currentOrientation.equals(CardinalPoint.EAST)) currentPosition.decreaseX();
        else if (currentOrientation.equals(CardinalPoint.SOUTH)) currentPosition.increaseY();
        else if (currentOrientation.equals(CardinalPoint.WEST)) currentPosition.increaseX();
    }
}
