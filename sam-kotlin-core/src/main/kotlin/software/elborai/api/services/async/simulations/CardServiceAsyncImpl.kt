// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async.simulations

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
import software.elborai.api.models.CardAuthorizationSimulation
import software.elborai.api.models.SimulationCardAuthorizeParams
import software.elborai.api.models.SimulationCardSettlementParams
import software.elborai.api.models.Transaction
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

class CardServiceAsyncImpl constructor(private val clientOptions: ClientOptions, ) : CardServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val authorizeHandler: Handler<CardAuthorizationSimulation> =
    jsonHandler<CardAuthorizationSimulation>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Simulates a purchase authorization on a [Card](#cards). Depending on the balance
     * available to the card and the `amount` submitted, the authorization activity
     * will result in a [Pending Transaction](#pending-transactions) of type
     * `card_authorization` or a [Declined Transaction](#declined-transactions) of type
     * `card_decline`. You can pass either a Card id or a
     * [Digital Wallet Token](#digital-wallet-tokens) id to simulate the two different
     * ways purchases can be made.
     */
    override suspend fun authorize(params: SimulationCardAuthorizeParams, requestOptions: RequestOptions): CardAuthorizationSimulation {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("simulations", "card_authorizations")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              authorizeHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val settlementHandler: Handler<Transaction> =
    jsonHandler<Transaction>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Simulates the settlement of an authorization by a card acquirer. After a card
     * authorization is created, the merchant will eventually send a settlement. This
     * simulates that event, which may occur many days after the purchase in
     * production. The amount settled can be different from the amount originally
     * authorized, for example, when adding a tip to a restaurant bill.
     */
    override suspend fun settlement(params: SimulationCardSettlementParams, requestOptions: RequestOptions): Transaction {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("simulations", "card_settlements")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              settlementHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
