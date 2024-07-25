// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

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
import software.elborai.api.models.CardDispute
import software.elborai.api.models.SimulationCardDisputeActionParams
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

class CardDisputeServiceImpl constructor(private val clientOptions: ClientOptions, ) : CardDisputeService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val actionHandler: Handler<CardDispute> =
    jsonHandler<CardDispute>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * After a [Card Dispute](#card-disputes) is created in production, the dispute
     * will be reviewed. Since no review happens in sandbox, this endpoint simulates
     * moving a Card Dispute into a rejected or accepted state. A Card Dispute can only
     * be actioned one time and must have a status of `pending_reviewing`.
     */
    override fun action(params: SimulationCardDisputeActionParams, requestOptions: RequestOptions): CardDispute {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("simulations", "card_disputes", params.getPathParam(0), "action")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              actionHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
