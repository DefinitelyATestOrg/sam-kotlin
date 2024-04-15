// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async.agents

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.SamError
import software.elborai.api.models.AgentConfigRetrieveParams
import software.elborai.api.models.AgentConfigUpdateParams
import software.elborai.api.services.async.agents.configs.ChatServiceAsync
import software.elborai.api.services.async.agents.configs.ChatServiceAsyncImpl
import software.elborai.api.services.binaryHandler
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.withErrorHandler

class ConfigServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ConfigServiceAsync {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val chat: ChatServiceAsync by lazy { ChatServiceAsyncImpl(clientOptions) }

    override fun chat(): ChatServiceAsync = chat

    private val retrieveHandler: Handler<BinaryResponseContent> =
        binaryHandler().withErrorHandler(errorHandler)

    override suspend fun retrieve(
        params: AgentConfigRetrieveParams,
        requestOptions: RequestOptions
    ): BinaryResponseContent {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "api",
                    "v1",
                    "agents",
                    params.getPathParam(0),
                    "configs",
                    params.getPathParam(1)
                )
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response.let { retrieveHandler.handle(it) }
        }
    }

    private val updateHandler: Handler<BinaryResponseContent> =
        binaryHandler().withErrorHandler(errorHandler)

    override suspend fun update(
        params: AgentConfigUpdateParams,
        requestOptions: RequestOptions
    ): BinaryResponseContent {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PUT)
                .addPathSegments(
                    "api",
                    "v1",
                    "agents",
                    params.getPathParam(0),
                    "configs",
                    params.getPathParam(1)
                )
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response.let { updateHandler.handle(it) }
        }
    }
}
