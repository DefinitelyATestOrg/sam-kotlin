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
import software.elborai.api.models.Entity
import software.elborai.api.models.EntityArchiveParams
import software.elborai.api.models.EntityConfirmParams
import software.elborai.api.models.EntityCreateParams
import software.elborai.api.models.EntityListPageAsync
import software.elborai.api.models.EntityListParams
import software.elborai.api.models.EntityRetrieveParams
import software.elborai.api.models.EntityUpdateAddressParams
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
import software.elborai.api.services.async.entities.BeneficialOwnerServiceAsync
import software.elborai.api.services.async.entities.BeneficialOwnerServiceAsyncImpl
import software.elborai.api.services.async.entities.SupplementalDocumentServiceAsync
import software.elborai.api.services.async.entities.SupplementalDocumentServiceAsyncImpl
import software.elborai.api.services.async.entities.IndustryCodeServiceAsync
import software.elborai.api.services.async.entities.IndustryCodeServiceAsyncImpl

class EntityServiceAsyncImpl constructor(private val clientOptions: ClientOptions, ) : EntityServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val beneficialOwners: BeneficialOwnerServiceAsync by lazy { BeneficialOwnerServiceAsyncImpl(clientOptions) }

    private val supplementalDocuments: SupplementalDocumentServiceAsync by lazy { SupplementalDocumentServiceAsyncImpl(clientOptions) }

    private val industryCode: IndustryCodeServiceAsync by lazy { IndustryCodeServiceAsyncImpl(clientOptions) }

    override fun beneficialOwners(): BeneficialOwnerServiceAsync = beneficialOwners

    override fun supplementalDocuments(): SupplementalDocumentServiceAsync = supplementalDocuments

    override fun industryCode(): IndustryCodeServiceAsync = industryCode

    private val createHandler: Handler<Entity> =
    jsonHandler<Entity>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create an Entity */
    override suspend fun create(params: EntityCreateParams, requestOptions: RequestOptions): Entity {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("entities")
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

    private val retrieveHandler: Handler<Entity> =
    jsonHandler<Entity>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve an Entity */
    override suspend fun retrieve(params: EntityRetrieveParams, requestOptions: RequestOptions): Entity {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("entities", params.getPathParam(0))
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

    private val listHandler: Handler<EntityListPageAsync.Response> =
    jsonHandler<EntityListPageAsync.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Entities */
    override suspend fun list(params: EntityListParams, requestOptions: RequestOptions): EntityListPageAsync {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("entities")
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
              EntityListPageAsync.of(this, params, it)
          }
      }
    }

    private val archiveHandler: Handler<Entity> =
    jsonHandler<Entity>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Archive an Entity */
    override suspend fun archive(params: EntityArchiveParams, requestOptions: RequestOptions): Entity {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("entities", params.getPathParam(0), "archive")
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

    private val confirmHandler: Handler<Entity> =
    jsonHandler<Entity>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Depending on your program, you may be required to re-confirm an Entity's details
     * on a recurring basis. After making any required updates, call this endpoint to
     * record that your user confirmed their details.
     */
    override suspend fun confirm(params: EntityConfirmParams, requestOptions: RequestOptions): Entity {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("entities", params.getPathParam(0), "confirm")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              confirmHandler.handle(it)
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

    /** Update a Natural Person or Corporation's address */
    override suspend fun updateAddress(params: EntityUpdateAddressParams, requestOptions: RequestOptions): Entity {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("entities", params.getPathParam(0), "address")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
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
