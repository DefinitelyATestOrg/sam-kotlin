// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.core.ClientOptions

class SamPlopPlopServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SamPlopPlopService {

    private val withRawResponse: SamPlopPlopService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SamPlopPlopService.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SamPlopPlopService.WithRawResponse
}
