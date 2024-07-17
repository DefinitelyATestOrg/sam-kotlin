// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Export
import software.elborai.api.models.ExportCreateParams
import software.elborai.api.models.ExportListPage
import software.elborai.api.models.ExportListParams
import software.elborai.api.models.ExportRetrieveParams

interface ExportService {

    /** Create an Export */
    fun create(
        params: ExportCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Export

    /** Retrieve an Export */
    fun retrieve(
        params: ExportRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Export

    /** List Exports */
    fun list(
        params: ExportListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ExportListPage
}
