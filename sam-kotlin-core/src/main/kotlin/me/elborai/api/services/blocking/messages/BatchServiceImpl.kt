// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.messages

import me.elborai.api.core.ClientOptions
import me.elborai.api.core.JsonValue
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.handlers.errorHandler
import me.elborai.api.core.handlers.jsonHandler
import me.elborai.api.core.handlers.jsonlHandler
import me.elborai.api.core.handlers.withErrorHandler
import me.elborai.api.core.http.HttpMethod
import me.elborai.api.core.http.HttpRequest
import me.elborai.api.core.http.HttpResponse.Handler
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.core.http.StreamResponse
import me.elborai.api.core.http.json
import me.elborai.api.core.http.map
import me.elborai.api.core.http.parseable
import me.elborai.api.core.prepare
import me.elborai.api.models.messages.batches.BatchCancelBetaParams
import me.elborai.api.models.messages.batches.BatchCancelBetaResponse
import me.elborai.api.models.messages.batches.BatchCancelParams
import me.elborai.api.models.messages.batches.BatchCancelResponse
import me.elborai.api.models.messages.batches.BatchCreateParams
import me.elborai.api.models.messages.batches.BatchCreateResponse
import me.elborai.api.models.messages.batches.BatchDeleteParams
import me.elborai.api.models.messages.batches.BatchDeleteResponse
import me.elborai.api.models.messages.batches.BatchListParams
import me.elborai.api.models.messages.batches.BatchListResponse
import me.elborai.api.models.messages.batches.BatchResultsBetaParams
import me.elborai.api.models.messages.batches.BatchResultsBetaResponse
import me.elborai.api.models.messages.batches.BatchResultsParams
import me.elborai.api.models.messages.batches.BatchResultsResponse
import me.elborai.api.models.messages.batches.BatchRetrieveParams
import me.elborai.api.models.messages.batches.BatchRetrieveResponse
import me.elborai.api.services.blocking.messages.batches.BetaTrueService
import me.elborai.api.services.blocking.messages.batches.BetaTrueServiceImpl

class BatchServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BatchService {

    private val withRawResponse: BatchService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val betaTrue: BetaTrueService by lazy { BetaTrueServiceImpl(clientOptions) }

    override fun withRawResponse(): BatchService.WithRawResponse = withRawResponse

    override fun betaTrue(): BetaTrueService = betaTrue

    override fun create(
        params: BatchCreateParams,
        requestOptions: RequestOptions,
    ): BatchCreateResponse =
        // post /v1/messages/batches
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: BatchRetrieveParams,
        requestOptions: RequestOptions,
    ): BatchRetrieveResponse =
        // get /v1/messages/batches/{message_batch_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: BatchListParams, requestOptions: RequestOptions): BatchListResponse =
        // get /v1/messages/batches
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: BatchDeleteParams,
        requestOptions: RequestOptions,
    ): BatchDeleteResponse =
        // delete /v1/messages/batches/{message_batch_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun cancel(
        params: BatchCancelParams,
        requestOptions: RequestOptions,
    ): BatchCancelResponse =
        // post /v1/messages/batches/{message_batch_id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    override fun cancelBeta(
        params: BatchCancelBetaParams,
        requestOptions: RequestOptions,
    ): BatchCancelBetaResponse =
        // post /v1/messages/batches/{message_batch_id}/cancel?beta=true
        withRawResponse().cancelBeta(params, requestOptions).parse()

    override fun resultsStreaming(
        params: BatchResultsParams,
        requestOptions: RequestOptions,
    ): StreamResponse<BatchResultsResponse> =
        // get /v1/messages/batches/{message_batch_id}/results
        withRawResponse().resultsStreaming(params, requestOptions).parse()

    override fun resultsBetaStreaming(
        params: BatchResultsBetaParams,
        requestOptions: RequestOptions,
    ): StreamResponse<BatchResultsBetaResponse> =
        // get /v1/messages/batches/{message_batch_id}/results?beta=true
        withRawResponse().resultsBetaStreaming(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BatchService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val betaTrue: BetaTrueService.WithRawResponse by lazy {
            BetaTrueServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun betaTrue(): BetaTrueService.WithRawResponse = betaTrue

        private val createHandler: Handler<BatchCreateResponse> =
            jsonHandler<BatchCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: BatchCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batches")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<BatchRetrieveResponse> =
            jsonHandler<BatchRetrieveResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieve(
            params: BatchRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchRetrieveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<BatchListResponse> =
            jsonHandler<BatchListResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: BatchListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val deleteHandler: Handler<BatchDeleteResponse> =
            jsonHandler<BatchDeleteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun delete(
            params: BatchDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val cancelHandler: Handler<BatchCancelResponse> =
            jsonHandler<BatchCancelResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun cancel(
            params: BatchCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchCancelResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0), "cancel")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { cancelHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val cancelBetaHandler: Handler<BatchCancelBetaResponse> =
            jsonHandler<BatchCancelBetaResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun cancelBeta(
            params: BatchCancelBetaParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchCancelBetaResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0), "cancel")
                    .putQueryParam("beta", "true")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { cancelBetaHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val resultsStreamingHandler: Handler<StreamResponse<BatchResultsResponse>> =
            jsonlHandler<BatchResultsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun resultsStreaming(
            params: BatchResultsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<BatchResultsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0), "results")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .let { resultsStreamingHandler.handle(it) }
                    .let { streamResponse ->
                        if (requestOptions.responseValidation!!) {
                            streamResponse.map { it.validate() }
                        } else {
                            streamResponse
                        }
                    }
            }
        }

        private val resultsBetaStreamingHandler: Handler<StreamResponse<BatchResultsBetaResponse>> =
            jsonlHandler<BatchResultsBetaResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun resultsBetaStreaming(
            params: BatchResultsBetaParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<BatchResultsBetaResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0), "results")
                    .putQueryParam("beta", "true")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .let { resultsBetaStreamingHandler.handle(it) }
                    .let { streamResponse ->
                        if (requestOptions.responseValidation!!) {
                            streamResponse.map { it.validate() }
                        } else {
                            streamResponse
                        }
                    }
            }
        }
    }
}
