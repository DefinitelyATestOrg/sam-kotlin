// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async.agents.configs

import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.AgentConfigChatRetrieveParams
import software.elborai.api.models.AgentConfigChatUpdateParams

interface ChatServiceAsync {

    suspend fun retrieve(
        params: AgentConfigChatRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    suspend fun update(
        params: AgentConfigChatUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent
}
