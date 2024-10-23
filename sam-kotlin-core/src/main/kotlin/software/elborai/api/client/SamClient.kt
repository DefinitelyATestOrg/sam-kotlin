// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.client

import software.elborai.api.models.*
import software.elborai.api.services.blocking.*

interface SamClient {

    fun async(): SamClientAsync

    fun pets(): PetService

    fun stores(): StoreService

    fun users(): UserService
}
