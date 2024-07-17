// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.ProofOfAuthorizationRequest
import software.elborai.api.models.ProofOfAuthorizationRequestListPage
import software.elborai.api.models.ProofOfAuthorizationRequestListParams
import software.elborai.api.models.ProofOfAuthorizationRequestRetrieveParams

interface ProofOfAuthorizationRequestService {

    /** Retrieve a Proof of Authorization Request */
    fun retrieve(
        params: ProofOfAuthorizationRequestRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ProofOfAuthorizationRequest

    /** List Proof of Authorization Requests */
    fun list(
        params: ProofOfAuthorizationRequestListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ProofOfAuthorizationRequestListPage
}
