// File generated from our OpenAPI spec by Stainless.

package com.sam.api.services.async

import com.sam.api.services.async.store.OrderServiceAsync

interface StoreServiceAsync {

    fun orders(): OrderServiceAsync
}
