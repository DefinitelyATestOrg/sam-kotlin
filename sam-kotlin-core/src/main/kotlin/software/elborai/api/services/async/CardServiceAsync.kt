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
import software.elborai.api.models.Card
import software.elborai.api.models.CardCreateParams
import software.elborai.api.models.CardDetails
import software.elborai.api.models.CardListPageAsync
import software.elborai.api.models.CardListParams
import software.elborai.api.models.CardRetrieveParams
import software.elborai.api.models.CardRetrieveSensitiveDetailsParams
import software.elborai.api.models.CardUpdateParams
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

interface CardServiceAsync {

    /** Create a Card */
    suspend fun create(params: CardCreateParams, requestOptions: RequestOptions = RequestOptions.none()): Card

    /** Retrieve a Card */
    suspend fun retrieve(params: CardRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): Card

    /** Update a Card */
    suspend fun update(params: CardUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): Card

    /** List Cards */
    suspend fun list(params: CardListParams, requestOptions: RequestOptions = RequestOptions.none()): CardListPageAsync

    /** Retrieve sensitive details for a Card */
    suspend fun retrieveSensitiveDetails(params: CardRetrieveSensitiveDetailsParams, requestOptions: RequestOptions = RequestOptions.none()): CardDetails
}
