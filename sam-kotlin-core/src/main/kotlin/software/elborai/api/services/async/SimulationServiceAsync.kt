// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

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
import software.elborai.api.services.async.simulations.AccountTransferServiceAsync
import software.elborai.api.services.async.simulations.AccountTransferServiceAsyncImpl
import software.elborai.api.services.async.simulations.AccountStatementServiceAsync
import software.elborai.api.services.async.simulations.AccountStatementServiceAsyncImpl
import software.elborai.api.services.async.simulations.AchTransferServiceAsync
import software.elborai.api.services.async.simulations.AchTransferServiceAsyncImpl
import software.elborai.api.services.async.simulations.CardDisputeServiceAsync
import software.elborai.api.services.async.simulations.CardDisputeServiceAsyncImpl
import software.elborai.api.services.async.simulations.CardRefundServiceAsync
import software.elborai.api.services.async.simulations.CardRefundServiceAsyncImpl
import software.elborai.api.services.async.simulations.CheckTransferServiceAsync
import software.elborai.api.services.async.simulations.CheckTransferServiceAsyncImpl
import software.elborai.api.services.async.simulations.DocumentServiceAsync
import software.elborai.api.services.async.simulations.DocumentServiceAsyncImpl
import software.elborai.api.services.async.simulations.DigitalWalletTokenRequestServiceAsync
import software.elborai.api.services.async.simulations.DigitalWalletTokenRequestServiceAsyncImpl
import software.elborai.api.services.async.simulations.CheckDepositServiceAsync
import software.elborai.api.services.async.simulations.CheckDepositServiceAsyncImpl
import software.elborai.api.services.async.simulations.ProgramServiceAsync
import software.elborai.api.services.async.simulations.ProgramServiceAsyncImpl
import software.elborai.api.services.async.simulations.InboundWireDrawdownRequestServiceAsync
import software.elborai.api.services.async.simulations.InboundWireDrawdownRequestServiceAsyncImpl
import software.elborai.api.services.async.simulations.InboundFundsHoldServiceAsync
import software.elborai.api.services.async.simulations.InboundFundsHoldServiceAsyncImpl
import software.elborai.api.services.async.simulations.InterestPaymentServiceAsync
import software.elborai.api.services.async.simulations.InterestPaymentServiceAsyncImpl
import software.elborai.api.services.async.simulations.WireTransferServiceAsync
import software.elborai.api.services.async.simulations.WireTransferServiceAsyncImpl
import software.elborai.api.services.async.simulations.CardServiceAsync
import software.elborai.api.services.async.simulations.CardServiceAsyncImpl
import software.elborai.api.services.async.simulations.RealTimePaymentsTransferServiceAsync
import software.elborai.api.services.async.simulations.RealTimePaymentsTransferServiceAsyncImpl
import software.elborai.api.services.async.simulations.PhysicalCardServiceAsync
import software.elborai.api.services.async.simulations.PhysicalCardServiceAsyncImpl
import software.elborai.api.services.async.simulations.InboundCheckDepositServiceAsync
import software.elborai.api.services.async.simulations.InboundCheckDepositServiceAsyncImpl
import software.elborai.api.services.async.simulations.InboundInternationalAchTransferServiceAsync
import software.elborai.api.services.async.simulations.InboundInternationalAchTransferServiceAsyncImpl

interface SimulationServiceAsync {

    fun accountTransfers(): AccountTransferServiceAsync

    fun accountStatements(): AccountStatementServiceAsync

    fun achTransfers(): AchTransferServiceAsync

    fun cardDisputes(): CardDisputeServiceAsync

    fun cardRefunds(): CardRefundServiceAsync

    fun checkTransfers(): CheckTransferServiceAsync

    fun documents(): DocumentServiceAsync

    fun digitalWalletTokenRequests(): DigitalWalletTokenRequestServiceAsync

    fun checkDeposits(): CheckDepositServiceAsync

    fun programs(): ProgramServiceAsync

    fun inboundWireDrawdownRequests(): InboundWireDrawdownRequestServiceAsync

    fun inboundFundsHolds(): InboundFundsHoldServiceAsync

    fun interestPayments(): InterestPaymentServiceAsync

    fun wireTransfers(): WireTransferServiceAsync

    fun cards(): CardServiceAsync

    fun realTimePaymentsTransfers(): RealTimePaymentsTransferServiceAsync

    fun physicalCards(): PhysicalCardServiceAsync

    fun inboundCheckDeposits(): InboundCheckDepositServiceAsync

    fun inboundInternationalAchTransfers(): InboundInternationalAchTransferServiceAsync

    /** Simulates expiring a card authorization immediately. */
    suspend fun cardAuthorizationExpirations(params: SimulationCardAuthorizationExpirationsParams, requestOptions: RequestOptions = RequestOptions.none()): CardPayment

    /**
     * Simulates the fuel confirmation of an authorization by a card acquirer. This
     * happens asynchronously right after a fuel pump transaction is completed. A fuel
     * confirmation can only happen once per authorization.
     */
    suspend fun cardFuelConfirmations(params: SimulationCardFuelConfirmationsParams, requestOptions: RequestOptions = RequestOptions.none()): CardPayment

    /**
     * Simulates the increment of an authorization by a card acquirer. An authorization
     * can be incremented multiple times.
     */
    suspend fun cardIncrements(params: SimulationCardIncrementsParams, requestOptions: RequestOptions = RequestOptions.none()): CardPayment

    /**
     * Simulates the reversal of an authorization by a card acquirer. An authorization
     * can be partially reversed multiple times, up until the total authorized amount.
     * Marks the pending transaction as complete if the authorization is fully
     * reversed.
     */
    suspend fun cardReversals(params: SimulationCardReversalsParams, requestOptions: RequestOptions = RequestOptions.none()): CardPayment
}
