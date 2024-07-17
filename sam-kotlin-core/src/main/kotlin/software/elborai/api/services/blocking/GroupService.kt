// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Group
import software.elborai.api.models.GroupRetrieveDetailsParams

interface GroupService {

    /** Returns details for the currently authenticated Group. */
    fun retrieveDetails(
        params: GroupRetrieveDetailsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Group
}
