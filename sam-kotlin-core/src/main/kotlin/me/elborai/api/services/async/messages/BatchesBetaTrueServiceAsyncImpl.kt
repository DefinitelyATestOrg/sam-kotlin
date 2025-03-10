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
import me.elborai.api.models.MessageBatchesBetaTrueCreateParams
import me.elborai.api.models.MessageBatchesBetaTrueCreateResponse
import me.elborai.api.models.MessageBatchesBetaTrueListParams
import me.elborai.api.models.MessageBatchesBetaTrueListResponse

class BatchesBetaTrueServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : BatchesBetaTrueServiceAsync {

    private val withRawResponse: BatchesBetaTrueServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BatchesBetaTrueServiceAsync.WithRawResponse = withRawResponse

    override suspend fun create(
        params: MessageBatchesBetaTrueCreateParams,
        requestOptions: RequestOptions,
    ): MessageBatchesBetaTrueCreateResponse =
        // post /v1/messages/batches?beta=true
        withRawResponse().create(params, requestOptions).parse()

    override suspend fun list(
        params: MessageBatchesBetaTrueListParams,
        requestOptions: RequestOptions,
    ): MessageBatchesBetaTrueListResponse =
        // get /v1/messages/batches?beta=true
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BatchesBetaTrueServiceAsync.WithRawResponse {

        private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<MessageBatchesBetaTrueCreateResponse> =
            jsonHandler<MessageBatchesBetaTrueCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun create(
            params: MessageBatchesBetaTrueCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageBatchesBetaTrueCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batches")
                    .putQueryParam("beta", "true")
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

        private val listHandler: Handler<MessageBatchesBetaTrueListResponse> =
            jsonHandler<MessageBatchesBetaTrueListResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun list(
            params: MessageBatchesBetaTrueListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageBatchesBetaTrueListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches")
                    .putQueryParam("beta", "true")
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
    }
}
