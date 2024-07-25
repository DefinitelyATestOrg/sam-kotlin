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
import software.elborai.api.models.PhysicalCardProfile
import software.elborai.api.models.PhysicalCardProfileArchiveParams
import software.elborai.api.models.PhysicalCardProfileCloneParams
import software.elborai.api.models.PhysicalCardProfileCreateParams
import software.elborai.api.models.PhysicalCardProfileListPageAsync
import software.elborai.api.models.PhysicalCardProfileListParams
import software.elborai.api.models.PhysicalCardProfileRetrieveParams
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

interface PhysicalCardProfileServiceAsync {

    /** Create a Physical Card Profile */
    suspend fun create(params: PhysicalCardProfileCreateParams, requestOptions: RequestOptions = RequestOptions.none()): PhysicalCardProfile

    /** Retrieve a Card Profile */
    suspend fun retrieve(params: PhysicalCardProfileRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): PhysicalCardProfile

    /** List Physical Card Profiles */
    suspend fun list(params: PhysicalCardProfileListParams, requestOptions: RequestOptions = RequestOptions.none()): PhysicalCardProfileListPageAsync

    /** Archive a Physical Card Profile */
    suspend fun archive(params: PhysicalCardProfileArchiveParams, requestOptions: RequestOptions = RequestOptions.none()): PhysicalCardProfile

    /** Clone a Physical Card Profile */
    suspend fun clone(params: PhysicalCardProfileCloneParams, requestOptions: RequestOptions = RequestOptions.none()): PhysicalCardProfile
}
