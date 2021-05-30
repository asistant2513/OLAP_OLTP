import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Band } from '../interfaces/band';
import { BandServiceService } from '../services/band-service.service';

@Component({
  selector: 'app-band-list',
  templateUrl: './band-list.component.html',
  styleUrls: ['./band-list.component.scss']
})
export class BandListComponent implements OnInit {

  bands: Band[];
  constructor(private bandService: BandServiceService){

  }

  public getBands(): void{
    this.bandService.getBands().subscribe(
      (response: Band[]) =>{
        this.bands = response;
      },
      (error: HttpErrorResponse) =>{
        alert(error.message);
      }
    );
  }

  ngOnInit(): void {
    this.getBands();
  }

}
