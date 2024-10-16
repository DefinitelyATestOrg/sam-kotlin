// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.client

import software.elborai.api.core.ClientOptions
import software.elborai.api.models.*
import software.elborai.api.services.blocking.*

class SamClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : SamClient {

    private val async: SamClientAsync by lazy { SamClientAsyncImpl(clientOptions) }

    private val pets: PetService by lazy { PetServiceImpl(clientOptions) }

    private val stores: StoreService by lazy { StoreServiceImpl(clientOptions) }

    private val users: UserService by lazy { UserServiceImpl(clientOptions) }

    override fun async(): SamClientAsync = async

    override fun pets(): PetService = pets

    override fun stores(): StoreService = stores

    override fun users(): UserService = users
}
