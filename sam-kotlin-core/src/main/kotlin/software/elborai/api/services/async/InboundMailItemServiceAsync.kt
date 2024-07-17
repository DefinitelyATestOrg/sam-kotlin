// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.InboundMailItem
import software.elborai.api.models.InboundMailItemListPageAsync
import software.elborai.api.models.InboundMailItemListParams
import software.elborai.api.models.InboundMailItemRetrieveParams

interface InboundMailItemServiceAsync {

    /** Retrieve an Inbound Mail Item */
    suspend fun retrieve(
        params: InboundMailItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundMailItem

    /** List Inbound Mail Items */
    suspend fun list(
        params: InboundMailItemListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundMailItemListPageAsync
}
