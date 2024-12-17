// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.client

import me.elborai.api.services.blocking.StoreService
import me.elborai.api.services.blocking.UserService

interface SamClient {

    fun async(): SamClientAsync

    fun store(): StoreService

    fun users(): UserService
}
