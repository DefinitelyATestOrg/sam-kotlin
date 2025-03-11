// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.core.ClientOptions

class UserServiceImpl internal constructor(
    private val clientOptions: ClientOptions,

) : UserService {

    private val withRawResponse: UserService.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): UserService.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : UserService.WithRawResponse
}
