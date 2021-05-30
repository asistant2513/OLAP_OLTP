import { Component, OnInit } from '@angular/core';
import { MembersDataService } from '../services/members-data.service';
import { ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-new-member',
  templateUrl: './new-member.component.html',
  styleUrls: ['./new-member.component.scss']
})
export class NewMemberComponent implements OnInit {

  showForm = false;

  constructor(private memberService: MembersDataService, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  onSubmit(myForm : NgForm) {
    alert("Specified not valid year!");
    const currBand = this.route.snapshot.params["band"];
  	this.showForm = false;
  	this.memberService.addMember(myForm.value, currBand).subscribe();
  }
}
