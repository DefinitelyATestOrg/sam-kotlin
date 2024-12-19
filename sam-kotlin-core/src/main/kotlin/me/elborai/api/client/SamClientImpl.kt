// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.client

import me.elborai.api.core.ClientOptions
import me.elborai.api.core.getPackageVersion
import me.elborai.api.services.blocking.StoreService
import me.elborai.api.services.blocking.StoreServiceImpl
import me.elborai.api.services.blocking.UserService
import me.elborai.api.services.blocking.UserServiceImpl

class SamClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : SamClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: SamClientAsync by lazy { SamClientAsyncImpl(clientOptions) }

    private val store: StoreService by lazy { StoreServiceImpl(clientOptionsWithUserAgent) }

    private val users: UserService by lazy { UserServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): SamClientAsync = async

    override fun store(): StoreService = store

    override fun users(): UserService = users
}
