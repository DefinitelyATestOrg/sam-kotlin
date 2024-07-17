// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Program
import software.elborai.api.models.ProgramListPage
import software.elborai.api.models.ProgramListParams
import software.elborai.api.models.ProgramRetrieveParams

interface ProgramService {

    /** Retrieve a Program */
    fun retrieve(
        params: ProgramRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Program

    /** List Programs */
    fun list(
        params: ProgramListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ProgramListPage
}
