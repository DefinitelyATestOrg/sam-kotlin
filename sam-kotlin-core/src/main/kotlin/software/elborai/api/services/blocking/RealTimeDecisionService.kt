// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.RealTimeDecision
import software.elborai.api.models.RealTimeDecisionActionParams
import software.elborai.api.models.RealTimeDecisionRetrieveParams

interface RealTimeDecisionService {

    /** Retrieve a Real-Time Decision */
    fun retrieve(
        params: RealTimeDecisionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): RealTimeDecision

    /** Action a Real-Time Decision */
    fun action(
        params: RealTimeDecisionActionParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): RealTimeDecision
}
