// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

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
import me.elborai.api.core.http.parseable
import me.elborai.api.core.prepareAsync
import me.elborai.api.models.models.ModelListParams
import me.elborai.api.models.models.ModelListResponse
import me.elborai.api.models.models.ModelRetrieveBetaParams
import me.elborai.api.models.models.ModelRetrieveBetaResponse
import me.elborai.api.models.models.ModelRetrieveParams
import me.elborai.api.models.models.ModelRetrieveResponse

class ModelServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ModelServiceAsync {

    private val withRawResponse: ModelServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ModelServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ModelServiceAsync =
        ModelServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions,
    ): ModelRetrieveResponse =
        // get /v1/models/{model_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override suspend fun list(
        params: ModelListParams,
        requestOptions: RequestOptions,
    ): ModelListResponse =
        // get /v1/models
        withRawResponse().list(params, requestOptions).parse()

    override suspend fun retrieveBeta(
        params: ModelRetrieveBetaParams,
        requestOptions: RequestOptions,
    ): ModelRetrieveBetaResponse =
        // get /v1/models/{model_id}?beta=true
        withRawResponse().retrieveBeta(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ModelServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ModelServiceAsync.WithRawResponse =
            ModelServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val retrieveHandler: Handler<ModelRetrieveResponse> =
            jsonHandler<ModelRetrieveResponse>(clientOptions.jsonMapper)

        override suspend fun retrieve(
            params: ModelRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ModelRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("modelId", params.modelId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "models", params._pathParam(0))
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

        private val listHandler: Handler<ModelListResponse> =
            jsonHandler<ModelListResponse>(clientOptions.jsonMapper)

        override suspend fun list(
            params: ModelListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ModelListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "models")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveBetaHandler: Handler<ModelRetrieveBetaResponse> =
            jsonHandler<ModelRetrieveBetaResponse>(clientOptions.jsonMapper)

        override suspend fun retrieveBeta(
            params: ModelRetrieveBetaParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ModelRetrieveBetaResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("modelId", params.modelId())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "models", params._pathParam(0))
                    .putQueryParam("beta", "true")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.executeAsync(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveBetaHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
