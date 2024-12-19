// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import me.elborai.api.services.async.store.OrderServiceAsync

interface StoreServiceAsync {

    fun orders(): OrderServiceAsync
}
