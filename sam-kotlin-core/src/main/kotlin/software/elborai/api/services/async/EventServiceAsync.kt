// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Event
import software.elborai.api.models.EventListPageAsync
import software.elborai.api.models.EventListParams
import software.elborai.api.models.EventRetrieveParams

interface EventServiceAsync {

    /** Retrieve an Event */
    suspend fun retrieve(
        params: EventRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Event

    /** List Events */
    suspend fun list(
        params: EventListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EventListPageAsync
}
