import { Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { BandServiceService } from '../services/band-service.service';
import { NgForm } from '@angular/forms';
import { Band } from '../interfaces/band';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-band',
  templateUrl: './band.component.html',
  styleUrls: ['./band.component.scss']
})
export class BandComponent implements OnInit {

  @Output() removeBand = new EventEmitter();
  @Input() band;
  @Input() bandId;
  
  showInfo = false;  
 
  constructor(private bandSevice: BandServiceService) { }

  ngOnInit(): void {

  }
  remBand() {
    console.log("deleting");
    console.log(this.bandId);
  	this.bandSevice.deleteBand(this.bandId).subscribe();
  }

  public onSubmit(myForm: NgForm){
    console.log("editing");
    this.bandSevice.updateBand(myForm.value).subscribe();
  }

}
