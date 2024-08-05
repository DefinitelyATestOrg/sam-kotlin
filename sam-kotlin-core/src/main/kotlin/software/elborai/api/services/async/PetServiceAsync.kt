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
import software.elborai.api.models.ApiResponse
import software.elborai.api.models.Pet
import software.elborai.api.models.PetCreateParams
import software.elborai.api.models.PetDeleteParams
import software.elborai.api.models.PetFindByStatusParams
import software.elborai.api.models.PetFindByTagsParams
import software.elborai.api.models.PetRetrieveParams
import software.elborai.api.models.PetUpdateParams
import software.elborai.api.models.PetUploadImageParams
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

interface PetServiceAsync {

    /** Updates a pet in the store with form data */
    suspend fun create(params: PetCreateParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Returns a single pet */
    suspend fun retrieve(params: PetRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): Pet

    /** Update an existing pet by Id */
    suspend fun update(params: PetUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): Pet

    /** Deletes a pet */
    suspend fun delete(params: PetDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Multiple status values can be provided with comma separated strings */
    suspend fun findByStatus(params: PetFindByStatusParams, requestOptions: RequestOptions = RequestOptions.none()): List<Pet>

    /**
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3
     * for testing.
     */
    suspend fun findByTags(params: PetFindByTagsParams, requestOptions: RequestOptions = RequestOptions.none()): List<Pet>

    /** uploads an image */
    suspend fun uploadImage(params: PetUploadImageParams, requestOptions: RequestOptions = RequestOptions.none()): ApiResponse
}
