// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.entities

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
import software.elborai.api.models.Entity
import software.elborai.api.models.EntityBeneficialOwnerArchiveParams
import software.elborai.api.models.EntityBeneficialOwnerCreateParams
import software.elborai.api.models.EntityBeneficialOwnerUpdateAddressParams
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

class BeneficialOwnerServiceImpl constructor(private val clientOptions: ClientOptions, ) : BeneficialOwnerService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Entity> =
    jsonHandler<Entity>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create a beneficial owner for a corporate Entity */
    override fun create(params: EntityBeneficialOwnerCreateParams, requestOptions: RequestOptions): Entity {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("entity_beneficial_owners")
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

    private val archiveHandler: Handler<Entity> =
    jsonHandler<Entity>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Archive a beneficial owner for a corporate Entity */
    override fun archive(params: EntityBeneficialOwnerArchiveParams, requestOptions: RequestOptions): Entity {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("entity_beneficial_owners", "archive")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
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

    private val updateAddressHandler: Handler<Entity> =
    jsonHandler<Entity>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Update the address for a beneficial owner belonging to a corporate Entity */
    override fun updateAddress(params: EntityBeneficialOwnerUpdateAddressParams, requestOptions: RequestOptions): Entity {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("entity_beneficial_owners", "address")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              updateAddressHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
