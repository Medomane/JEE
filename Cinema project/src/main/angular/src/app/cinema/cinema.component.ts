import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CinemaService} from "../services/cinema.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-cinema',
  templateUrl: './cinema.component.html',
  styleUrls: ['./cinema.component.css']
})
export class CinemaComponent implements OnInit {

  public cities ;
  public cinemas ;
  public rooms;
  public currentCinema;
  public currentCity;
  public currentProjection;
  public tickets;
  public selectedTickets;

  constructor(public cinemaService:CinemaService) { }

  ngOnInit(): void {
    this.cinemaService.getCities()
      .subscribe(data=>{ this.cities = data["_embedded"].cities; this.onGetCinemas(this.cities[0]);}, error => { console.error(error) ; });
  }

  onGetCinemas(v: any) {
    this.currentCity = v;
    this.cinemaService.getCinemas(v)
      .subscribe(data=>{ this.cinemas = data["_embedded"].cinemas;this.onGetRooms(this.cinemas[0]); }, error => { console.error(error) ; });
  }


  onGetRooms(c: any) {
    this.currentCinema = c;
    this.cinemaService.getRooms(c)
      .subscribe(
        rooms=>{
            this.rooms=rooms["_embedded"].rooms;

            this.rooms.forEach(room=>{
              this.cinemaService.getProjection(room)
                .subscribe(data=>{ room.projections=data["_embedded"].projections }, error => { console.error(error) ; });
            });

          },
        error => { console.error(error) ; });
  }

  onGetTicketsPlace(p: any) {
    this.currentProjection = p;
    this.cinemaService.getTicketsPlaces(p)
      .subscribe(data=>{ this.tickets = data["_embedded"].tickets ;this.selectedTickets = []; }, error => { console.error(error) ; });
  }

  onSelect(t) {
    t.selected = !t.selected ;
    if(t.selected) this.selectedTickets.push(t.id);
    else this.selectedTickets = this.selectedTickets.filter(function(value, index, arr){ return value != t.id;});
  }

  onPayTickets(f) {
    let ts = [];
    this.selectedTickets.forEach(function (e,i) {
      ts[i] = e;
    });
    f.tickets = ts;
    this.cinemaService.payTickets(f)
      .subscribe(data=>{ alert('Success') ;this.selectedTickets=[];this.onGetTicketsPlace(this.currentProjection); }, error => { console.error(error) ; });
  }
}
