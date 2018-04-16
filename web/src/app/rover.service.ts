import { Injectable } from '@angular/core';
import {Rover} from './Rover';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class RoverService {
  private roverMarsApiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {
    
  }

  getRover() : Observable<Rover> {
    return this.http.get<Rover>(this.roverMarsApiUrl + "/rover");
  }

  sendCommandSequence(commandSequence: string) : Observable<Rover> {
    return this.http.post<Rover>(this.roverMarsApiUrl + "/rover/command/sequence", commandSequence);
  }

  sendCommand(command: string) : Observable<Rover> {
    return this.http.post<Rover>(this.roverMarsApiUrl + "/rover/command", command);
  }

  reset() : Observable<Response> {
    return this.http.post<Response>(this.roverMarsApiUrl + "/rover/reset", null);
  }
}
