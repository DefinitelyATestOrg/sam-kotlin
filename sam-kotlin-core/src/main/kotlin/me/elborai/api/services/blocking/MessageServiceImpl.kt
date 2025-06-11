// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

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
import me.elborai.api.models.messages.MessageCountTokensBetaParams
import me.elborai.api.models.messages.MessageCountTokensBetaResponse
import me.elborai.api.models.messages.MessageCountTokensParams
import me.elborai.api.models.messages.MessageCountTokensResponse
import me.elborai.api.models.messages.MessageCreateParams
import me.elborai.api.models.messages.MessageCreateResponse
import me.elborai.api.services.blocking.messages.BatchService
import me.elborai.api.services.blocking.messages.BatchServiceImpl
import me.elborai.api.services.blocking.messages.BatchesBetaTrueService
import me.elborai.api.services.blocking.messages.BatchesBetaTrueServiceImpl

class MessageServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MessageService {

    private val withRawResponse: MessageService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val batches: BatchService by lazy { BatchServiceImpl(clientOptions) }

    private val batchesBetaTrue: BatchesBetaTrueService by lazy {
        BatchesBetaTrueServiceImpl(clientOptions)
    }

    override fun withRawResponse(): MessageService.WithRawResponse = withRawResponse

    override fun batches(): BatchService = batches

    override fun batchesBetaTrue(): BatchesBetaTrueService = batchesBetaTrue

    override fun create(
        params: MessageCreateParams,
        requestOptions: RequestOptions,
    ): MessageCreateResponse =
        // post /v1/messages
        withRawResponse().create(params, requestOptions).parse()

    override fun countTokens(
        params: MessageCountTokensParams,
        requestOptions: RequestOptions,
    ): MessageCountTokensResponse =
        // post /v1/messages/count_tokens
        withRawResponse().countTokens(params, requestOptions).parse()

    override fun countTokensBeta(
        params: MessageCountTokensBetaParams,
        requestOptions: RequestOptions,
    ): MessageCountTokensBetaResponse =
        // post /v1/messages/count_tokens?beta=true
        withRawResponse().countTokensBeta(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessageService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val batches: BatchService.WithRawResponse by lazy {
            BatchServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val batchesBetaTrue: BatchesBetaTrueService.WithRawResponse by lazy {
            BatchesBetaTrueServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun batches(): BatchService.WithRawResponse = batches

        override fun batchesBetaTrue(): BatchesBetaTrueService.WithRawResponse = batchesBetaTrue

        private val createHandler: Handler<MessageCreateResponse> =
            jsonHandler<MessageCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: MessageCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "messages")
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

        private val countTokensHandler: Handler<MessageCountTokensResponse> =
            jsonHandler<MessageCountTokensResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun countTokens(
            params: MessageCountTokensParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageCountTokensResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "messages", "count_tokens")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { countTokensHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val countTokensBetaHandler: Handler<MessageCountTokensBetaResponse> =
            jsonHandler<MessageCountTokensBetaResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun countTokensBeta(
            params: MessageCountTokensBetaParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageCountTokensBetaResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "messages", "count_tokens")
                    .putQueryParam("beta", "true")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { countTokensBetaHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
