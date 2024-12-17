// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.client

import me.elborai.api.core.ClientOptions
import me.elborai.api.core.getPackageVersion
import me.elborai.api.services.async.StoreServiceAsync
import me.elborai.api.services.async.StoreServiceAsyncImpl
import me.elborai.api.services.async.UserServiceAsync
import me.elborai.api.services.async.UserServiceAsyncImpl

class SamClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : SamClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: SamClient by lazy { SamClientImpl(clientOptions) }

    private val store: StoreServiceAsync by lazy {
        StoreServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): SamClient = sync

    override fun store(): StoreServiceAsync = store

    override fun users(): UserServiceAsync = users
}
