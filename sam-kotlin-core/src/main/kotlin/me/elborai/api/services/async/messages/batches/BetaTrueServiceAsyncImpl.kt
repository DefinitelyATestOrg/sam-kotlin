// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async.messages.batches

import me.elborai.api.core.ClientOptions
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.checkRequired
import me.elborai.api.core.handlers.errorBodyHandler
import me.elborai.api.core.handlers.errorHandler
import me.elborai.api.core.handlers.jsonHandler
import me.elborai.api.core.http.HttpMethod
import me.elborai.api.core.http.HttpRequest
import me.elborai.api.core.http.HttpResponse
import me.elborai.api.core.http.HttpResponse.Handler
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.core.http.json
import me.elborai.api.core.http.parseable
import me.elborai.api.core.prepareAsync
import me.elborai.api.models.messages.batches.betatrue.BetaTrueDeleteParams
import me.elborai.api.models.messages.batches.betatrue.BetaTrueDeleteResponse
import me.elborai.api.models.messages.batches.betatrue.BetaTrueRetrieveParams
import me.elborai.api.models.messages.batches.betatrue.BetaTrueRetrieveResponse

class BetaTrueServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BetaTrueServiceAsync {

    private val withRawResponse: BetaTrueServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): BetaTrueServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): BetaTrueServiceAsync =
        BetaTrueServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun retrieve(
        params: BetaTrueRetrieveParams,
        requestOptions: RequestOptions,
    ): BetaTrueRetrieveResponse =
        // get /v1/messages/batches/{message_batch_id}?beta=true
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun delete(
        params: BetaTrueDeleteParams,
        requestOptions: RequestOptions,
    ): BetaTrueDeleteResponse =
        // delete /v1/messages/batches/{message_batch_id}?beta=true
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BetaTrueServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): BetaTrueServiceAsync.WithRawResponse =
            BetaTrueServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val retrieveHandler: Handler<BetaTrueRetrieveResponse> =
            jsonHandler<BetaTrueRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: BetaTrueRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BetaTrueRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageBatchId", params.messageBatchId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0))
                    .putQueryParam("beta", "true")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val deleteHandler: Handler<BetaTrueDeleteResponse> =
            jsonHandler<BetaTrueDeleteResponse>(clientOptions.jsonMapper)

        override suspend fun delete(
            params: BetaTrueDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BetaTrueDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("messageBatchId", params.messageBatchId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "messages", "batches", params._pathParam(0))
                    .putQueryParam("beta", "true")
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
