// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.ProofOfAuthorizationRequest
import software.elborai.api.models.ProofOfAuthorizationRequestListPageAsync
import software.elborai.api.models.ProofOfAuthorizationRequestListParams
import software.elborai.api.models.ProofOfAuthorizationRequestRetrieveParams

interface ProofOfAuthorizationRequestServiceAsync {

    /** Retrieve a Proof of Authorization Request */
    suspend fun retrieve(
        params: ProofOfAuthorizationRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ProofOfAuthorizationRequest

    /** List Proof of Authorization Requests */
    suspend fun list(
        params: ProofOfAuthorizationRequestListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ProofOfAuthorizationRequestListPageAsync
}
