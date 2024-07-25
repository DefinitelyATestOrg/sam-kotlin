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
import software.elborai.api.models.RealTimePaymentsTransfer
import software.elborai.api.models.RealTimePaymentsTransferCreateParams
import software.elborai.api.models.RealTimePaymentsTransferListPage
import software.elborai.api.models.RealTimePaymentsTransferListParams
import software.elborai.api.models.RealTimePaymentsTransferRetrieveParams
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

class RealTimePaymentsTransferServiceImpl constructor(private val clientOptions: ClientOptions, ) : RealTimePaymentsTransferService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<RealTimePaymentsTransfer> =
    jsonHandler<RealTimePaymentsTransfer>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create a Real-Time Payments Transfer */
    override fun create(params: RealTimePaymentsTransferCreateParams, requestOptions: RequestOptions): RealTimePaymentsTransfer {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("real_time_payments_transfers")
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

    private val retrieveHandler: Handler<RealTimePaymentsTransfer> =
    jsonHandler<RealTimePaymentsTransfer>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve a Real-Time Payments Transfer */
    override fun retrieve(params: RealTimePaymentsTransferRetrieveParams, requestOptions: RequestOptions): RealTimePaymentsTransfer {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("real_time_payments_transfers", params.getPathParam(0))
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

    private val listHandler: Handler<RealTimePaymentsTransferListPage.Response> =
    jsonHandler<RealTimePaymentsTransferListPage.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Real-Time Payments Transfers */
    override fun list(params: RealTimePaymentsTransferListParams, requestOptions: RequestOptions): RealTimePaymentsTransferListPage {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("real_time_payments_transfers")
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
              RealTimePaymentsTransferListPage.of(this, params, it)
          }
      }
    }
}
