// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.client

import software.elborai.api.models.*
import software.elborai.api.services.blocking.*

interface SamClient {

    fun async(): SamClientAsync

    fun pets(): PetService

    fun stores(): StoreService

    fun store(): StoreService

    fun users(): UserService
}
