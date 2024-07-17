// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.InboundWireDrawdownRequest
import software.elborai.api.models.InboundWireDrawdownRequestListPageAsync
import software.elborai.api.models.InboundWireDrawdownRequestListParams
import software.elborai.api.models.InboundWireDrawdownRequestRetrieveParams

interface InboundWireDrawdownRequestServiceAsync {

    /** Retrieve an Inbound Wire Drawdown Request */
    suspend fun retrieve(
        params: InboundWireDrawdownRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundWireDrawdownRequest

    /** List Inbound Wire Drawdown Requests */
    suspend fun list(
        params: InboundWireDrawdownRequestListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundWireDrawdownRequestListPageAsync
}
