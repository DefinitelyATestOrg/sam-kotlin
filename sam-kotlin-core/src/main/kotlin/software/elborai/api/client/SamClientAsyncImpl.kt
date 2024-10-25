// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.client

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.getPackageVersion
import software.elborai.api.models.*
import software.elborai.api.services.async.*

class SamClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : SamClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.containsKey("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: SamClient by lazy { SamClientImpl(clientOptions) }

    private val pets: PetServiceAsync by lazy { PetServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val stores: StoreServiceAsync by lazy {
        StoreServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptionsWithUserAgent) }

    override fun sync(): SamClient = sync

    override fun pets(): PetServiceAsync = pets

    override fun stores(): StoreServiceAsync = stores

    override fun users(): UserServiceAsync = users
}
