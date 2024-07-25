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
import software.elborai.api.models.PhysicalCard
import software.elborai.api.models.PhysicalCardCreateParams
import software.elborai.api.models.PhysicalCardListPage
import software.elborai.api.models.PhysicalCardListParams
import software.elborai.api.models.PhysicalCardRetrieveParams
import software.elborai.api.models.PhysicalCardUpdateParams
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

class PhysicalCardServiceImpl constructor(private val clientOptions: ClientOptions, ) : PhysicalCardService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<PhysicalCard> =
    jsonHandler<PhysicalCard>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create a Physical Card */
    override fun create(params: PhysicalCardCreateParams, requestOptions: RequestOptions): PhysicalCard {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("physical_cards")
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

    private val retrieveHandler: Handler<PhysicalCard> =
    jsonHandler<PhysicalCard>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve a Physical Card */
    override fun retrieve(params: PhysicalCardRetrieveParams, requestOptions: RequestOptions): PhysicalCard {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("physical_cards", params.getPathParam(0))
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

    private val updateHandler: Handler<PhysicalCard> =
    jsonHandler<PhysicalCard>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Update a Physical Card */
    override fun update(params: PhysicalCardUpdateParams, requestOptions: RequestOptions): PhysicalCard {
      val request = HttpRequest.builder()
        .method(HttpMethod.PATCH)
        .addPathSegments("physical_cards", params.getPathParam(0))
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

    private val listHandler: Handler<PhysicalCardListPage.Response> =
    jsonHandler<PhysicalCardListPage.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Physical Cards */
    override fun list(params: PhysicalCardListParams, requestOptions: RequestOptions): PhysicalCardListPage {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("physical_cards")
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
              PhysicalCardListPage.of(this, params, it)
          }
      }
    }
}
