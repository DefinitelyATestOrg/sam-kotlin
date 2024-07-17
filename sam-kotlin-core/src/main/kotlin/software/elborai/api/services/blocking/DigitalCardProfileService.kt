// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.DigitalCardProfile
import software.elborai.api.models.DigitalCardProfileArchiveParams
import software.elborai.api.models.DigitalCardProfileCloneParams
import software.elborai.api.models.DigitalCardProfileCreateParams
import software.elborai.api.models.DigitalCardProfileListPage
import software.elborai.api.models.DigitalCardProfileListParams
import software.elborai.api.models.DigitalCardProfileRetrieveParams

interface DigitalCardProfileService {

    /** Create a Digital Card Profile */
    fun create(
        params: DigitalCardProfileCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DigitalCardProfile

    /** Retrieve a Digital Card Profile */
    fun retrieve(
        params: DigitalCardProfileRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DigitalCardProfile

    /** List Card Profiles */
    fun list(
        params: DigitalCardProfileListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DigitalCardProfileListPage

    /** Archive a Digital Card Profile */
    fun archive(
        params: DigitalCardProfileArchiveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DigitalCardProfile

    /** Clones a Digital Card Profile */
    fun clone(
        params: DigitalCardProfileCloneParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DigitalCardProfile
}
