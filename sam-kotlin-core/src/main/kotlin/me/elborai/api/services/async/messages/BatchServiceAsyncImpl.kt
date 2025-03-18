// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async.messages

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
import me.elborai.api.services.async.messages.batches.BetaTrueServiceAsync
import me.elborai.api.services.async.messages.batches.BetaTrueServiceAsyncImpl

class BatchServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BatchServiceAsync {

    private val withRawResponse: BatchServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val betaTrue: BetaTrueServiceAsync by lazy { BetaTrueServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): BatchServiceAsync.WithRawResponse = withRawResponse

    override fun betaTrue(): BetaTrueServiceAsync = betaTrue

    override suspend fun create(
        params: BatchCreateParams,
        requestOptions: RequestOptions,
    ): BatchCreateResponse =
        // post /v1/messages/batches
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: BatchRetrieveParams,
        requestOptions: RequestOptions,
    ): BatchRetrieveResponse =
        // get /v1/messages/batches/{message_batch_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: BatchListParams,
        requestOptions: RequestOptions,
    ): BatchListResponse =
        // get /v1/messages/batches
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: BatchDeleteParams,
        requestOptions: RequestOptions,
    ): BatchDeleteResponse =
        // delete /v1/messages/batches/{message_batch_id}
        withRawResponse().delete(params, requestOptions).parse()

    override suspend fun cancel(
        params: BatchCancelParams,
        requestOptions: RequestOptions,
    ): BatchCancelResponse =
        // post /v1/messages/batches/{message_batch_id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    override suspend fun cancelBeta(
        params: BatchCancelBetaParams,
        requestOptions: RequestOptions,
    ): BatchCancelBetaResponse =
        // post /v1/messages/batches/{message_batch_id}/cancel?beta=true
        withRawResponse().cancelBeta(params, requestOptions).parse()

    override suspend fun results(
        params: BatchResultsParams,
        requestOptions: RequestOptions,
    ): BatchResultsResponse =
        // get /v1/messages/batches/{message_batch_id}/results
        withRawResponse().results(params, requestOptions).parse()

    override suspend fun resultsBeta(
        params: BatchResultsBetaParams,
        requestOptions: RequestOptions,
    ): BatchResultsBetaResponse =
        // get /v1/messages/batches/{message_batch_id}/results?beta=true
        withRawResponse().resultsBeta(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BatchServiceAsync.WithRawResponse {

        private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

        private val betaTrue: BetaTrueServiceAsync.WithRawResponse by lazy {
            BetaTrueServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun betaTrue(): BetaTrueServiceAsync.WithRawResponse = betaTrue

        private val createHandler: Handler<BatchCreateResponse> =
            jsonHandler<BatchCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun create(
            params: BatchCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batches")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
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

        override suspend fun retrieve(
            params: BatchRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchRetrieveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
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

        override suspend fun list(
            params: BatchListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
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

        override suspend fun delete(
            params: BatchDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
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

        override suspend fun cancel(
            params: BatchCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchCancelResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0), "cancel")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
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

        override suspend fun cancelBeta(
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
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

        private val resultsHandler: Handler<BatchResultsResponse> =
            jsonHandler<BatchResultsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun results(
            params: BatchResultsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchResultsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0), "results")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { resultsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val resultsBetaHandler: Handler<BatchResultsBetaResponse> =
            jsonHandler<BatchResultsBetaResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun resultsBeta(
            params: BatchResultsBetaParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchResultsBetaResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0), "results")
                    .putQueryParam("beta", "true")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return response.parseable {
                response
                    .use { resultsBetaHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
