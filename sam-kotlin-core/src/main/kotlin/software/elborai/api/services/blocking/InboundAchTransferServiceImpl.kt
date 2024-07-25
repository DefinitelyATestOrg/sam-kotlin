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
import software.elborai.api.models.InboundAchTransfer
import software.elborai.api.models.InboundAchTransferDeclineParams
import software.elborai.api.models.InboundAchTransferListPage
import software.elborai.api.models.InboundAchTransferListParams
import software.elborai.api.models.InboundAchTransferNotificationOfChangeParams
import software.elborai.api.models.InboundAchTransferRetrieveParams
import software.elborai.api.models.InboundAchTransferTransferReturnParams
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

class InboundAchTransferServiceImpl constructor(private val clientOptions: ClientOptions, ) : InboundAchTransferService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<InboundAchTransfer> =
    jsonHandler<InboundAchTransfer>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve an Inbound ACH Transfer */
    override fun retrieve(params: InboundAchTransferRetrieveParams, requestOptions: RequestOptions): InboundAchTransfer {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("inbound_ach_transfers", params.getPathParam(0))
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

    private val listHandler: Handler<InboundAchTransferListPage.Response> =
    jsonHandler<InboundAchTransferListPage.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Inbound ACH Transfers */
    override fun list(params: InboundAchTransferListParams, requestOptions: RequestOptions): InboundAchTransferListPage {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("inbound_ach_transfers")
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
              InboundAchTransferListPage.of(this, params, it)
          }
      }
    }

    private val declineHandler: Handler<InboundAchTransfer> =
    jsonHandler<InboundAchTransfer>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Decline an Inbound ACH Transfer */
    override fun decline(params: InboundAchTransferDeclineParams, requestOptions: RequestOptions): InboundAchTransfer {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("inbound_ach_transfers", params.getPathParam(0), "decline")
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
              declineHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val notificationOfChangeHandler: Handler<InboundAchTransfer> =
    jsonHandler<InboundAchTransfer>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create a notification of change for an Inbound ACH Transfer */
    override fun notificationOfChange(params: InboundAchTransferNotificationOfChangeParams, requestOptions: RequestOptions): InboundAchTransfer {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("inbound_ach_transfers", params.getPathParam(0), "notification_of_change")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              notificationOfChangeHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val transferReturnHandler: Handler<InboundAchTransfer> =
    jsonHandler<InboundAchTransfer>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Return an Inbound ACH Transfer */
    override fun transferReturn(params: InboundAchTransferTransferReturnParams, requestOptions: RequestOptions): InboundAchTransfer {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("inbound_ach_transfers", params.getPathParam(0), "transfer_return")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              transferReturnHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
