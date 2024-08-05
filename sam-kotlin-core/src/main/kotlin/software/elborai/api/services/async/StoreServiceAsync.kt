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
import software.elborai.api.errors.SamInvalidDataException
import software.elborai.api.models.Order
import software.elborai.api.models.StoreCreateOrderParams
import software.elborai.api.models.StoreDeleteParams
import software.elborai.api.models.StoreInventoryParams
import software.elborai.api.models.StoreInventoryResponse
import software.elborai.api.models.StoreRetrieveParams
import software.elborai.api.core.ClientOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.core.JsonField
import software.elborai.api.core.JsonValue
import software.elborai.api.core.RequestOptions
import software.elborai.api.errors.SamError
import software.elborai.api.services.emptyHandler
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.multipartFormData
import software.elborai.api.services.stringHandler
import software.elborai.api.services.binaryHandler
import software.elborai.api.services.withErrorHandler
import software.elborai.api.services.async.stores.OrderServiceAsync
import software.elborai.api.services.async.stores.OrderServiceAsyncImpl

interface StoreServiceAsync {

    fun orders(): OrderServiceAsync

    /**
     * For valid response try integer IDs with value <= 5 or > 10. Other values will
     * generate exceptions.
     */
    suspend fun retrieve(params: StoreRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): Order

    /**
     * For valid response try integer IDs with value < 1000. Anything above 1000 or
     * nonintegers will generate API errors
     */
    suspend fun delete(params: StoreDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Place a new order in the store */
    suspend fun createOrder(params: StoreCreateOrderParams, requestOptions: RequestOptions = RequestOptions.none()): Order

    /** Returns a map of status codes to quantities */
    suspend fun inventory(params: StoreInventoryParams, requestOptions: RequestOptions = RequestOptions.none()): StoreInventoryResponse
}
