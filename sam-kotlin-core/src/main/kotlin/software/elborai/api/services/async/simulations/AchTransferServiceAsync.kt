// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

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
import software.elborai.api.models.AchTransfer
import software.elborai.api.models.InboundAchTransfer
import software.elborai.api.models.SimulationAchTransferCreateInboundParams
import software.elborai.api.models.SimulationAchTransferNotificationOfChangeParams
import software.elborai.api.models.SimulationAchTransferReturnParams
import software.elborai.api.models.SimulationAchTransferSubmitParams
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

interface AchTransferServiceAsync {

    /**
     * Simulates an inbound ACH transfer to your account. This imitates initiating a
     * transfer to an Increase account from a different financial institution. The
     * transfer may be either a credit or a debit depending on if the `amount` is
     * positive or negative. The result of calling this API will contain the created
     * transfer. You can pass a `resolve_at` parameter to allow for a window to
     * [action on the Inbound ACH Transfer](https://increase.com/documentation/receiving-ach-transfers).
     * Alternatively, if you don't pass the `resolve_at` parameter the result will
     * contain either a [Transaction](#transactions) or a
     * [Declined Transaction](#declined-transactions) depending on whether or not the
     * transfer is allowed.
     */
    suspend fun createInbound(params: SimulationAchTransferCreateInboundParams, requestOptions: RequestOptions = RequestOptions.none()): InboundAchTransfer

    /**
     * Simulates receiving a Notification of Change for an
     * [ACH Transfer](#ach-transfers).
     */
    suspend fun notificationOfChange(params: SimulationAchTransferNotificationOfChangeParams, requestOptions: RequestOptions = RequestOptions.none()): AchTransfer

    /**
     * Simulates the return of an [ACH Transfer](#ach-transfers) by the Federal Reserve
     * due to an error condition. This will also create a Transaction to account for
     * the returned funds. This transfer must first have a `status` of `submitted`.
     */
    suspend fun return_(params: SimulationAchTransferReturnParams, requestOptions: RequestOptions = RequestOptions.none()): AchTransfer

    /**
     * Simulates the submission of an [ACH Transfer](#ach-transfers) to the Federal
     * Reserve. This transfer must first have a `status` of `pending_approval` or
     * `pending_submission`. In production, Increase submits ACH Transfers to the
     * Federal Reserve three times per day on weekdays. Since sandbox ACH Transfers are
     * not submitted to the Federal Reserve, this endpoint allows you to skip that
     * delay and transition the ACH Transfer to a status of `submitted`.
     */
    suspend fun submit(params: SimulationAchTransferSubmitParams, requestOptions: RequestOptions = RequestOptions.none()): AchTransfer
}
