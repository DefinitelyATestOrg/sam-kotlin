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
import software.elborai.api.models.CheckTransfer
import software.elborai.api.models.CheckTransferApproveParams
import software.elborai.api.models.CheckTransferCancelParams
import software.elborai.api.models.CheckTransferCreateParams
import software.elborai.api.models.CheckTransferListPage
import software.elborai.api.models.CheckTransferListParams
import software.elborai.api.models.CheckTransferRetrieveParams
import software.elborai.api.models.CheckTransferStopPaymentParams
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

interface CheckTransferService {

    /** Create a Check Transfer */
    fun create(params: CheckTransferCreateParams, requestOptions: RequestOptions = RequestOptions.none()): CheckTransfer

    /** Retrieve a Check Transfer */
    fun retrieve(params: CheckTransferRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): CheckTransfer

    /** List Check Transfers */
    fun list(params: CheckTransferListParams, requestOptions: RequestOptions = RequestOptions.none()): CheckTransferListPage

    /** Approve a Check Transfer */
    fun approve(params: CheckTransferApproveParams, requestOptions: RequestOptions = RequestOptions.none()): CheckTransfer

    /** Cancel a pending Check Transfer */
    fun cancel(params: CheckTransferCancelParams, requestOptions: RequestOptions = RequestOptions.none()): CheckTransfer

    /** Request a stop payment on a Check Transfer */
    fun stopPayment(params: CheckTransferStopPaymentParams, requestOptions: RequestOptions = RequestOptions.none()): CheckTransfer
}
