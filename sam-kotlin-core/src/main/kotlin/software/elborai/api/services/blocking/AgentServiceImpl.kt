// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

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
import software.elborai.api.services.binaryHandler
import software.elborai.api.services.blocking.agents.ConfigService
import software.elborai.api.services.blocking.agents.ConfigServiceImpl
import software.elborai.api.services.blocking.agents.HiddenTagService
import software.elborai.api.services.blocking.agents.HiddenTagServiceImpl
import software.elborai.api.services.emptyHandler
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.withErrorHandler

class AgentServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : AgentService {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val hiddenTags: HiddenTagService by lazy { HiddenTagServiceImpl(clientOptions) }

    private val configs: ConfigService by lazy { ConfigServiceImpl(clientOptions) }

    override fun hiddenTags(): HiddenTagService = hiddenTags

    override fun configs(): ConfigService = configs

    private val retrieveHandler: Handler<BinaryResponseContent> =
        binaryHandler().withErrorHandler(errorHandler)

    override fun retrieve(
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
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response.let { retrieveHandler.handle(it) }
        }
    }

    private val updateHandler: Handler<BinaryResponseContent> =
        binaryHandler().withErrorHandler(errorHandler)

    override fun update(
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
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response.let { updateHandler.handle(it) }
        }
    }

    private val deleteHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    override fun delete(params: AgentDeleteParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("api", "v1", "agents", params.getPathParam(0))
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody()?.also { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response.use { deleteHandler.handle(it) }
        }
    }
}
