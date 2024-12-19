// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.services.blocking.store.OrderService

interface StoreService {

    fun orders(): OrderService
}
