// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import me.elborai.api.core.ClientOptions

class UserServiceAsyncImpl internal constructor(
    private val clientOptions: ClientOptions,

) : UserServiceAsync {

    private val withRawResponse: UserServiceAsync.WithRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): UserServiceAsync.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(
        private val clientOptions: ClientOptions,

    ) : UserServiceAsync.WithRawResponse
}
