// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.messages.batches

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
import me.elborai.api.core.prepare
import me.elborai.api.errors.SamError
import me.elborai.api.models.MessageBatchBetaTrueDeleteParams
import me.elborai.api.models.MessageBatchBetaTrueDeleteResponse
import me.elborai.api.models.MessageBatchBetaTrueRetrieveParams
import me.elborai.api.models.MessageBatchBetaTrueRetrieveResponse

class BetaTrueServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    BetaTrueService {

    private val withRawResponse: BetaTrueService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BetaTrueService.WithRawResponse = withRawResponse

    override fun retrieve(
        params: MessageBatchBetaTrueRetrieveParams,
        requestOptions: RequestOptions,
    ): MessageBatchBetaTrueRetrieveResponse =
        // get /v1/messages/batches/{message_batch_id}?beta=true
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun delete(
        params: MessageBatchBetaTrueDeleteParams,
        requestOptions: RequestOptions,
    ): MessageBatchBetaTrueDeleteResponse =
        // delete /v1/messages/batches/{message_batch_id}?beta=true
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BetaTrueService.WithRawResponse {

        private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<MessageBatchBetaTrueRetrieveResponse> =
            jsonHandler<MessageBatchBetaTrueRetrieveResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieve(
            params: MessageBatchBetaTrueRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageBatchBetaTrueRetrieveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "messages", "batches", params.getPathParam(0))
                    .putQueryParam("beta", "true")
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

        private val deleteHandler: Handler<MessageBatchBetaTrueDeleteResponse> =
            jsonHandler<MessageBatchBetaTrueDeleteResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun delete(
            params: MessageBatchBetaTrueDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessageBatchBetaTrueDeleteResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("v1", "messages", "batches", params.getPathParam(0))
                    .putQueryParam("beta", "true")
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
    }
}
