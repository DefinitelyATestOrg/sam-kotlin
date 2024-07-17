// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async.entities

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Entity
import software.elborai.api.models.EntityBeneficialOwnerArchiveParams
import software.elborai.api.models.EntityBeneficialOwnerCreateParams
import software.elborai.api.models.EntityBeneficialOwnerUpdateAddressParams

interface BeneficialOwnerServiceAsync {

    /** Create a beneficial owner for a corporate Entity */
    suspend fun create(
        params: EntityBeneficialOwnerCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Entity

    /** Archive a beneficial owner for a corporate Entity */
    suspend fun archive(
        params: EntityBeneficialOwnerArchiveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Entity

    /** Update the address for a beneficial owner belonging to a corporate Entity */
    suspend fun updateAddress(
        params: EntityBeneficialOwnerUpdateAddressParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Entity
}
