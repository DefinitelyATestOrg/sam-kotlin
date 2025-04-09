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
import me.elborai.api.models.samplopplop.SamPlopPlopCreateMessageParams
import me.elborai.api.models.samplopplop.SamPlopPlopCreateMessageResponse

class SamPlopPlopServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SamPlopPlopService {

    private val withRawResponse: SamPlopPlopService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SamPlopPlopService.WithRawResponse = withRawResponse

    override fun createMessage(
        params: SamPlopPlopCreateMessageParams,
        requestOptions: RequestOptions,
    ): SamPlopPlopCreateMessageResponse =
        // post /v1/sam-plop-plop
        withRawResponse().createMessage(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SamPlopPlopService.WithRawResponse {

        private val errorHandler: Handler<JsonValue> = errorHandler(clientOptions.jsonMapper)

        private val createMessageHandler: Handler<SamPlopPlopCreateMessageResponse> =
            jsonHandler<SamPlopPlopCreateMessageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun createMessage(
            params: SamPlopPlopCreateMessageParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SamPlopPlopCreateMessageResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "sam-plop-plop")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createMessageHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
