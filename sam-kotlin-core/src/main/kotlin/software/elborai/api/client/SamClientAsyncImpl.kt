// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.client

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.SamError
import software.elborai.api.models.*
import software.elborai.api.services.async.*
import software.elborai.api.services.errorHandler

class SamClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : SamClientAsync {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val sync: SamClient by lazy { SamClientImpl(clientOptions) }

    private val pets: PetServiceAsync by lazy { PetServiceAsyncImpl(clientOptions) }

    private val stores: StoreServiceAsync by lazy { StoreServiceAsyncImpl(clientOptions) }

    private val store: StoreServiceAsync by lazy { StoreServiceAsyncImpl(clientOptions) }

    private val users: UserServiceAsync by lazy { UserServiceAsyncImpl(clientOptions) }

    override fun sync(): SamClient = sync

    override fun pets(): PetServiceAsync = pets

    override fun stores(): StoreServiceAsync = stores

    override fun store(): StoreServiceAsync = store

    override fun users(): UserServiceAsync = users
}
