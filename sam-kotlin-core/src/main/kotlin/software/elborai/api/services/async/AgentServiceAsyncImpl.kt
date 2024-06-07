// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.SamError
import software.elborai.api.models.AgentDeleteParams
import software.elborai.api.models.AgentRetrieveParams
import software.elborai.api.models.AgentUpdateParams
import software.elborai.api.services.async.agents.ConfigServiceAsync
import software.elborai.api.services.async.agents.ConfigServiceAsyncImpl
import software.elborai.api.services.async.agents.HiddenTagServiceAsync
import software.elborai.api.services.async.agents.HiddenTagServiceAsyncImpl
import software.elborai.api.services.binaryHandler
import software.elborai.api.services.emptyHandler
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.withErrorHandler

class AgentServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : AgentServiceAsync {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val hiddenTags: HiddenTagServiceAsync by lazy {
        HiddenTagServiceAsyncImpl(clientOptions)
    }

    private val configs: ConfigServiceAsync by lazy { ConfigServiceAsyncImpl(clientOptions) }

    override fun hiddenTags(): HiddenTagServiceAsync = hiddenTags

    override fun configs(): ConfigServiceAsync = configs

    private val retrieveHandler: Handler<BinaryResponseContent> =
        binaryHandler().withErrorHandler(errorHandler)

    override suspend fun retrieve(
        params: AgentRetrieveParams,
        requestOptions: RequestOptions
    ): BinaryResponseContent {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("api", "v1", "agents", params.getPathParam(0))
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
        params: AgentUpdateParams,
        requestOptions: RequestOptions
    ): BinaryResponseContent {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PUT)
                .addPathSegments("api", "v1", "agents", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response.let { updateHandler.handle(it) }
        }
    }

    private val deleteHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    override suspend fun delete(params: AgentDeleteParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("api", "v1", "agents", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody()?.also { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response.use { deleteHandler.handle(it) }
        }
    }
}
