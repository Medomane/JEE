import { RouterModule, Routes } from '@angular/router';
import {CinemaComponent} from "./cinema/cinema.component";
import {NgModule} from "@angular/core";

const routes: Routes = [
  {
    path: 'cinema',
    component: CinemaComponent,
  },
];


@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
})
// @ts-ignore
export class AppRoutingModule { }
