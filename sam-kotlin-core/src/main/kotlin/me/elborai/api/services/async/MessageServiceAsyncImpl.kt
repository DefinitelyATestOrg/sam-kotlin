// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

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
import me.elborai.api.models.messages.MessageCountTokensBetaParams
import me.elborai.api.models.messages.MessageCountTokensBetaResponse
import me.elborai.api.models.messages.MessageCountTokensParams
import me.elborai.api.models.messages.MessageCountTokensResponse
import me.elborai.api.models.messages.MessageCreateParams
import me.elborai.api.models.messages.MessageCreateResponse
import me.elborai.api.services.async.messages.BatchServiceAsync
import me.elborai.api.services.async.messages.BatchServiceAsyncImpl
import me.elborai.api.services.async.messages.BatchesBetaTrueServiceAsync
import me.elborai.api.services.async.messages.BatchesBetaTrueServiceAsyncImpl

class MessageServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : MessageServiceAsync {

    private val withRawResponse: MessageServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    private val batches: BatchServiceAsync by lazy { BatchServiceAsyncImpl(clientOptions) }

    private val batchesBetaTrue: BatchesBetaTrueServiceAsync by lazy { BatchesBetaTrueServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): MessageServiceAsync.WithRawResponse = withRawResponse

    override fun batches(): BatchServiceAsync = batches

    override fun batchesBetaTrue(): BatchesBetaTrueServiceAsync = batchesBetaTrue

    override suspend fun create(params: MessageCreateParams, requestOptions: RequestOptions): MessageCreateResponse =
        // post /v1/messages
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun countTokens(params: MessageCountTokensParams, requestOptions: RequestOptions): MessageCountTokensResponse =
        // post /v1/messages/count_tokens
        withRawResponse().countTokens(params, requestOptions).parse()

    override suspend fun countTokensBeta(params: MessageCountTokensBetaParams, requestOptions: RequestOptions): MessageCountTokensBetaResponse =
        // post /v1/messages/count_tokens?beta=true
        withRawResponse().countTokensBeta(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : MessageServiceAsync.WithRawResponse {

        private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

        private val batches: BatchServiceAsync.WithRawResponse by lazy { BatchServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        private val batchesBetaTrue: BatchesBetaTrueServiceAsync.WithRawResponse by lazy { BatchesBetaTrueServiceAsyncImpl.WithRawResponseImpl(clientOptions) }

        override fun batches(): BatchServiceAsync.WithRawResponse = batches

        override fun batchesBetaTrue(): BatchesBetaTrueServiceAsync.WithRawResponse = batchesBetaTrue

        private val createHandler: Handler<MessageCreateResponse> = jsonHandler<MessageCreateResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun create(params: MessageCreateParams, requestOptions: RequestOptions): HttpResponseFor<MessageCreateResponse> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "messages")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.executeAsync(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  createHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val countTokensHandler: Handler<MessageCountTokensResponse> = jsonHandler<MessageCountTokensResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun countTokens(params: MessageCountTokensParams, requestOptions: RequestOptions): HttpResponseFor<MessageCountTokensResponse> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "messages", "count_tokens")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.executeAsync(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  countTokensHandler.handle(it)
              }
              .also {
                  if (requestOptions.responseValidation!!) {
                    it.validate()
                  }
              }
          }
        }

        private val countTokensBetaHandler: Handler<MessageCountTokensBetaResponse> = jsonHandler<MessageCountTokensBetaResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override suspend fun countTokensBeta(params: MessageCountTokensBetaParams, requestOptions: RequestOptions): HttpResponseFor<MessageCountTokensBetaResponse> {
          val request = HttpRequest.builder()
            .method(HttpMethod.POST)
            .addPathSegments("v1", "messages", "count_tokens")
            .putQueryParam("beta", "true")
            .body(json(clientOptions.jsonMapper, params._body()))
            .build()
            .prepareAsync(clientOptions, params)
          val requestOptions = requestOptions
              .applyDefaults(RequestOptions.from(clientOptions))
          val response = clientOptions.httpClient.executeAsync(
            request, requestOptions
          )
          return response.parseable {
              response.use {
                  countTokensBetaHandler.handle(it)
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
