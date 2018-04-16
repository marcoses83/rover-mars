import {Position} from "./Position";

export class Rover {
    position: Position;
    orientation: string;

    constructor(position: Position, orientation: string) {
        if (typeof position !== 'undefined') this.position = new Position(position.x, position.y);
        if (typeof orientation === 'undefined') this.orientation = orientation;
    }

    getPositionString() : string {
        return this.position.x.toString() + this.position.y.toString();
    }

    getOrientation(): string {
        return this.orientation;
    }
}