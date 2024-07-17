// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.RoutingNumberListPageAsync
import software.elborai.api.models.RoutingNumberListParams

interface RoutingNumberServiceAsync {

    /**
     * You can use this API to confirm if a routing number is valid, such as when a user is
     * providing you with bank account details. Since routing numbers uniquely identify a bank, this
     * will always return 0 or 1 entry. In Sandbox, the only valid routing number for this method
     * is 110000000.
     */
    suspend fun list(
        params: RoutingNumberListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): RoutingNumberListPageAsync
}
