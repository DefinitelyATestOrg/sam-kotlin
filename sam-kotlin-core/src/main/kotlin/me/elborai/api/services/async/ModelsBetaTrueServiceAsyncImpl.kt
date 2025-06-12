// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

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
import me.elborai.api.core.http.parseable
import me.elborai.api.core.prepareAsync
import me.elborai.api.models.modelsbetatrue.ModelsBetaTrueListParams
import me.elborai.api.models.modelsbetatrue.ModelsBetaTrueListResponse

class ModelsBetaTrueServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : ModelsBetaTrueServiceAsync {

    private val withRawResponse: ModelsBetaTrueServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ModelsBetaTrueServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: (ClientOptions.Builder) -> Unit
    ): ModelsBetaTrueServiceAsync =
        ModelsBetaTrueServiceAsyncImpl(clientOptions.toBuilder().apply(modifier).build())

    override suspend fun list(
        params: ModelsBetaTrueListParams,
        requestOptions: RequestOptions,
    ): ModelsBetaTrueListResponse =
        // get /v1/models?beta=true
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ModelsBetaTrueServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ModelsBetaTrueServiceAsync.WithRawResponse =
            ModelsBetaTrueServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier).build()
            )

        private val listHandler: Handler<ModelsBetaTrueListResponse> =
            jsonHandler<ModelsBetaTrueListResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun list(
            params: ModelsBetaTrueListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ModelsBetaTrueListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "models")
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
