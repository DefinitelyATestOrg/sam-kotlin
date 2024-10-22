// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.client

import software.elborai.api.models.*
import software.elborai.api.services.async.*

interface SamClientAsync {

    fun sync(): SamClient

    fun pets(): PetServiceAsync

    fun stores(): StoreServiceAsync

    fun users(): UserServiceAsync
}
