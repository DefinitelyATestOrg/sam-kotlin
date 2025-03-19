// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.messages

import me.elborai.api.core.ClientOptions
import me.elborai.api.core.JsonValue
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
import me.elborai.api.core.prepare
import me.elborai.api.models.messages.batchesbetatrue.BatchesBetaTrueCreateParams
import me.elborai.api.models.messages.batchesbetatrue.BatchesBetaTrueCreateResponse
import me.elborai.api.models.messages.batchesbetatrue.BatchesBetaTrueListParams
import me.elborai.api.models.messages.batchesbetatrue.BatchesBetaTrueListResponse

class BatchesBetaTrueServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BatchesBetaTrueService {

    private val withRawResponse: BatchesBetaTrueService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BatchesBetaTrueService.WithRawResponse = withRawResponse

    override fun create(
        params: BatchesBetaTrueCreateParams,
        requestOptions: RequestOptions,
    ): BatchesBetaTrueCreateResponse =
        // post /v1/messages/batches?beta=true
        withRawResponse().create(params, requestOptions).parse()

    override fun list(
        params: BatchesBetaTrueListParams,
        requestOptions: RequestOptions,
    ): BatchesBetaTrueListResponse =
        // get /v1/messages/batches?beta=true
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BatchesBetaTrueService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<BatchesBetaTrueCreateResponse> =
            jsonHandler<BatchesBetaTrueCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: BatchesBetaTrueCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchesBetaTrueCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages", "batches")
                    .putQueryParam("beta", "true")
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

        private val listHandler: Handler<BatchesBetaTrueListResponse> =
            jsonHandler<BatchesBetaTrueListResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: BatchesBetaTrueListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchesBetaTrueListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches")
                    .putQueryParam("beta", "true")
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
    }
}
