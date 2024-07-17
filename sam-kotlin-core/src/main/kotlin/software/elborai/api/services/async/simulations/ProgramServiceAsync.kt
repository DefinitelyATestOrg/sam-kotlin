// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async.simulations

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Program
import software.elborai.api.models.SimulationProgramCreateParams

interface ProgramServiceAsync {

    /**
     * Simulates a program being created in your group. By default, your group has one program
     * called Commercial Banking. Note that when your group operates more than one program,
     * `program_id` is a required field when creating accounts.
     */
    suspend fun create(
        params: SimulationProgramCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Program
}
