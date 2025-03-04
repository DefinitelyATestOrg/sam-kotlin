// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import me.elborai.api.services.async.store.OrderServiceAsync

interface StoreServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun orders(): OrderServiceAsync

    /** A view of [StoreServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun orders(): OrderServiceAsync.WithRawResponse
    }
}
