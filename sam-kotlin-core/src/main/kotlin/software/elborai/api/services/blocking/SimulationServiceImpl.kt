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
import software.elborai.api.models.CardPayment
import software.elborai.api.models.SimulationCardAuthorizationExpirationsParams
import software.elborai.api.models.SimulationCardFuelConfirmationsParams
import software.elborai.api.models.SimulationCardIncrementsParams
import software.elborai.api.models.SimulationCardReversalsParams
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
import software.elborai.api.services.blocking.simulations.AccountTransferService
import software.elborai.api.services.blocking.simulations.AccountTransferServiceImpl
import software.elborai.api.services.blocking.simulations.AccountStatementService
import software.elborai.api.services.blocking.simulations.AccountStatementServiceImpl
import software.elborai.api.services.blocking.simulations.AchTransferService
import software.elborai.api.services.blocking.simulations.AchTransferServiceImpl
import software.elborai.api.services.blocking.simulations.CardDisputeService
import software.elborai.api.services.blocking.simulations.CardDisputeServiceImpl
import software.elborai.api.services.blocking.simulations.CardRefundService
import software.elborai.api.services.blocking.simulations.CardRefundServiceImpl
import software.elborai.api.services.blocking.simulations.CheckTransferService
import software.elborai.api.services.blocking.simulations.CheckTransferServiceImpl
import software.elborai.api.services.blocking.simulations.DocumentService
import software.elborai.api.services.blocking.simulations.DocumentServiceImpl
import software.elborai.api.services.blocking.simulations.DigitalWalletTokenRequestService
import software.elborai.api.services.blocking.simulations.DigitalWalletTokenRequestServiceImpl
import software.elborai.api.services.blocking.simulations.CheckDepositService
import software.elborai.api.services.blocking.simulations.CheckDepositServiceImpl
import software.elborai.api.services.blocking.simulations.ProgramService
import software.elborai.api.services.blocking.simulations.ProgramServiceImpl
import software.elborai.api.services.blocking.simulations.InboundWireDrawdownRequestService
import software.elborai.api.services.blocking.simulations.InboundWireDrawdownRequestServiceImpl
import software.elborai.api.services.blocking.simulations.InboundFundsHoldService
import software.elborai.api.services.blocking.simulations.InboundFundsHoldServiceImpl
import software.elborai.api.services.blocking.simulations.InterestPaymentService
import software.elborai.api.services.blocking.simulations.InterestPaymentServiceImpl
import software.elborai.api.services.blocking.simulations.WireTransferService
import software.elborai.api.services.blocking.simulations.WireTransferServiceImpl
import software.elborai.api.services.blocking.simulations.CardService
import software.elborai.api.services.blocking.simulations.CardServiceImpl
import software.elborai.api.services.blocking.simulations.RealTimePaymentsTransferService
import software.elborai.api.services.blocking.simulations.RealTimePaymentsTransferServiceImpl
import software.elborai.api.services.blocking.simulations.PhysicalCardService
import software.elborai.api.services.blocking.simulations.PhysicalCardServiceImpl
import software.elborai.api.services.blocking.simulations.InboundCheckDepositService
import software.elborai.api.services.blocking.simulations.InboundCheckDepositServiceImpl
import software.elborai.api.services.blocking.simulations.InboundInternationalAchTransferService
import software.elborai.api.services.blocking.simulations.InboundInternationalAchTransferServiceImpl

