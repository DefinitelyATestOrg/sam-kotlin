// File generated from our OpenAPI spec by Stainless.

package com.sam.api.client

import com.sam.api.services.blocking.StoreService
import com.sam.api.services.blocking.UserService

interface SamClient {

    fun async(): SamClientAsync

    fun store(): StoreService

    fun users(): UserService
}
