// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking.simulations

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.AchTransfer
import software.elborai.api.models.InboundAchTransfer
import software.elborai.api.models.SimulationAchTransferCreateInboundParams
import software.elborai.api.models.SimulationAchTransferNotificationOfChangeParams
import software.elborai.api.models.SimulationAchTransferReturnParams
import software.elborai.api.models.SimulationAchTransferSubmitParams

interface AchTransferService {

    /**
     * Simulates an inbound ACH transfer to your account. This imitates initiating a transfer to an
     * Increase account from a different financial institution. The transfer may be either a credit
     * or a debit depending on if the `amount` is positive or negative. The result of calling this
     * API will contain the created transfer. You can pass a `resolve_at` parameter to allow for a
     * window to
     * [action on the Inbound ACH Transfer](https://increase.com/documentation/receiving-ach-transfers).
     * Alternatively, if you don't pass the `resolve_at` parameter the result will contain either a
     * [Transaction](#transactions) or a [Declined Transaction](#declined-transactions) depending on
     * whether or not the transfer is allowed.
     */
    fun createInbound(
        params: SimulationAchTransferCreateInboundParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundAchTransfer

    /** Simulates receiving a Notification of Change for an [ACH Transfer](#ach-transfers). */
    fun notificationOfChange(
        params: SimulationAchTransferNotificationOfChangeParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AchTransfer

    /**
     * Simulates the return of an [ACH Transfer](#ach-transfers) by the Federal Reserve due to an
     * error condition. This will also create a Transaction to account for the returned funds. This
     * transfer must first have a `status` of `submitted`.
     */
    fun return_(
        params: SimulationAchTransferReturnParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AchTransfer

    /**
     * Simulates the submission of an [ACH Transfer](#ach-transfers) to the Federal Reserve. This
     * transfer must first have a `status` of `pending_approval` or `pending_submission`. In
     * production, Increase submits ACH Transfers to the Federal Reserve three times per day on
     * weekdays. Since sandbox ACH Transfers are not submitted to the Federal Reserve, this endpoint
     * allows you to skip that delay and transition the ACH Transfer to a status of `submitted`.
     */
    fun submit(
        params: SimulationAchTransferSubmitParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AchTransfer
}
