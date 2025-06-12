// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.client

import me.elborai.api.core.ClientOptions
import me.elborai.api.core.getPackageVersion
import me.elborai.api.services.blocking.CompleteService
import me.elborai.api.services.blocking.CompleteServiceImpl
import me.elborai.api.services.blocking.MessageService
import me.elborai.api.services.blocking.MessageServiceImpl
import me.elborai.api.services.blocking.MessagesBetaTrueService
import me.elborai.api.services.blocking.MessagesBetaTrueServiceImpl
import me.elborai.api.services.blocking.ModelService
import me.elborai.api.services.blocking.ModelServiceImpl
import me.elborai.api.services.blocking.ModelsBetaTrueService
import me.elborai.api.services.blocking.ModelsBetaTrueServiceImpl
import me.elborai.api.services.blocking.SamPlopPlopService
import me.elborai.api.services.blocking.SamPlopPlopServiceImpl
import me.elborai.api.services.blocking.StoreService
import me.elborai.api.services.blocking.StoreServiceImpl
import me.elborai.api.services.blocking.UserService
import me.elborai.api.services.blocking.UserServiceImpl

class SamClientImpl(private val clientOptions: ClientOptions) : SamClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: SamClientAsync by lazy { SamClientAsyncImpl(clientOptions) }

    private val withRawResponse: SamClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val store: StoreService by lazy { StoreServiceImpl(clientOptionsWithUserAgent) }

    private val user: UserService by lazy { UserServiceImpl(clientOptionsWithUserAgent) }

    private val messages: MessageService by lazy { MessageServiceImpl(clientOptionsWithUserAgent) }

    private val complete: CompleteService by lazy {
        CompleteServiceImpl(clientOptionsWithUserAgent)
    }

    private val models: ModelService by lazy { ModelServiceImpl(clientOptionsWithUserAgent) }

    private val messagesBetaTrue: MessagesBetaTrueService by lazy {
        MessagesBetaTrueServiceImpl(clientOptionsWithUserAgent)
    }

    private val modelsBetaTrue: ModelsBetaTrueService by lazy {
        ModelsBetaTrueServiceImpl(clientOptionsWithUserAgent)
    }

    private val samPlopPlop: SamPlopPlopService by lazy {
        SamPlopPlopServiceImpl(clientOptionsWithUserAgent)
    }

    override fun async(): SamClientAsync = async

    override fun withRawResponse(): SamClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SamClient =
        SamClientImpl(clientOptions.toBuilder().apply(modifier).build())

    override fun store(): StoreService = store

    override fun user(): UserService = user

    override fun messages(): MessageService = messages

    override fun complete(): CompleteService = complete

    override fun models(): ModelService = models

    override fun messagesBetaTrue(): MessagesBetaTrueService = messagesBetaTrue

    override fun modelsBetaTrue(): ModelsBetaTrueService = modelsBetaTrue

    override fun samPlopPlop(): SamPlopPlopService = samPlopPlop

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SamClient.WithRawResponse {

        private val store: StoreService.WithRawResponse by lazy {
            StoreServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val user: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageService.WithRawResponse by lazy {
            MessageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val complete: CompleteService.WithRawResponse by lazy {
            CompleteServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val models: ModelService.WithRawResponse by lazy {
            ModelServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val messagesBetaTrue: MessagesBetaTrueService.WithRawResponse by lazy {
            MessagesBetaTrueServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val modelsBetaTrue: ModelsBetaTrueService.WithRawResponse by lazy {
            ModelsBetaTrueServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val samPlopPlop: SamPlopPlopService.WithRawResponse by lazy {
            SamPlopPlopServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): SamClient.WithRawResponse =
            SamClientImpl.WithRawResponseImpl(clientOptions.toBuilder().apply(modifier).build())

        override fun store(): StoreService.WithRawResponse = store

        override fun user(): UserService.WithRawResponse = user

        override fun messages(): MessageService.WithRawResponse = messages

        override fun complete(): CompleteService.WithRawResponse = complete

        override fun models(): ModelService.WithRawResponse = models

        override fun messagesBetaTrue(): MessagesBetaTrueService.WithRawResponse = messagesBetaTrue

        override fun modelsBetaTrue(): ModelsBetaTrueService.WithRawResponse = modelsBetaTrue

        override fun samPlopPlop(): SamPlopPlopService.WithRawResponse = samPlopPlop
    }
}
