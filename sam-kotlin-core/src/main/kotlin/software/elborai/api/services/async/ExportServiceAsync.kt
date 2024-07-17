// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Export
import software.elborai.api.models.ExportCreateParams
import software.elborai.api.models.ExportListPageAsync
import software.elborai.api.models.ExportListParams
import software.elborai.api.models.ExportRetrieveParams

interface ExportServiceAsync {

    /** Create an Export */
    suspend fun create(
        params: ExportCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Export

    /** Retrieve an Export */
    suspend fun retrieve(
        params: ExportRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Export

    /** List Exports */
    suspend fun list(
        params: ExportListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ExportListPageAsync
}
