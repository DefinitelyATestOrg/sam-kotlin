// File generated from our OpenAPI spec by Stainless.

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
import software.elborai.api.services.async.intrafi.AccountEnrollmentServiceAsync
import software.elborai.api.services.async.intrafi.AccountEnrollmentServiceAsyncImpl
import software.elborai.api.services.async.intrafi.BalanceServiceAsync
import software.elborai.api.services.async.intrafi.BalanceServiceAsyncImpl
import software.elborai.api.services.async.intrafi.ExclusionServiceAsync
import software.elborai.api.services.async.intrafi.ExclusionServiceAsyncImpl

class IntrafiServiceAsyncImpl constructor(private val clientOptions: ClientOptions, ) : IntrafiServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val accountEnrollments: AccountEnrollmentServiceAsync by lazy { AccountEnrollmentServiceAsyncImpl(clientOptions) }

    private val balances: BalanceServiceAsync by lazy { BalanceServiceAsyncImpl(clientOptions) }

    private val exclusions: ExclusionServiceAsync by lazy { ExclusionServiceAsyncImpl(clientOptions) }

    override fun accountEnrollments(): AccountEnrollmentServiceAsync = accountEnrollments

    override fun balances(): BalanceServiceAsync = balances

    override fun exclusions(): ExclusionServiceAsync = exclusions
}
