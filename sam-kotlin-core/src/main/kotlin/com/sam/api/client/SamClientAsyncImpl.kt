// File generated from our OpenAPI spec by Stainless.

package com.sam.api.client

import com.sam.api.core.ClientOptions
import com.sam.api.core.getPackageVersion
import com.sam.api.services.async.StoreServiceAsync
import com.sam.api.services.async.StoreServiceAsyncImpl
import com.sam.api.services.async.UserServiceAsync
import com.sam.api.services.async.UserServiceAsyncImpl

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
