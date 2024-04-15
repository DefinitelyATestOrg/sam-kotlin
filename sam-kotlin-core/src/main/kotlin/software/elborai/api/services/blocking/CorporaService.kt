// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.CorporaDeleteParams
import software.elborai.api.models.CorporaRetrieveParams
import software.elborai.api.models.CorporaUpdateParams

interface CorporaService {

    fun retrieve(
        params: CorporaRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    fun update(
        params: CorporaUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    fun delete(params: CorporaDeleteParams, requestOptions: RequestOptions = RequestOptions.none())
}
