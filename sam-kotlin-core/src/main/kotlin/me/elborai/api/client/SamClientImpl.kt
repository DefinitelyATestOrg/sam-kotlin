// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.client

import me.elborai.api.core.ClientOptions
import me.elborai.api.core.getPackageVersion
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

    override fun async(): SamClientAsync = async

    override fun withRawResponse(): SamClient.WithRawResponse = withRawResponse

    override fun store(): StoreService = store

    override fun user(): UserService = user

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SamClient.WithRawResponse {

        private val store: StoreService.WithRawResponse by lazy {
            StoreServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val user: UserService.WithRawResponse by lazy {
            UserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun store(): StoreService.WithRawResponse = store

        override fun user(): UserService.WithRawResponse = user
    }
}
