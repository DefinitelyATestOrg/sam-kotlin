// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking.agents

import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.AgentHiddenTagUpdateParams

interface HiddenTagService {

    fun update(
        params: AgentHiddenTagUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent
}