class SimulationServiceImpl constructor(private val clientOptions: ClientOptions, ) : SimulationService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val accountTransfers: AccountTransferService by lazy { AccountTransferServiceImpl(clientOptions) }

    private val accountStatements: AccountStatementService by lazy { AccountStatementServiceImpl(clientOptions) }

    private val achTransfers: AchTransferService by lazy { AchTransferServiceImpl(clientOptions) }

    private val cardDisputes: CardDisputeService by lazy { CardDisputeServiceImpl(clientOptions) }

    private val cardRefunds: CardRefundService by lazy { CardRefundServiceImpl(clientOptions) }

    private val checkTransfers: CheckTransferService by lazy { CheckTransferServiceImpl(clientOptions) }

    private val documents: DocumentService by lazy { DocumentServiceImpl(clientOptions) }

    private val digitalWalletTokenRequests: DigitalWalletTokenRequestService by lazy { DigitalWalletTokenRequestServiceImpl(clientOptions) }

    private val checkDeposits: CheckDepositService by lazy { CheckDepositServiceImpl(clientOptions) }

    private val programs: ProgramService by lazy { ProgramServiceImpl(clientOptions) }

    private val inboundWireDrawdownRequests: InboundWireDrawdownRequestService by lazy { InboundWireDrawdownRequestServiceImpl(clientOptions) }

    private val inboundFundsHolds: InboundFundsHoldService by lazy { InboundFundsHoldServiceImpl(clientOptions) }

    private val interestPayments: InterestPaymentService by lazy { InterestPaymentServiceImpl(clientOptions) }

    private val wireTransfers: WireTransferService by lazy { WireTransferServiceImpl(clientOptions) }

    private val cards: CardService by lazy { CardServiceImpl(clientOptions) }

    private val realTimePaymentsTransfers: RealTimePaymentsTransferService by lazy { RealTimePaymentsTransferServiceImpl(clientOptions) }

    private val physicalCards: PhysicalCardService by lazy { PhysicalCardServiceImpl(clientOptions) }

    private val inboundCheckDeposits: InboundCheckDepositService by lazy { InboundCheckDepositServiceImpl(clientOptions) }

    private val inboundInternationalAchTransfers: InboundInternationalAchTransferService by lazy { InboundInternationalAchTransferServiceImpl(clientOptions) }

    override fun accountTransfers(): AccountTransferService = accountTransfers

    override fun accountStatements(): AccountStatementService = accountStatements

    override fun achTransfers(): AchTransferService = achTransfers

    override fun cardDisputes(): CardDisputeService = cardDisputes

    override fun cardRefunds(): CardRefundService = cardRefunds

    override fun checkTransfers(): CheckTransferService = checkTransfers

    override fun documents(): DocumentService = documents

    override fun digitalWalletTokenRequests(): DigitalWalletTokenRequestService = digitalWalletTokenRequests

    override fun checkDeposits(): CheckDepositService = checkDeposits

    override fun programs(): ProgramService = programs

    override fun inboundWireDrawdownRequests(): InboundWireDrawdownRequestService = inboundWireDrawdownRequests

    override fun inboundFundsHolds(): InboundFundsHoldService = inboundFundsHolds

    override fun interestPayments(): InterestPaymentService = interestPayments

    override fun wireTransfers(): WireTransferService = wireTransfers

    override fun cards(): CardService = cards

    override fun realTimePaymentsTransfers(): RealTimePaymentsTransferService = realTimePaymentsTransfers

    override fun physicalCards(): PhysicalCardService = physicalCards

    override fun inboundCheckDeposits(): InboundCheckDepositService = inboundCheckDeposits

    override fun inboundInternationalAchTransfers(): InboundInternationalAchTransferService = inboundInternationalAchTransfers

    private val cardAuthorizationExpirationsHandler: Handler<CardPayment> =
    jsonHandler<CardPayment>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Simulates expiring a card authorization immediately. */
    override fun cardAuthorizationExpirations(params: SimulationCardAuthorizationExpirationsParams, requestOptions: RequestOptions): CardPayment {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("simulations", "card_authorization_expirations")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              cardAuthorizationExpirationsHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val cardFuelConfirmationsHandler: Handler<CardPayment> =
    jsonHandler<CardPayment>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Simulates the fuel confirmation of an authorization by a card acquirer. This
     * happens asynchronously right after a fuel pump transaction is completed. A fuel
     * confirmation can only happen once per authorization.
     */
    override fun cardFuelConfirmations(params: SimulationCardFuelConfirmationsParams, requestOptions: RequestOptions): CardPayment {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("simulations", "card_fuel_confirmations")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              cardFuelConfirmationsHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val cardIncrementsHandler: Handler<CardPayment> =
    jsonHandler<CardPayment>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Simulates the increment of an authorization by a card acquirer. An authorization
     * can be incremented multiple times.
     */
    override fun cardIncrements(params: SimulationCardIncrementsParams, requestOptions: RequestOptions): CardPayment {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("simulations", "card_increments")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              cardIncrementsHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val cardReversalsHandler: Handler<CardPayment> =
    jsonHandler<CardPayment>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Simulates the reversal of an authorization by a card acquirer. An authorization
     * can be partially reversed multiple times, up until the total authorized amount.
     * Marks the pending transaction as complete if the authorization is fully
     * reversed.
     */
    override fun cardReversals(params: SimulationCardReversalsParams, requestOptions: RequestOptions): CardPayment {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("simulations", "card_reversals")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              cardReversalsHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
