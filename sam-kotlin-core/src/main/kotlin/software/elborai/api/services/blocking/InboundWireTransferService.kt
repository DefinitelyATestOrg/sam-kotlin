// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.InboundWireTransfer
import software.elborai.api.models.InboundWireTransferListPage
import software.elborai.api.models.InboundWireTransferListParams
import software.elborai.api.models.InboundWireTransferRetrieveParams

interface InboundWireTransferService {

    /** Retrieve an Inbound Wire Transfer */
    fun retrieve(
        params: InboundWireTransferRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundWireTransfer

    /** List Inbound Wire Transfers */
    fun list(
        params: InboundWireTransferListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundWireTransferListPage
}
