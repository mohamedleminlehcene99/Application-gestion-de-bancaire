/* tslint:disable */
/* eslint-disable */
/* Code generated by ng-openapi-gen DO NOT EDIT. */

import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { delete1 } from '../fn/transaction/delete-1';
import { Delete1$Params } from '../fn/transaction/delete-1';
import { findAll1 } from '../fn/transaction/find-all-1';
import { FindAll1$Params } from '../fn/transaction/find-all-1';
import { findAllTransactionByUserId } from '../fn/transaction/find-all-transaction-by-user-id';
import { FindAllTransactionByUserId$Params } from '../fn/transaction/find-all-transaction-by-user-id';
import { findTransactionById } from '../fn/transaction/find-transaction-by-id';
import { FindTransactionById$Params } from '../fn/transaction/find-transaction-by-id';
import { save1 } from '../fn/transaction/save-1';
import { Save1$Params } from '../fn/transaction/save-1';
import { TransactionDto } from '../models/transaction-dto';

@Injectable({ providedIn: 'root' })
export class TransactionService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `findAll1()` */
  static readonly FindAll1Path = '/transactions/';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll1()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll1$Response(params?: FindAll1$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<TransactionDto>>> {
    return findAll1(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll1$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll1(params?: FindAll1$Params, context?: HttpContext): Observable<Array<TransactionDto>> {
    return this.findAll1$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<TransactionDto>>): Array<TransactionDto> => r.body)
    );
  }

  /** Path part for operation `save1()` */
  static readonly Save1Path = '/transactions/';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `save1()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  save1$Response(params: Save1$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return save1(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `save1$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  save1(params: Save1$Params, context?: HttpContext): Observable<number> {
    return this.save1$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `findTransactionById()` */
  static readonly FindTransactionByIdPath = '/transactions/{transaction_id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findTransactionById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findTransactionById$Response(params: FindTransactionById$Params, context?: HttpContext): Observable<StrictHttpResponse<TransactionDto>> {
    return findTransactionById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findTransactionById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findTransactionById(params: FindTransactionById$Params, context?: HttpContext): Observable<TransactionDto> {
    return this.findTransactionById$Response(params, context).pipe(
      map((r: StrictHttpResponse<TransactionDto>): TransactionDto => r.body)
    );
  }

  /** Path part for operation `delete1()` */
  static readonly Delete1Path = '/transactions/{transaction_id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `delete1()` instead.
   *
   * This method doesn't expect any request body.
   */
  delete1$Response(params: Delete1$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return delete1(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `delete1$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  delete1(params: Delete1$Params, context?: HttpContext): Observable<void> {
    return this.delete1$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `findAllTransactionByUserId()` */
  static readonly FindAllTransactionByUserIdPath = '/transactions/user/{user_id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAllTransactionByUserId()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllTransactionByUserId$Response(params: FindAllTransactionByUserId$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<TransactionDto>>> {
    return findAllTransactionByUserId(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAllTransactionByUserId$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAllTransactionByUserId(params: FindAllTransactionByUserId$Params, context?: HttpContext): Observable<Array<TransactionDto>> {
    return this.findAllTransactionByUserId$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<TransactionDto>>): Array<TransactionDto> => r.body)
    );
  }

}
