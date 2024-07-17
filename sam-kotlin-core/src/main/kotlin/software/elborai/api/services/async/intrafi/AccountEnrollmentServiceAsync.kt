// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async.intrafi

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.IntrafiAccountEnrollment
import software.elborai.api.models.IntrafiAccountEnrollmentCreateParams
import software.elborai.api.models.IntrafiAccountEnrollmentListPageAsync
import software.elborai.api.models.IntrafiAccountEnrollmentListParams
import software.elborai.api.models.IntrafiAccountEnrollmentRetrieveParams
import software.elborai.api.models.IntrafiAccountEnrollmentUnenrollParams

interface AccountEnrollmentServiceAsync {

    /** Enroll an account in the IntraFi deposit sweep network. */
    suspend fun create(
        params: IntrafiAccountEnrollmentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): IntrafiAccountEnrollment

    /** Get an IntraFi Account Enrollment */
    suspend fun retrieve(
        params: IntrafiAccountEnrollmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): IntrafiAccountEnrollment

    /** List IntraFi Account Enrollments */
    suspend fun list(
        params: IntrafiAccountEnrollmentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): IntrafiAccountEnrollmentListPageAsync

    /** Unenroll an account from IntraFi. */
    suspend fun unenroll(
        params: IntrafiAccountEnrollmentUnenrollParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): IntrafiAccountEnrollment
}
