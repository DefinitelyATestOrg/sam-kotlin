// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.PhysicalCardProfile
import software.elborai.api.models.PhysicalCardProfileArchiveParams
import software.elborai.api.models.PhysicalCardProfileCloneParams
import software.elborai.api.models.PhysicalCardProfileCreateParams
import software.elborai.api.models.PhysicalCardProfileListPage
import software.elborai.api.models.PhysicalCardProfileListParams
import software.elborai.api.models.PhysicalCardProfileRetrieveParams

interface PhysicalCardProfileService {

    /** Create a Physical Card Profile */
    fun create(
        params: PhysicalCardProfileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCardProfile

    /** Retrieve a Card Profile */
    fun retrieve(
        params: PhysicalCardProfileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCardProfile

    /** List Physical Card Profiles */
    fun list(
        params: PhysicalCardProfileListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCardProfileListPage

    /** Archive a Physical Card Profile */
    fun archive(
        params: PhysicalCardProfileArchiveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCardProfile

    /** Clone a Physical Card Profile */
    fun clone(
        params: PhysicalCardProfileCloneParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): PhysicalCardProfile
}
