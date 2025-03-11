// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.client

import me.elborai.api.services.blocking.CompleteService
import me.elborai.api.services.blocking.MessageService
import me.elborai.api.services.blocking.MessagesBetaTrueService
import me.elborai.api.services.blocking.ModelService
import me.elborai.api.services.blocking.ModelsBetaTrueService
import me.elborai.api.services.blocking.StoreService
import me.elborai.api.services.blocking.UserService

/**
 * A client for interacting with the Sam REST API synchronously. You can also switch to asynchronous
 * execution via the [async] method.
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
interface SamClient {

    /**
     * Returns a version of this client that uses asynchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun async(): SamClientAsync

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun store(): StoreService

    fun user(): UserService

    fun messages(): MessageService

    fun complete(): CompleteService

    fun models(): ModelService

    fun messagesBetaTrue(): MessagesBetaTrueService

    fun modelsBetaTrue(): ModelsBetaTrueService

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

    /** A view of [SamClient] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun store(): StoreService.WithRawResponse

        fun user(): UserService.WithRawResponse

        fun messages(): MessageService.WithRawResponse

        fun complete(): CompleteService.WithRawResponse

        fun models(): ModelService.WithRawResponse

        fun messagesBetaTrue(): MessagesBetaTrueService.WithRawResponse

        fun modelsBetaTrue(): ModelsBetaTrueService.WithRawResponse
    }
}
