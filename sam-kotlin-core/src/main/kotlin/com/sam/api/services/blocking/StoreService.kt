// File generated from our OpenAPI spec by Stainless.

package com.sam.api.services.blocking

import com.sam.api.services.blocking.store.OrderService

interface StoreService {

    fun orders(): OrderService
}
