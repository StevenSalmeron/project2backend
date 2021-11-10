import { Injectable } from '@angular/core';
import * as _ from 'lodash';

@Injectable({
  providedIn: 'root'
})
export class CommonService {
  constructor() { }

  getDropDownText(id: any, object: any){
    const selObj = _.filter(object, function (o: any) {
        return (_.includes(id,o.id));
    });
    return selObj;
  }

}
