import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CinemaService {

  public host:string="http://localhost:8082/";

  constructor(private http:HttpClient) { }

  getCities(){
    return this.http.get(this.host+"cities");
  }

  getCinemas(v) {
    return this.http.get(v["_links"].cinemas.href);
  }

  getRooms(c){
    return this.http.get(c["_links"].rooms.href);
  }

  getProjection(room: any) {
    return this.http.get(room["_links"].room.href+"/projections"+"?projection=p1");
  }

  getTicketsPlaces(p) {
    return this.http.get(p["_links"].self.href+"/tickets?projection=ticketProjection");
  }

  payTickets(f) {
    console.log(f);
    return this.http.post(this.host+"buy",f);
  }
}
