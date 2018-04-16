export class Position {
    x: string;
    y: string;

    constructor(x: string, y: string) {
        if (typeof x !== 'undefined') this.x = x;
        if (typeof y !== 'undefined') this.y = y;
    }
}