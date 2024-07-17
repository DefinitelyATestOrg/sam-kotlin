// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Document
import software.elborai.api.models.DocumentListPageAsync
import software.elborai.api.models.DocumentListParams
import software.elborai.api.models.DocumentRetrieveParams

interface DocumentServiceAsync {

    /** Retrieve a Document */
    suspend fun retrieve(
        params: DocumentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Document

    /** List Documents */
    suspend fun list(
        params: DocumentListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DocumentListPageAsync
}
