// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

interface UserService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** A view of [UserService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse
}
