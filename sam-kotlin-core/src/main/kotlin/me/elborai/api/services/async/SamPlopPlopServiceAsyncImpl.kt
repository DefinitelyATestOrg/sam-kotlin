// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import me.elborai.api.core.ClientOptions

class SamPlopPlopServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SamPlopPlopServiceAsync {

    private val withRawResponse: SamPlopPlopServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SamPlopPlopServiceAsync.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SamPlopPlopServiceAsync.WithRawResponse
}
