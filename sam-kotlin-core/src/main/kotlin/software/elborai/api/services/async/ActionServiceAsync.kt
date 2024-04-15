// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.ActionRetrieveParams
import software.elborai.api.models.ActionUpdateParams

interface ActionServiceAsync {

    suspend fun retrieve(
        params: ActionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    suspend fun update(
        params: ActionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent
}
