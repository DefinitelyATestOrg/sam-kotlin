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
import software.elborai.api.errors.SamInvalidDataException
import software.elborai.api.models.ApiResponse
import software.elborai.api.models.Pet
import software.elborai.api.models.PetCreateParams
import software.elborai.api.models.PetDeleteParams
import software.elborai.api.models.PetFindByStatusParams
import software.elborai.api.models.PetFindByTagsParams
import software.elborai.api.models.PetRetrieveParams
import software.elborai.api.models.PetUpdateParams
import software.elborai.api.models.PetUploadImageParams
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

class PetServiceImpl constructor(private val clientOptions: ClientOptions, ) : PetService {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Void?> =
    emptyHandler()
    .withErrorHandler(errorHandler)

    /** Updates a pet in the store with form data */
    override fun create(params: PetCreateParams, requestOptions: RequestOptions) {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("pet", params.getPathParam(0))
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
      clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              createHandler.handle(it)
          }
      }
    }

    private val retrieveHandler: Handler<Pet> =
    jsonHandler<Pet>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Returns a single pet */
    override fun retrieve(params: PetRetrieveParams, requestOptions: RequestOptions): Pet {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("pet", params.getPathParam(0))
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

    private val updateHandler: Handler<Pet> =
    jsonHandler<Pet>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Update an existing pet by Id */
    override fun update(params: PetUpdateParams, requestOptions: RequestOptions): Pet {
      val request = HttpRequest.builder()
        .method(HttpMethod.PUT)
        .addPathSegments("pet")
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

    private val deleteHandler: Handler<Void?> =
    emptyHandler()
    .withErrorHandler(errorHandler)

    /** Deletes a pet */
    override fun delete(params: PetDeleteParams, requestOptions: RequestOptions) {
      val request = HttpRequest.builder()
        .method(HttpMethod.DELETE)
        .addPathSegments("pet", params.getPathParam(0))
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
      clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              deleteHandler.handle(it)
          }
      }
    }

    private val findByStatusHandler: Handler<List<Pet>> =
    jsonHandler<List<Pet>>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Multiple status values can be provided with comma separated strings */
    override fun findByStatus(params: PetFindByStatusParams, requestOptions: RequestOptions): List<Pet> {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("pet", "findByStatus")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              findByStatusHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                forEach { it.validate() }
              }
          }
      }
    }

    private val findByTagsHandler: Handler<List<Pet>> =
    jsonHandler<List<Pet>>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3
     * for testing.
     */
    override fun findByTags(params: PetFindByTagsParams, requestOptions: RequestOptions): List<Pet> {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("pet", "findByTags")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              findByTagsHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                forEach { it.validate() }
              }
          }
      }
    }

    private val uploadImageHandler: Handler<ApiResponse> =
    jsonHandler<ApiResponse>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** uploads an image */
    override fun uploadImage(params: PetUploadImageParams, requestOptions: RequestOptions): ApiResponse {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("pet", params.getPathParam(0), "uploadImage")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              uploadImageHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
