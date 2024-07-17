// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.CardPayment
import software.elborai.api.models.SimulationCardAuthorizationExpirationsParams
import software.elborai.api.models.SimulationCardFuelConfirmationsParams
import software.elborai.api.models.SimulationCardIncrementsParams
import software.elborai.api.models.SimulationCardReversalsParams
import software.elborai.api.services.async.simulations.AccountStatementServiceAsync
import software.elborai.api.services.async.simulations.AccountTransferServiceAsync
import software.elborai.api.services.async.simulations.AchTransferServiceAsync
import software.elborai.api.services.async.simulations.CardDisputeServiceAsync
import software.elborai.api.services.async.simulations.CardRefundServiceAsync
import software.elborai.api.services.async.simulations.CardServiceAsync
import software.elborai.api.services.async.simulations.CheckDepositServiceAsync
import software.elborai.api.services.async.simulations.CheckTransferServiceAsync
import software.elborai.api.services.async.simulations.DigitalWalletTokenRequestServiceAsync
import software.elborai.api.services.async.simulations.DocumentServiceAsync
import software.elborai.api.services.async.simulations.InboundCheckDepositServiceAsync
import software.elborai.api.services.async.simulations.InboundFundsHoldServiceAsync
import software.elborai.api.services.async.simulations.InboundInternationalAchTransferServiceAsync
import software.elborai.api.services.async.simulations.InboundWireDrawdownRequestServiceAsync
import software.elborai.api.services.async.simulations.InterestPaymentServiceAsync
import software.elborai.api.services.async.simulations.PhysicalCardServiceAsync
import software.elborai.api.services.async.simulations.ProgramServiceAsync
import software.elborai.api.services.async.simulations.RealTimePaymentsTransferServiceAsync
import software.elborai.api.services.async.simulations.WireTransferServiceAsync

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
    suspend fun cardAuthorizationExpirations(
        params: SimulationCardAuthorizationExpirationsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPayment

    /**
     * Simulates the fuel confirmation of an authorization by a card acquirer. This happens
     * asynchronously right after a fuel pump transaction is completed. A fuel confirmation can only
     * happen once per authorization.
     */
    suspend fun cardFuelConfirmations(
        params: SimulationCardFuelConfirmationsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPayment

    /**
     * Simulates the increment of an authorization by a card acquirer. An authorization can be
     * incremented multiple times.
     */
    suspend fun cardIncrements(
        params: SimulationCardIncrementsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPayment

    /**
     * Simulates the reversal of an authorization by a card acquirer. An authorization can be
     * partially reversed multiple times, up until the total authorized amount. Marks the pending
     * transaction as complete if the authorization is fully reversed.
     */
    suspend fun cardReversals(
        params: SimulationCardReversalsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPayment
}
