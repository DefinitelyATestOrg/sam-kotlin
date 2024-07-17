// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking.intrafi

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.IntrafiAccountEnrollment
import software.elborai.api.models.IntrafiAccountEnrollmentCreateParams
import software.elborai.api.models.IntrafiAccountEnrollmentListPage
import software.elborai.api.models.IntrafiAccountEnrollmentListParams
import software.elborai.api.models.IntrafiAccountEnrollmentRetrieveParams
import software.elborai.api.models.IntrafiAccountEnrollmentUnenrollParams

interface AccountEnrollmentService {

    /** Enroll an account in the IntraFi deposit sweep network. */
    fun create(
        params: IntrafiAccountEnrollmentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): IntrafiAccountEnrollment

    /** Get an IntraFi Account Enrollment */
    fun retrieve(
        params: IntrafiAccountEnrollmentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): IntrafiAccountEnrollment

    /** List IntraFi Account Enrollments */
    fun list(
        params: IntrafiAccountEnrollmentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): IntrafiAccountEnrollmentListPage

    /** Unenroll an account from IntraFi. */
    fun unenroll(
        params: IntrafiAccountEnrollmentUnenrollParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): IntrafiAccountEnrollment
}
