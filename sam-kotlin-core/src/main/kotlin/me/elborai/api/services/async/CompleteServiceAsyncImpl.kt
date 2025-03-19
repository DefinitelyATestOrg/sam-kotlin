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
import me.elborai.api.core.http.json
import me.elborai.api.core.http.parseable
import me.elborai.api.core.prepareAsync
import me.elborai.api.models.complete.CompleteCreateParams
import me.elborai.api.models.complete.CompleteCreateResponse

class CompleteServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CompleteServiceAsync {

    private val withRawResponse: CompleteServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CompleteServiceAsync.WithRawResponse = withRawResponse

    override suspend fun create(
        params: CompleteCreateParams,
        requestOptions: RequestOptions,
    ): CompleteCreateResponse =
        // post /v1/complete
        withRawResponse().create(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CompleteServiceAsync.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<CompleteCreateResponse> =
            jsonHandler<CompleteCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override suspend fun create(
            params: CompleteCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CompleteCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "complete")
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
    }
}
