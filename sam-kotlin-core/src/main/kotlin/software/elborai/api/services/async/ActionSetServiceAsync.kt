// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.ActionSetDeleteParams
import software.elborai.api.models.ActionSetRetrieveParams
import software.elborai.api.models.ActionSetUpdateParams

interface ActionSetServiceAsync {

    suspend fun retrieve(
        params: ActionSetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    suspend fun update(
        params: ActionSetUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    suspend fun delete(
        params: ActionSetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )
}
