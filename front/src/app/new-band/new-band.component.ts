import { Component, OnInit } from '@angular/core';
import { BandServiceService } from '../services/band-service.service';
import { NgForm } from '@angular/forms';
import { Band } from '../interfaces/band';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-new-band',
  templateUrl: './new-band.component.html',
  styleUrls: ['./new-band.component.scss']
})
export class NewBandComponent implements OnInit {

  showForm = false;

  constructor(private bandService: BandServiceService) { }

  ngOnInit(){
  }

  onSubmit(myForm : NgForm) {
  	this.showForm = false;
  	this.bandService.addBand(myForm.value).subscribe(
      (response : Band) => {
        console.log(response);
        myForm.reset();
      },
      (error : HttpErrorResponse) => {
        alert(error.message);
        myForm.reset();
      }
    );
  }

}
