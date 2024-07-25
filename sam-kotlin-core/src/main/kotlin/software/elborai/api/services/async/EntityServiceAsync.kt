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
import software.elborai.api.models.Entity
import software.elborai.api.models.EntityArchiveParams
import software.elborai.api.models.EntityConfirmParams
import software.elborai.api.models.EntityCreateParams
import software.elborai.api.models.EntityListPageAsync
import software.elborai.api.models.EntityListParams
import software.elborai.api.models.EntityRetrieveParams
import software.elborai.api.models.EntityUpdateAddressParams
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
import software.elborai.api.services.async.entities.BeneficialOwnerServiceAsync
import software.elborai.api.services.async.entities.BeneficialOwnerServiceAsyncImpl
import software.elborai.api.services.async.entities.SupplementalDocumentServiceAsync
import software.elborai.api.services.async.entities.SupplementalDocumentServiceAsyncImpl
import software.elborai.api.services.async.entities.IndustryCodeServiceAsync
import software.elborai.api.services.async.entities.IndustryCodeServiceAsyncImpl

interface EntityServiceAsync {

    fun beneficialOwners(): BeneficialOwnerServiceAsync

    fun supplementalDocuments(): SupplementalDocumentServiceAsync

    fun industryCode(): IndustryCodeServiceAsync

    /** Create an Entity */
    suspend fun create(params: EntityCreateParams, requestOptions: RequestOptions = RequestOptions.none()): Entity

    /** Retrieve an Entity */
    suspend fun retrieve(params: EntityRetrieveParams, requestOptions: RequestOptions = RequestOptions.none()): Entity

    /** List Entities */
    suspend fun list(params: EntityListParams, requestOptions: RequestOptions = RequestOptions.none()): EntityListPageAsync

    /** Archive an Entity */
    suspend fun archive(params: EntityArchiveParams, requestOptions: RequestOptions = RequestOptions.none()): Entity

    /**
     * Depending on your program, you may be required to re-confirm an Entity's details
     * on a recurring basis. After making any required updates, call this endpoint to
     * record that your user confirmed their details.
     */
    suspend fun confirm(params: EntityConfirmParams, requestOptions: RequestOptions = RequestOptions.none()): Entity

    /** Update a Natural Person or Corporation's address */
    suspend fun updateAddress(params: EntityUpdateAddressParams, requestOptions: RequestOptions = RequestOptions.none()): Entity
}
