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
import software.elborai.api.models.EntitySupplementalDocumentCreateParams
import software.elborai.api.models.EntitySupplementalDocumentListPage
import software.elborai.api.models.EntitySupplementalDocumentListParams
import software.elborai.api.models.SupplementalDocument
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

class SupplementalDocumentServiceImpl constructor(private val clientOptions: ClientOptions, ) : SupplementalDocumentService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Entity> =
    jsonHandler<Entity>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create a supplemental document for an Entity */
    override fun create(params: EntitySupplementalDocumentCreateParams, requestOptions: RequestOptions): Entity {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("entities", params.getPathParam(0), "supplemental_documents")
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

    private val listHandler: Handler<EntitySupplementalDocumentListPage.Response> =
    jsonHandler<EntitySupplementalDocumentListPage.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Entity Supplemental Document Submissions */
    override fun list(params: EntitySupplementalDocumentListParams, requestOptions: RequestOptions): EntitySupplementalDocumentListPage {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("entity_supplemental_documents")
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
              EntitySupplementalDocumentListPage.of(this, params, it)
          }
      }
    }
}
