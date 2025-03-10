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
import me.elborai.api.core.http.json
import me.elborai.api.core.http.parseable
import me.elborai.api.core.prepare
import me.elborai.api.errors.SamError
import me.elborai.api.models.MessagesBetaTrueCreateParams
import me.elborai.api.models.MessagesBetaTrueCreateResponse

class MessagesBetaTrueServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MessagesBetaTrueService {

    private val withRawResponse: MessagesBetaTrueService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MessagesBetaTrueService.WithRawResponse = withRawResponse

    override fun create(
        params: MessagesBetaTrueCreateParams,
        requestOptions: RequestOptions,
    ): MessagesBetaTrueCreateResponse =
        // post /v1/messages?beta=true
        withRawResponse().create(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MessagesBetaTrueService.WithRawResponse {

        private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<MessagesBetaTrueCreateResponse> =
            jsonHandler<MessagesBetaTrueCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: MessagesBetaTrueCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<MessagesBetaTrueCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("v1", "messages")
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
    }
}
