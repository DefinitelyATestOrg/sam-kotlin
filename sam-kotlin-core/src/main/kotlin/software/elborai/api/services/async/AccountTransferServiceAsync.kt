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
import software.elborai.api.models.AccountTransfer
import software.elborai.api.models.AccountTransferApproveParams
import software.elborai.api.models.AccountTransferCancelParams
import software.elborai.api.models.AccountTransferCreateParams
import software.elborai.api.models.AccountTransferListPageAsync
import software.elborai.api.models.AccountTransferListParams
import software.elborai.api.models.AccountTransferRetrieveParams
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

interface AccountTransferServiceAsync {

    /** Create an Account Transfer */
    suspend fun create(params: AccountTransferCreateParams, requestOptions: RequestOptions = RequestOptions.none()): AccountTransfer

    /** Retrieve an Account Transfer */
    suspend fun retrieve(params: AccountTransferRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): AccountTransfer

    /** List Account Transfers */
    suspend fun list(params: AccountTransferListParams, requestOptions: RequestOptions = RequestOptions.none()): AccountTransferListPageAsync

    /** Approve an Account Transfer */
    suspend fun approve(params: AccountTransferApproveParams, requestOptions: RequestOptions = RequestOptions.none()): AccountTransfer

    /** Cancel an Account Transfer */
    suspend fun cancel(params: AccountTransferCancelParams, requestOptions: RequestOptions = RequestOptions.none()): AccountTransfer
}
