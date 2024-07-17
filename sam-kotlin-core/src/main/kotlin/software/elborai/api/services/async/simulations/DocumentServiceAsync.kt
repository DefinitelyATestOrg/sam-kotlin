// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async.simulations

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Document
import software.elborai.api.models.SimulationDocumentCreateParams

interface DocumentServiceAsync {

    /** Simulates an tax document being created for an account. */
    suspend fun create(
        params: SimulationDocumentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Document
}
