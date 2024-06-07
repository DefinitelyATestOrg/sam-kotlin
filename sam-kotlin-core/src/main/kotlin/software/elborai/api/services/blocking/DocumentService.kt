// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.DocumentDeleteParams
import software.elborai.api.models.DocumentRetrieveParams
import software.elborai.api.models.DocumentUpdateParams

interface DocumentService {

    fun retrieve(
        params: DocumentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    fun update(
        params: DocumentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    fun delete(params: DocumentDeleteParams, requestOptions: RequestOptions = RequestOptions.none())
}
