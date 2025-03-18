// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.core.ClientOptions
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.handlers.errorHandler
import me.elborai.api.core.handlers.jsonHandler
import me.elborai.api.core.handlers.withErrorHandler
import me.elborai.api.core.http.HttpMethod
import me.elborai.api.core.http.HttpRequest
import me.elborai.api.core.http.HttpResponse.Handler
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.core.http.parseable
import me.elborai.api.core.prepare
import me.elborai.api.errors.SamError
import me.elborai.api.models.models.ModelListParams
import me.elborai.api.models.models.ModelListResponse
import me.elborai.api.models.models.ModelRetrieveBetaParams
import me.elborai.api.models.models.ModelRetrieveBetaResponse
import me.elborai.api.models.models.ModelRetrieveParams
import me.elborai.api.models.models.ModelRetrieveResponse

class ModelServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ModelService {

    private val withRawResponse: ModelService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ModelService.WithRawResponse = withRawResponse

    override fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions,
    ): ModelRetrieveResponse =
        // get /v1/models/{model_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: ModelListParams, requestOptions: RequestOptions): ModelListResponse =
        // get /v1/models
        withRawResponse().list(params, requestOptions).parse()

    override fun retrieveBeta(
        params: ModelRetrieveBetaParams,
        requestOptions: RequestOptions,
    ): ModelRetrieveBetaResponse =
        // get /v1/models/{model_id}?beta=true
        withRawResponse().retrieveBeta(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ModelService.WithRawResponse {

        private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<ModelRetrieveResponse> =
            jsonHandler<ModelRetrieveResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieve(
            params: ModelRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ModelRetrieveResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "models", params._pathParam(0))
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

        private val listHandler: Handler<ModelListResponse> =
            jsonHandler<ModelListResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun list(
            params: ModelListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ModelListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "models")
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

        private val retrieveBetaHandler: Handler<ModelRetrieveBetaResponse> =
            jsonHandler<ModelRetrieveBetaResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun retrieveBeta(
            params: ModelRetrieveBetaParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ModelRetrieveBetaResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("v1", "models", params._pathParam(0))
                    .putQueryParam("beta", "true")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
