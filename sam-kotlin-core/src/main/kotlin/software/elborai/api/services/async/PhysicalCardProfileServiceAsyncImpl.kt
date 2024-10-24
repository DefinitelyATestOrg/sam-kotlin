// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

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
import software.elborai.api.errors.IncreaseInvalidDataException
import software.elborai.api.models.PhysicalCardProfile
import software.elborai.api.models.PhysicalCardProfileArchiveParams
import software.elborai.api.models.PhysicalCardProfileCloneParams
import software.elborai.api.models.PhysicalCardProfileCreateParams
import software.elborai.api.models.PhysicalCardProfileListPageAsync
import software.elborai.api.models.PhysicalCardProfileListParams
import software.elborai.api.models.PhysicalCardProfileRetrieveParams
import software.elborai.api.core.ClientOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.core.JsonField
import software.elborai.api.core.JsonValue
import software.elborai.api.core.RequestOptions
import software.elborai.api.errors.IncreaseError
import software.elborai.api.services.emptyHandler
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.multipartFormData
import software.elborai.api.services.stringHandler
import software.elborai.api.services.binaryHandler
import software.elborai.api.services.withErrorHandler

class PhysicalCardProfileServiceAsyncImpl constructor(private val clientOptions: ClientOptions, ) : PhysicalCardProfileServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<PhysicalCardProfile> =
    jsonHandler<PhysicalCardProfile>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create a Physical Card Profile */
    override suspend fun create(params: PhysicalCardProfileCreateParams, requestOptions: RequestOptions): PhysicalCardProfile {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("physical_card_profiles")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              createHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val retrieveHandler: Handler<PhysicalCardProfile> =
    jsonHandler<PhysicalCardProfile>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve a Card Profile */
    override suspend fun retrieve(params: PhysicalCardProfileRetrieveParams, requestOptions: RequestOptions): PhysicalCardProfile {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("physical_card_profiles", params.getPathParam(0))
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              retrieveHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val listHandler: Handler<PhysicalCardProfileListPageAsync.Response> =
    jsonHandler<PhysicalCardProfileListPageAsync.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Physical Card Profiles */
    override suspend fun list(params: PhysicalCardProfileListParams, requestOptions: RequestOptions): PhysicalCardProfileListPageAsync {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("physical_card_profiles")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              listHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
          .let {
              PhysicalCardProfileListPageAsync.of(this, params, it)
          }
      }
    }

    private val archiveHandler: Handler<PhysicalCardProfile> =
    jsonHandler<PhysicalCardProfile>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Archive a Physical Card Profile */
    override suspend fun archive(params: PhysicalCardProfileArchiveParams, requestOptions: RequestOptions): PhysicalCardProfile {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("physical_card_profiles", params.getPathParam(0), "archive")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .apply {
            params.getBody()?.also {
                body(json(clientOptions.jsonMapper, it))
            }
        }
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              archiveHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val cloneHandler: Handler<PhysicalCardProfile> =
    jsonHandler<PhysicalCardProfile>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Clone a Physical Card Profile */
    override suspend fun clone(params: PhysicalCardProfileCloneParams, requestOptions: RequestOptions): PhysicalCardProfile {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("physical_card_profiles", params.getPathParam(0), "clone")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              cloneHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
