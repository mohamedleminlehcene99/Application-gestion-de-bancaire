/* tslint:disable */
/* eslint-disable */
/* Code generated by ng-openapi-gen DO NOT EDIT. */

import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { AddressDto } from '../../models/address-dto';

export interface FindAddressById$Params {
  address_id: number;
}

export function findAddressById(http: HttpClient, rootUrl: string, params: FindAddressById$Params, context?: HttpContext): Observable<StrictHttpResponse<AddressDto>> {
  const rb = new RequestBuilder(rootUrl, findAddressById.PATH, 'get');
  if (params) {
    rb.path('address_id', params.address_id, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<AddressDto>;
    })
  );
}

findAddressById.PATH = '/address/{address_id}';
