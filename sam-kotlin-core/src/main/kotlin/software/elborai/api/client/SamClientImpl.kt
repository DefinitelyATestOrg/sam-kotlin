// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.client

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.getPackageVersion
import software.elborai.api.models.*
import software.elborai.api.services.blocking.*

class SamClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : SamClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.containsKey("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Kotlin ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: SamClientAsync by lazy { SamClientAsyncImpl(clientOptions) }

    private val pets: PetService by lazy { PetServiceImpl(clientOptionsWithUserAgent) }

    private val stores: StoreService by lazy { StoreServiceImpl(clientOptionsWithUserAgent) }

    private val users: UserService by lazy { UserServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): SamClientAsync = async

    override fun pets(): PetService = pets

    override fun stores(): StoreService = stores

    override fun users(): UserService = users
}
