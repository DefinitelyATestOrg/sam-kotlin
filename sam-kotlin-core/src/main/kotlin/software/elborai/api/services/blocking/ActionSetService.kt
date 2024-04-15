// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.ActionSetDeleteParams
import software.elborai.api.models.ActionSetRetrieveParams
import software.elborai.api.models.ActionSetUpdateParams

interface ActionSetService {

    fun retrieve(
        params: ActionSetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    fun update(
        params: ActionSetUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    fun delete(
        params: ActionSetDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    )
}
