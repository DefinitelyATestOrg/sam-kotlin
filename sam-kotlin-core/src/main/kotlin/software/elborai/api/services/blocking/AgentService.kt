// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.AgentDeleteParams
import software.elborai.api.models.AgentRetrieveParams
import software.elborai.api.models.AgentUpdateParams
import software.elborai.api.services.blocking.agents.ConfigService
import software.elborai.api.services.blocking.agents.HiddenTagService

interface AgentService {

    fun hiddenTags(): HiddenTagService

    fun configs(): ConfigService

    fun retrieve(
        params: AgentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    fun update(
        params: AgentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    fun delete(params: AgentDeleteParams, requestOptions: RequestOptions = RequestOptions.none())
}
