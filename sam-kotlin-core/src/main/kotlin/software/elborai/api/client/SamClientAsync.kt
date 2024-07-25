// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.client

import software.elborai.api.models.*
import software.elborai.api.services.async.*

interface SamClientAsync {

    fun sync(): SamClient

    fun pets(): PetServiceAsync

    fun stores(): StoreServiceAsync

    fun users(): UserServiceAsync
}
