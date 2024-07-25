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
import software.elborai.api.models.Account
import software.elborai.api.models.AccountBalanceParams
import software.elborai.api.models.AccountCloseParams
import software.elborai.api.models.AccountCreateParams
import software.elborai.api.models.AccountListPage
import software.elborai.api.models.AccountListParams
import software.elborai.api.models.AccountRetrieveParams
import software.elborai.api.models.AccountUpdateParams
import software.elborai.api.models.BalanceLookup
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

interface AccountService {

    /** Create an Account */
    fun create(params: AccountCreateParams, requestOptions: RequestOptions = RequestOptions.none()): Account

    /** Retrieve an Account */
    fun retrieve(params: AccountRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): Account

    /** Update an Account */
    fun update(params: AccountUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): Account

    /** List Accounts */
    fun list(params: AccountListParams, requestOptions: RequestOptions = RequestOptions.none()): AccountListPage

    /** Retrieve an Account Balance */
    fun balance(params: AccountBalanceParams, requestOptions: RequestOptions = RequestOptions.none()): BalanceLookup

    /** Close an Account */
    fun close(params: AccountCloseParams, requestOptions: RequestOptions = RequestOptions.none()): Account
}
