// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.client

import me.elborai.api.services.async.CompleteServiceAsync
import me.elborai.api.services.async.MessageServiceAsync
import me.elborai.api.services.async.MessagesBetaTrueServiceAsync
import me.elborai.api.services.async.ModelServiceAsync
import me.elborai.api.services.async.ModelsBetaTrueServiceAsync
import me.elborai.api.services.async.SamPlopPlopServiceAsync
import me.elborai.api.services.async.StoreServiceAsync
import me.elborai.api.services.async.UserServiceAsync

/**
 * A client for interacting with the Sam REST API asynchronously. You can also switch to synchronous
 * execution via the [sync] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface SamClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): SamClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun store(): StoreServiceAsync

    fun user(): UserServiceAsync

    fun messages(): MessageServiceAsync

    fun complete(): CompleteServiceAsync

    fun models(): ModelServiceAsync

    fun messagesBetaTrue(): MessagesBetaTrueServiceAsync

    fun modelsBetaTrue(): ModelsBetaTrueServiceAsync

    fun samPlopPlop(): SamPlopPlopServiceAsync

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /** A view of [SamClientAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun store(): StoreServiceAsync.WithRawResponse

        fun user(): UserServiceAsync.WithRawResponse

        fun messages(): MessageServiceAsync.WithRawResponse

        fun complete(): CompleteServiceAsync.WithRawResponse

        fun models(): ModelServiceAsync.WithRawResponse

        fun messagesBetaTrue(): MessagesBetaTrueServiceAsync.WithRawResponse

        fun modelsBetaTrue(): ModelsBetaTrueServiceAsync.WithRawResponse

        fun samPlopPlop(): SamPlopPlopServiceAsync.WithRawResponse
    }
}
