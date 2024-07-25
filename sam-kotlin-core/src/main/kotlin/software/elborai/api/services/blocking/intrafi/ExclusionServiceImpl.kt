// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.intrafi

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
import software.elborai.api.models.IntrafiExclusion
import software.elborai.api.models.IntrafiExclusionArchiveParams
import software.elborai.api.models.IntrafiExclusionCreateParams
import software.elborai.api.models.IntrafiExclusionListPage
import software.elborai.api.models.IntrafiExclusionListParams
import software.elborai.api.models.IntrafiExclusionRetrieveParams
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

class ExclusionServiceImpl constructor(private val clientOptions: ClientOptions, ) : ExclusionService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<IntrafiExclusion> =
    jsonHandler<IntrafiExclusion>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create an IntraFi Exclusion */
    override fun create(params: IntrafiExclusionCreateParams, requestOptions: RequestOptions): IntrafiExclusion {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("intrafi_exclusions")
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

    private val retrieveHandler: Handler<IntrafiExclusion> =
    jsonHandler<IntrafiExclusion>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Get an IntraFi Exclusion */
    override fun retrieve(params: IntrafiExclusionRetrieveParams, requestOptions: RequestOptions): IntrafiExclusion {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("intrafi_exclusions", params.getPathParam(0))
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

    private val listHandler: Handler<IntrafiExclusionListPage.Response> =
    jsonHandler<IntrafiExclusionListPage.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List IntraFi Exclusions. */
    override fun list(params: IntrafiExclusionListParams, requestOptions: RequestOptions): IntrafiExclusionListPage {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("intrafi_exclusions")
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
              IntrafiExclusionListPage.of(this, params, it)
          }
      }
    }

    private val archiveHandler: Handler<IntrafiExclusion> =
    jsonHandler<IntrafiExclusion>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Archive an IntraFi Exclusion */
    override fun archive(params: IntrafiExclusionArchiveParams, requestOptions: RequestOptions): IntrafiExclusion {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("intrafi_exclusions", params.getPathParam(0), "archive")
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
}
