// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking.agents.configs

import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.AgentConfigChatRetrieveParams
import software.elborai.api.models.AgentConfigChatUpdateParams

interface ChatService {

    fun retrieve(
        params: AgentConfigChatRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    fun update(
        params: AgentConfigChatUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent
}
