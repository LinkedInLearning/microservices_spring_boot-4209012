import { Component } from '@angular/core';
import { of, switchMap, timer} from "rxjs";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-tracking',
  standalone: true,
  imports: [
    AsyncPipe
  ],
  templateUrl: './tracking.component.html',
  styleUrl: './tracking.component.scss'
})
export class TrackingComponent {

  x$ = timer(0, 3000).pipe(
    switchMap(() => {
      console.info("IN!!");
      return of(new Date().getTime())
    })
  );



}
