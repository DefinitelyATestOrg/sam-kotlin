// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

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

interface SimulationService {

    fun accountTransfers(): AccountTransferService

    fun accountStatements(): AccountStatementService

    fun achTransfers(): AchTransferService

    fun cardDisputes(): CardDisputeService

    fun cardRefunds(): CardRefundService

    fun checkTransfers(): CheckTransferService

    fun documents(): DocumentService

    fun digitalWalletTokenRequests(): DigitalWalletTokenRequestService

    fun checkDeposits(): CheckDepositService

    fun programs(): ProgramService

    fun inboundWireDrawdownRequests(): InboundWireDrawdownRequestService

    fun inboundFundsHolds(): InboundFundsHoldService

    fun interestPayments(): InterestPaymentService

    fun wireTransfers(): WireTransferService

    fun cards(): CardService

    fun realTimePaymentsTransfers(): RealTimePaymentsTransferService

    fun physicalCards(): PhysicalCardService

    fun inboundCheckDeposits(): InboundCheckDepositService

    fun inboundInternationalAchTransfers(): InboundInternationalAchTransferService

    /** Simulates expiring a card authorization immediately. */
    fun cardAuthorizationExpirations(params: SimulationCardAuthorizationExpirationsParams, requestOptions: RequestOptions = RequestOptions.none()): CardPayment

    /**
     * Simulates the fuel confirmation of an authorization by a card acquirer. This
     * happens asynchronously right after a fuel pump transaction is completed. A fuel
     * confirmation can only happen once per authorization.
     */
    fun cardFuelConfirmations(params: SimulationCardFuelConfirmationsParams, requestOptions: RequestOptions = RequestOptions.none()): CardPayment

    /**
     * Simulates the increment of an authorization by a card acquirer. An authorization
     * can be incremented multiple times.
     */
    fun cardIncrements(params: SimulationCardIncrementsParams, requestOptions: RequestOptions = RequestOptions.none()): CardPayment

    /**
     * Simulates the reversal of an authorization by a card acquirer. An authorization
     * can be partially reversed multiple times, up until the total authorized amount.
     * Marks the pending transaction as complete if the authorization is fully
     * reversed.
     */
    fun cardReversals(params: SimulationCardReversalsParams, requestOptions: RequestOptions = RequestOptions.none()): CardPayment
}
