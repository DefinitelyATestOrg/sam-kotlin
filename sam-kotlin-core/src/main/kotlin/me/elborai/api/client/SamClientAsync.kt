// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.client

import me.elborai.api.services.async.StoreServiceAsync
import me.elborai.api.services.async.UserServiceAsync

interface SamClientAsync {

    fun sync(): SamClient

    fun store(): StoreServiceAsync

    fun users(): UserServiceAsync
}
