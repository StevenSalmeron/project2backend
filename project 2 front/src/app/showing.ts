import { Time } from "@angular/common";

export class Showing {

    constructor(
      public showingId: number,
      public theaterId: number,
      public time: String,
      public currentCapacity: number
    ) {}
  
}