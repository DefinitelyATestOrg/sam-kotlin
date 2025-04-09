// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.client

import me.elborai.api.core.ClientOptions
import me.elborai.api.core.getPackageVersion
import me.elborai.api.services.async.CompleteServiceAsync
import me.elborai.api.services.async.CompleteServiceAsyncImpl
import me.elborai.api.services.async.MessageServiceAsync
import me.elborai.api.services.async.MessageServiceAsyncImpl
import me.elborai.api.services.async.MessagesBetaTrueServiceAsync
import me.elborai.api.services.async.MessagesBetaTrueServiceAsyncImpl
import me.elborai.api.services.async.ModelServiceAsync
import me.elborai.api.services.async.ModelServiceAsyncImpl
import me.elborai.api.services.async.ModelsBetaTrueServiceAsync
import me.elborai.api.services.async.ModelsBetaTrueServiceAsyncImpl
import me.elborai.api.services.async.SamPlopPlopServiceAsync
import me.elborai.api.services.async.SamPlopPlopServiceAsyncImpl
import me.elborai.api.services.async.StoreServiceAsync
import me.elborai.api.services.async.StoreServiceAsyncImpl
import me.elborai.api.services.async.UserServiceAsync
import me.elborai.api.services.async.UserServiceAsyncImpl

class SamClientAsyncImpl(private val clientOptions: ClientOptions) : SamClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: SamClient by lazy { SamClientImpl(clientOptions) }

    private val withRawResponse: SamClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val store: StoreServiceAsync by lazy {
        StoreServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val user: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val messages: MessageServiceAsync by lazy {
        MessageServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val complete: CompleteServiceAsync by lazy {
        CompleteServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val models: ModelServiceAsync by lazy {
        ModelServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val messagesBetaTrue: MessagesBetaTrueServiceAsync by lazy {
        MessagesBetaTrueServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val modelsBetaTrue: ModelsBetaTrueServiceAsync by lazy {
        ModelsBetaTrueServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val samPlopPlop: SamPlopPlopServiceAsync by lazy {
        SamPlopPlopServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): SamClient = sync

    override fun withRawResponse(): SamClientAsync.WithRawResponse = withRawResponse

    override fun store(): StoreServiceAsync = store

    override fun user(): UserServiceAsync = user

    override fun messages(): MessageServiceAsync = messages

    override fun complete(): CompleteServiceAsync = complete

    override fun models(): ModelServiceAsync = models

    override fun messagesBetaTrue(): MessagesBetaTrueServiceAsync = messagesBetaTrue

    override fun modelsBetaTrue(): ModelsBetaTrueServiceAsync = modelsBetaTrue

    override fun samPlopPlop(): SamPlopPlopServiceAsync = samPlopPlop

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SamClientAsync.WithRawResponse {

        private val store: StoreServiceAsync.WithRawResponse by lazy {
            StoreServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val user: UserServiceAsync.WithRawResponse by lazy {
            UserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageServiceAsync.WithRawResponse by lazy {
            MessageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val complete: CompleteServiceAsync.WithRawResponse by lazy {
            CompleteServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val models: ModelServiceAsync.WithRawResponse by lazy {
            ModelServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val messagesBetaTrue: MessagesBetaTrueServiceAsync.WithRawResponse by lazy {
            MessagesBetaTrueServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val modelsBetaTrue: ModelsBetaTrueServiceAsync.WithRawResponse by lazy {
            ModelsBetaTrueServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val samPlopPlop: SamPlopPlopServiceAsync.WithRawResponse by lazy {
            SamPlopPlopServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun store(): StoreServiceAsync.WithRawResponse = store

        override fun user(): UserServiceAsync.WithRawResponse = user

        override fun messages(): MessageServiceAsync.WithRawResponse = messages

        override fun complete(): CompleteServiceAsync.WithRawResponse = complete

        override fun models(): ModelServiceAsync.WithRawResponse = models

        override fun messagesBetaTrue(): MessagesBetaTrueServiceAsync.WithRawResponse =
            messagesBetaTrue

        override fun modelsBetaTrue(): ModelsBetaTrueServiceAsync.WithRawResponse = modelsBetaTrue

        override fun samPlopPlop(): SamPlopPlopServiceAsync.WithRawResponse = samPlopPlop
    }
}
