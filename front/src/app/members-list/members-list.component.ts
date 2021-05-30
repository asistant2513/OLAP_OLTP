import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Member } from '../interfaces/member';
import { MembersDataService } from '../services/members-data.service';

@Component({
  selector: 'app-members-list',
  templateUrl: './members-list.component.html',
  styleUrls: ['./members-list.component.scss']
})
export class MembersListComponent implements OnInit {

  members: Member[];

  constructor(private membersService: MembersDataService, private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
  	this.activatedRoute.params.subscribe(params=>this.getMembers(params.band));
  }

  getMembers(n: number){
  		this.membersService.getMembersOf(n).subscribe((members)=>{ this.members = members; });
  }

}
