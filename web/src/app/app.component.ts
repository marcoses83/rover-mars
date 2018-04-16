import { Component, OnInit } from '@angular/core';
import {Rover} from './Rover';
import {RoverService} from './rover.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})

export class AppComponent implements OnInit {
  constructor(private roverService: RoverService) { }
  counter = 0;
  roverName = 'Rover';
  title = 'Hello world...';
  subtitle = 'It\'s ' + this.roverName + ' here!';

  position: string;
  orientation: string;

  ngOnInit() {
      this.counter = 3;
        this.getRover();
  }

  getRover(): void {this.roverService.getRover().subscribe(
      rover => this.loadRover(rover),
      () => this.resetRover()
    );
  }

  sendCommandSequence(commandSequence: string): void {
    this.roverService.sendCommandSequence(commandSequence).subscribe(
      rover => this.loadRover(rover),
      () => this.resetRover()
    );
  }

  sendCommand(command: string): void {
    this.roverService.sendCommand(command).subscribe(
      rover => this.loadRover(rover),
      () => this.resetRover()
    );
  }

  reset() {
    this.roverService.reset().subscribe(
      () => this.getRover()
    );
  }

  private loadRover(rover: Rover) {
    let objRover = new Rover(rover.position, rover.orientation);
    this.position = objRover.getPositionString();
    this.orientation = objRover.getOrientation();
    this.rotateRover(this.orientation);
  }

  private resetRover() {
    this.position = "";
    this.orientation = "";
    this.rotateRover('north');
  }

  private rotateRover(orientation: string) {
    debugger;
    switch(this.orientation) {
      case 'north':
        if (orientation === 'north') this.sendCommand('F');
        else if (orientation === 'east') this.sendCommand('R');
        else if (orientation === 'south') this.sendCommand('B');
        else if (orientation === 'west') this.sendCommand('L');
        break;
      case 'east':
        if (orientation === 'north') this.sendCommand('L');
        else if (orientation === 'east') this.sendCommand('F');
        else if (orientation === 'south') this.sendCommand('R');
        else if (orientation === 'west') this.sendCommand('B');
        break;
      case 'south':
        if (orientation === 'north') this.sendCommand('B');
        else if (orientation === 'east') this.sendCommand('L');
        else if (orientation === 'south') this.sendCommand('F');
        else if (orientation === 'west') this.sendCommand('R');
        break;
      case 'west':
        if (orientation === 'north') this.sendCommand('R');
        else if (orientation === 'east') this.sendCommand('B');
        else if (orientation === 'south') this.sendCommand('L');
        else if (orientation === 'west') this.sendCommand('F');
        break;
      default:
        break;
    }

    this.rotateRoverImage(orientation);
  }

  private rotateRoverImage(orientation: string) {
    var roverImageContainer = document.getElementById("roverImageContainer");
    roverImageContainer.classList.remove('north', 'east', 'south', 'west');
    switch(orientation) {
      case 'north':
        roverImageContainer.classList.add('north'); break;
      case 'east':
        roverImageContainer.classList.add('east'); break;
      case 'south':
        roverImageContainer.classList.add('south'); break;
      case 'west':
        roverImageContainer.classList.add('west'); break;
      default:
        roverImageContainer.classList.add('north'); break;
    }
  }
}
