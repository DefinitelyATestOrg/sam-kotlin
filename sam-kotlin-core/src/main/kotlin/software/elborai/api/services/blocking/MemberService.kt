// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.models.MemberDeleteParams
import software.elborai.api.models.MemberUpdateParams

interface MemberService {

    fun update(
        params: MemberUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BinaryResponseContent

    fun delete(params: MemberDeleteParams, requestOptions: RequestOptions = RequestOptions.none())
}
