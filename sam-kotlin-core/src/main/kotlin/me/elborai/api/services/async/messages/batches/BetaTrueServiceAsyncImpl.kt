// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async.messages.batches

import me.elborai.api.core.ClientOptions
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.handlers.errorHandler
import me.elborai.api.core.handlers.jsonHandler
import me.elborai.api.core.handlers.withErrorHandler
import me.elborai.api.core.http.HttpMethod
import me.elborai.api.core.http.HttpRequest
import me.elborai.api.core.http.HttpResponse.Handler
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.core.http.json
import me.elborai.api.core.http.parseable
import me.elborai.api.core.prepareAsync
import me.elborai.api.errors.SamError
import me.elborai.api.models.messages.batches.betatrue.BetaTrueDeleteParams
import me.elborai.api.models.messages.batches.betatrue.BetaTrueDeleteResponse
import me.elborai.api.models.messages.batches.betatrue.BetaTrueRetrieveParams
import me.elborai.api.models.messages.batches.betatrue.BetaTrueRetrieveResponse

class BetaTrueServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : BetaTrueServiceAsync {

    private val withRawResponse: BetaTrueServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): BetaTrueServiceAsync.WithRawResponse = withRawResponse

    override suspend fun retrieve(params: BetaTrueRetrieveParams, requestOptions: RequestOptions): BetaTrueRetrieveResponse =
        // get /v1/messages/batches/{message_batch_id}?beta=true
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun delete(params: BetaTrueDeleteParams, requestOptions: RequestOptions): BetaTrueDeleteResponse =
        // delete /v1/messages/batches/{message_batch_id}?beta=true
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : BetaTrueServiceAsync.WithRawResponse {

        private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<BetaTrueRetrieveResponse> = jsonHandler<BetaTrueRetrieveResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun retrieve(params: BetaTrueRetrieveParams, requestOptions: RequestOptions): HttpResponseFor<BetaTrueRetrieveResponse> {
          val request = HttpRequest.builder()
            .method(HttpMethod.GET)
            .addPathSegments("v1", "messages", "batches", params.getPathParam(0))
            .putQueryParam("beta", "true")
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.executeAsync(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  retrieveHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val deleteHandler: Handler<BetaTrueDeleteResponse> = jsonHandler<BetaTrueDeleteResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun delete(params: BetaTrueDeleteParams, requestOptions: RequestOptions): HttpResponseFor<BetaTrueDeleteResponse> {
          val request = HttpRequest.builder()
            .method(HttpMethod.DELETE)
            .addPathSegments("v1", "messages", "batches", params.getPathParam(0))
            .putQueryParam("beta", "true")
            .apply { params._body()?.let{ body(json(clientOptions.jsonMapper, it)) } }
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.executeAsync(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  deleteHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }
    }
}
