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
import software.elborai.api.models.ExternalAccount
import software.elborai.api.models.ExternalAccountCreateParams
import software.elborai.api.models.ExternalAccountListPage
import software.elborai.api.models.ExternalAccountListParams
import software.elborai.api.models.ExternalAccountRetrieveParams
import software.elborai.api.models.ExternalAccountUpdateParams
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

interface ExternalAccountService {

    /** Create an External Account */
    fun create(params: ExternalAccountCreateParams, requestOptions: RequestOptions = RequestOptions.none()): ExternalAccount

    /** Retrieve an External Account */
    fun retrieve(params: ExternalAccountRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): ExternalAccount

    /** Update an External Account */
    fun update(params: ExternalAccountUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): ExternalAccount

    /** List External Accounts */
    fun list(params: ExternalAccountListParams, requestOptions: RequestOptions = RequestOptions.none()): ExternalAccountListPage
}
