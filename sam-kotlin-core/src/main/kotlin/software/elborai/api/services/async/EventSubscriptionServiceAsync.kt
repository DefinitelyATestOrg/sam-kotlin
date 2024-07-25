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
import software.elborai.api.models.EventSubscription
import software.elborai.api.models.EventSubscriptionCreateParams
import software.elborai.api.models.EventSubscriptionListPageAsync
import software.elborai.api.models.EventSubscriptionListParams
import software.elborai.api.models.EventSubscriptionRetrieveParams
import software.elborai.api.models.EventSubscriptionUpdateParams
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

interface EventSubscriptionServiceAsync {

    /** Create an Event Subscription */
    suspend fun create(params: EventSubscriptionCreateParams, requestOptions: RequestOptions = RequestOptions.none()): EventSubscription

    /** Retrieve an Event Subscription */
    suspend fun retrieve(params: EventSubscriptionRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): EventSubscription

    /** Update an Event Subscription */
    suspend fun update(params: EventSubscriptionUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): EventSubscription

    /** List Event Subscriptions */
    suspend fun list(params: EventSubscriptionListParams, requestOptions: RequestOptions = RequestOptions.none()): EventSubscriptionListPageAsync
}
