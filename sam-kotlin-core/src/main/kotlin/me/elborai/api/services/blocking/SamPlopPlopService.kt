// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import me.elborai.api.core.ClientOptions

interface SamPlopPlopService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): SamPlopPlopService

    /**
     * A view of [SamPlopPlopService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): SamPlopPlopService.WithRawResponse
    }
}
