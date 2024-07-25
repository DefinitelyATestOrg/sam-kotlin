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
import software.elborai.api.models.InboundCheckDeposit
import software.elborai.api.models.InboundCheckDepositDeclineParams
import software.elborai.api.models.InboundCheckDepositListPage
import software.elborai.api.models.InboundCheckDepositListParams
import software.elborai.api.models.InboundCheckDepositRetrieveParams
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

class InboundCheckDepositServiceImpl constructor(private val clientOptions: ClientOptions, ) : InboundCheckDepositService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<InboundCheckDeposit> =
    jsonHandler<InboundCheckDeposit>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve an Inbound Check Deposit */
    override fun retrieve(params: InboundCheckDepositRetrieveParams, requestOptions: RequestOptions): InboundCheckDeposit {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("inbound_check_deposits", params.getPathParam(0))
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

    private val listHandler: Handler<InboundCheckDepositListPage.Response> =
    jsonHandler<InboundCheckDepositListPage.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Inbound Check Deposits */
    override fun list(params: InboundCheckDepositListParams, requestOptions: RequestOptions): InboundCheckDepositListPage {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("inbound_check_deposits")
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
              InboundCheckDepositListPage.of(this, params, it)
          }
      }
    }

    private val declineHandler: Handler<InboundCheckDeposit> =
    jsonHandler<InboundCheckDeposit>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Decline an Inbound Check Deposit */
    override fun decline(params: InboundCheckDepositDeclineParams, requestOptions: RequestOptions): InboundCheckDeposit {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("inbound_check_deposits", params.getPathParam(0), "decline")
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
}
