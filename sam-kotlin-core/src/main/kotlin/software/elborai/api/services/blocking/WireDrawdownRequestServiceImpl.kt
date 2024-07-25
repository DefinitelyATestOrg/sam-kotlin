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
import software.elborai.api.models.WireDrawdownRequest
import software.elborai.api.models.WireDrawdownRequestCreateParams
import software.elborai.api.models.WireDrawdownRequestListPage
import software.elborai.api.models.WireDrawdownRequestListParams
import software.elborai.api.models.WireDrawdownRequestRetrieveParams
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

class WireDrawdownRequestServiceImpl constructor(private val clientOptions: ClientOptions, ) : WireDrawdownRequestService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<WireDrawdownRequest> =
    jsonHandler<WireDrawdownRequest>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create a Wire Drawdown Request */
    override fun create(params: WireDrawdownRequestCreateParams, requestOptions: RequestOptions): WireDrawdownRequest {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("wire_drawdown_requests")
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

    private val retrieveHandler: Handler<WireDrawdownRequest> =
    jsonHandler<WireDrawdownRequest>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve a Wire Drawdown Request */
    override fun retrieve(params: WireDrawdownRequestRetrieveParams, requestOptions: RequestOptions): WireDrawdownRequest {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("wire_drawdown_requests", params.getPathParam(0))
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

    private val listHandler: Handler<WireDrawdownRequestListPage.Response> =
    jsonHandler<WireDrawdownRequestListPage.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Wire Drawdown Requests */
    override fun list(params: WireDrawdownRequestListParams, requestOptions: RequestOptions): WireDrawdownRequestListPage {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("wire_drawdown_requests")
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
              WireDrawdownRequestListPage.of(this, params, it)
          }
      }
    }
}
