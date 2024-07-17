// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.InboundWireDrawdownRequest
import software.elborai.api.models.InboundWireDrawdownRequestListPage
import software.elborai.api.models.InboundWireDrawdownRequestListParams
import software.elborai.api.models.InboundWireDrawdownRequestRetrieveParams

interface InboundWireDrawdownRequestService {

    /** Retrieve an Inbound Wire Drawdown Request */
    fun retrieve(
        params: InboundWireDrawdownRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundWireDrawdownRequest

    /** List Inbound Wire Drawdown Requests */
    fun list(
        params: InboundWireDrawdownRequestListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundWireDrawdownRequestListPage
}
