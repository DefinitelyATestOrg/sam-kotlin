// File generated from our OpenAPI spec by Stainless.

package com.sam.api.client

import com.sam.api.services.async.StoreServiceAsync
import com.sam.api.services.async.UserServiceAsync

interface SamClientAsync {

    fun sync(): SamClient

    fun store(): StoreServiceAsync

    fun users(): UserServiceAsync
}
