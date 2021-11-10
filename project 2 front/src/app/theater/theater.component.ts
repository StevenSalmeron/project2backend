import { Component, Injectable, OnInit } from '@angular/core';
import { BookingService } from '../_services/booking.service';
import { CommonService } from '../_services/common.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-theater',
  templateUrl: './theater.component.html',
  styleUrls: ['./theater.component.css']
})
@Injectable()
export class TheaterComponent implements OnInit {

  theaters: any = [];
  showings: any = [];
  mySelect = '1';
  selectedValue: any;

  constructor(public bookingService: BookingService, private commonService: CommonService) {
    this.bookingService.getTheaters().subscribe((res: {}) => {
      this.theaters = res;
    })
  }
// Need to figure out how to get theaterId on submit
  onSubmit(theaterId = +this.selectedValue){
    this.bookingService.getShowingsbyId(theaterId).subscribe((res: {}) => {
      this.showings = res;
    })
  } 

  ngOnInit(): void {
  }

  selectChange() {
    this.selectedValue = this.commonService.getDropDownText(this.mySelect, this.theaters)[0].name;
  }
}
