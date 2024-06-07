// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async.agents

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import kotlin.LazyThreadSafetyMode.PUBLICATION
import java.time.LocalDate
import java.time.Duration
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Optional
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.stream.Stream
import software.elborai.api.core.Enum
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.errors.SamInvalidDataException
import software.elborai.api.models.AgentConfigRetrieveParams
import software.elborai.api.models.AgentConfigUpdateParams
import software.elborai.api.core.ClientOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.core.JsonField
import software.elborai.api.core.JsonValue
import software.elborai.api.core.RequestOptions
import software.elborai.api.errors.SamError
import software.elborai.api.services.emptyHandler
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.multipartFormData
import software.elborai.api.services.stringHandler
import software.elborai.api.services.binaryHandler
import software.elborai.api.services.withErrorHandler
import software.elborai.api.services.async.agents.configs.ChatServiceAsync
import software.elborai.api.services.async.agents.configs.ChatServiceAsyncImpl

class ConfigServiceAsyncImpl constructor(private val clientOptions: ClientOptions, ) : ConfigServiceAsync {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val chat: ChatServiceAsync by lazy { ChatServiceAsyncImpl(clientOptions) }

    override fun chat(): ChatServiceAsync = chat

    private val retrieveHandler: Handler<BinaryResponseContent> =
    binaryHandler()
    .withErrorHandler(errorHandler)

    override suspend fun retrieve(params: AgentConfigRetrieveParams, requestOptions: RequestOptions): BinaryResponseContent {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("api", "v1", "agents", params.getPathParam(0), "configs", params.getPathParam(1))
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.let {
              retrieveHandler.handle(it)
          }
      }
    }

    private val updateHandler: Handler<BinaryResponseContent> =
    binaryHandler()
    .withErrorHandler(errorHandler)

    override suspend fun update(params: AgentConfigUpdateParams, requestOptions: RequestOptions): BinaryResponseContent {
      val request = HttpRequest.builder()
        .method(HttpMethod.PUT)
        .addPathSegments("api", "v1", "agents", params.getPathParam(0), "configs", params.getPathParam(1))
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.let {
              updateHandler.handle(it)
          }
      }
    }
}
