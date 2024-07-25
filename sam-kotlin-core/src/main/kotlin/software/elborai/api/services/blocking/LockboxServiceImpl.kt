// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

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
import software.elborai.api.models.Lockbox
import software.elborai.api.models.LockboxCreateParams
import software.elborai.api.models.LockboxList
import software.elborai.api.models.LockboxListPage
import software.elborai.api.models.LockboxListParams
import software.elborai.api.models.LockboxRetrieveParams
import software.elborai.api.models.LockboxUpdateParams
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

class LockboxServiceImpl constructor(private val clientOptions: ClientOptions, ) : LockboxService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Lockbox> =
    jsonHandler<Lockbox>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create a Lockbox */
    override fun create(params: LockboxCreateParams, requestOptions: RequestOptions): Lockbox {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("lockboxes")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
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

    private val retrieveHandler: Handler<Lockbox> =
    jsonHandler<Lockbox>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve a Lockbox */
    override fun retrieve(params: LockboxRetrieveParams, requestOptions: RequestOptions): Lockbox {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("lockboxes", params.getPathParam(0))
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
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

    private val updateHandler: Handler<Lockbox> =
    jsonHandler<Lockbox>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Update a Lockbox */
    override fun update(params: LockboxUpdateParams, requestOptions: RequestOptions): Lockbox {
      val request = HttpRequest.builder()
        .method(HttpMethod.PATCH)
        .addPathSegments("lockboxes", params.getPathParam(0))
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              updateHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val listHandler: Handler<LockboxListPage.Response> =
    jsonHandler<LockboxListPage.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Lockboxes */
    override fun list(params: LockboxListParams, requestOptions: RequestOptions): LockboxListPage {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("lockboxes")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
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
              LockboxListPage.of(this, params, it)
          }
      }
    }
}
