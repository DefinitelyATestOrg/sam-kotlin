// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.InboundMailItem
import software.elborai.api.models.InboundMailItemListPage
import software.elborai.api.models.InboundMailItemListParams
import software.elborai.api.models.InboundMailItemRetrieveParams

interface InboundMailItemService {

    /** Retrieve an Inbound Mail Item */
    fun retrieve(
        params: InboundMailItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundMailItem

    /** List Inbound Mail Items */
    fun list(
        params: InboundMailItemListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): InboundMailItemListPage
}
