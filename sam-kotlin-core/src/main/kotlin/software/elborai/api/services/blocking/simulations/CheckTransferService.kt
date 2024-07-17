// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking.simulations

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.CheckTransfer
import software.elborai.api.models.SimulationCheckTransferMailParams

interface CheckTransferService {

    /**
     * Simulates the mailing of a [Check Transfer](#check-transfers), which happens once per weekday
     * in production but can be sped up in sandbox. This transfer must first have a `status` of
     * `pending_approval` or `pending_submission`.
     */
    fun mail(
        params: SimulationCheckTransferMailParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CheckTransfer
}
