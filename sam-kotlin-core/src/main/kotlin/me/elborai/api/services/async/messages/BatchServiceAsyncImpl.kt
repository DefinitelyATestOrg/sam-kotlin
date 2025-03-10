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
import me.elborai.api.models.MessageBatchCancelBetaParams
import me.elborai.api.models.MessageBatchCancelBetaResponse
import me.elborai.api.models.MessageBatchCancelParams
import me.elborai.api.models.MessageBatchCancelResponse
import me.elborai.api.models.MessageBatchCreateParams
import me.elborai.api.models.MessageBatchCreateResponse
import me.elborai.api.models.MessageBatchDeleteParams
import me.elborai.api.models.MessageBatchDeleteResponse
import me.elborai.api.models.MessageBatchListParams
import me.elborai.api.models.MessageBatchListResponse
import me.elborai.api.models.MessageBatchResultsBetaParams
import me.elborai.api.models.MessageBatchResultsBetaResponse
import me.elborai.api.models.MessageBatchResultsParams
import me.elborai.api.models.MessageBatchResultsResponse
import me.elborai.api.models.MessageBatchRetrieveParams
import me.elborai.api.models.MessageBatchRetrieveResponse
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
        params: MessageBatchCreateParams,
        requestOptions: RequestOptions,
    ): MessageBatchCreateResponse =
        // post /v1/messages/batches
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun retrieve(
        params: MessageBatchRetrieveParams,
        requestOptions: RequestOptions,
    ): MessageBatchRetrieveResponse =
        // get /v1/messages/batches/{message_batch_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: MessageBatchListParams,
        requestOptions: RequestOptions,
    ): MessageBatchListResponse =
        // get /v1/messages/batches
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun delete(
        params: MessageBatchDeleteParams,
        requestOptions: RequestOptions,
    ): MessageBatchDeleteResponse =
        // delete /v1/messages/batches/{message_batch_id}
        withRawResponse().delete(params, requestOptions).parse()

    override suspend fun cancel(
        params: MessageBatchCancelParams,
        requestOptions: RequestOptions,
    ): MessageBatchCancelResponse =
        // post /v1/messages/batches/{message_batch_id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    override suspend fun cancelBeta(
        params: MessageBatchCancelBetaParams,
        requestOptions: RequestOptions,
    ): MessageBatchCancelBetaResponse =
        // post /v1/messages/batches/{message_batch_id}/cancel?beta=true
        withRawResponse().cancelBeta(params, requestOptions).parse()

    override suspend fun results(
        params: MessageBatchResultsParams,
        requestOptions: RequestOptions,
    ): MessageBatchResultsResponse =
        // get /v1/messages/batches/{message_batch_id}/results
        withRawResponse().results(params, requestOptions).parse()

    override suspend fun resultsBeta(
        params: MessageBatchResultsBetaParams,
        requestOptions: RequestOptions,
    ): MessageBatchResultsBetaResponse =
        // get /v1/messages/batches/{message_batch_id}/results?beta=true
        withRawResponse().resultsBeta(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BatchServiceAsync.WithRawResponse {

        private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

        private val betaTrue: BetaTrueServiceAsync.WithRawResponse by lazy {
            BetaTrueServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun betaTrue(): BetaTrueServiceAsync.WithRawResponse = betaTrue

        private val createHandler: Handler<MessageBatchCreateResponse> =
            jsonHandler<MessageBatchCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun create(
            params: MessageBatchCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageBatchCreateResponse> {
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

        private val retrieveHandler: Handler<MessageBatchRetrieveResponse> =
            jsonHandler<MessageBatchRetrieveResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun retrieve(
            params: MessageBatchRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageBatchRetrieveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches", params.getPathParam(0))
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

        private val listHandler: Handler<MessageBatchListResponse> =
            jsonHandler<MessageBatchListResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun list(
            params: MessageBatchListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageBatchListResponse> {
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

        private val deleteHandler: Handler<MessageBatchDeleteResponse> =
            jsonHandler<MessageBatchDeleteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun delete(
            params: MessageBatchDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageBatchDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "messages", "batches", params.getPathParam(0))
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

        private val cancelHandler: Handler<MessageBatchCancelResponse> =
            jsonHandler<MessageBatchCancelResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun cancel(
            params: MessageBatchCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageBatchCancelResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batches", params.getPathParam(0), "cancel")
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

        private val cancelBetaHandler: Handler<MessageBatchCancelBetaResponse> =
            jsonHandler<MessageBatchCancelBetaResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun cancelBeta(
            params: MessageBatchCancelBetaParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageBatchCancelBetaResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batches", params.getPathParam(0), "cancel")
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

        private val resultsHandler: Handler<MessageBatchResultsResponse> =
            jsonHandler<MessageBatchResultsResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun results(
            params: MessageBatchResultsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageBatchResultsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches", params.getPathParam(0), "results")
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

        private val resultsBetaHandler: Handler<MessageBatchResultsBetaResponse> =
            jsonHandler<MessageBatchResultsBetaResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun resultsBeta(
            params: MessageBatchResultsBetaParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageBatchResultsBetaResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches", params.getPathParam(0), "results")
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
