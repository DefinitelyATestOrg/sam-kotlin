// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.CardPayment
import software.elborai.api.models.SimulationCardAuthorizationExpirationsParams
import software.elborai.api.models.SimulationCardFuelConfirmationsParams
import software.elborai.api.models.SimulationCardIncrementsParams
import software.elborai.api.models.SimulationCardReversalsParams
import software.elborai.api.services.blocking.simulations.AccountStatementService
import software.elborai.api.services.blocking.simulations.AccountTransferService
import software.elborai.api.services.blocking.simulations.AchTransferService
import software.elborai.api.services.blocking.simulations.CardDisputeService
import software.elborai.api.services.blocking.simulations.CardRefundService
import software.elborai.api.services.blocking.simulations.CardService
import software.elborai.api.services.blocking.simulations.CheckDepositService
import software.elborai.api.services.blocking.simulations.CheckTransferService
import software.elborai.api.services.blocking.simulations.DigitalWalletTokenRequestService
import software.elborai.api.services.blocking.simulations.DocumentService
import software.elborai.api.services.blocking.simulations.InboundCheckDepositService
import software.elborai.api.services.blocking.simulations.InboundFundsHoldService
import software.elborai.api.services.blocking.simulations.InboundInternationalAchTransferService
import software.elborai.api.services.blocking.simulations.InboundWireDrawdownRequestService
import software.elborai.api.services.blocking.simulations.InterestPaymentService
import software.elborai.api.services.blocking.simulations.PhysicalCardService
import software.elborai.api.services.blocking.simulations.ProgramService
import software.elborai.api.services.blocking.simulations.RealTimePaymentsTransferService
import software.elborai.api.services.blocking.simulations.WireTransferService

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
    fun cardAuthorizationExpirations(
        params: SimulationCardAuthorizationExpirationsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPayment

    /**
     * Simulates the fuel confirmation of an authorization by a card acquirer. This happens
     * asynchronously right after a fuel pump transaction is completed. A fuel confirmation can only
     * happen once per authorization.
     */
    fun cardFuelConfirmations(
        params: SimulationCardFuelConfirmationsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPayment

    /**
     * Simulates the increment of an authorization by a card acquirer. An authorization can be
     * incremented multiple times.
     */
    fun cardIncrements(
        params: SimulationCardIncrementsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPayment

    /**
     * Simulates the reversal of an authorization by a card acquirer. An authorization can be
     * partially reversed multiple times, up until the total authorized amount. Marks the pending
     * transaction as complete if the authorization is fully reversed.
     */
    fun cardReversals(
        params: SimulationCardReversalsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardPayment
}
