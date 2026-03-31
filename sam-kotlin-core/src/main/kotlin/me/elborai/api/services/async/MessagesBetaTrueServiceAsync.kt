// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import me.elborai.api.core.ClientOptions
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.models.messagesbetatrue.MessagesBetaTrueCreateParams
import me.elborai.api.models.messagesbetatrue.MessagesBetaTrueCreateResponse

interface MessagesBetaTrueServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): MessagesBetaTrueServiceAsync

    /**
     * Send a structured list of input messages with text and/or image content, and the model will
     * generate the next message in the conversation.
     *
     * The Messages API can be used for either single queries or stateless multi-turn conversations.
     *
     * Learn more about the Messages API in our [user guide](/en/docs/initial-setup)
     */
    suspend fun create(
        params: MessagesBetaTrueCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessagesBetaTrueCreateResponse

    /**
     * A view of [MessagesBetaTrueServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): MessagesBetaTrueServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/messages?beta=true`, but is otherwise the same
         * as [MessagesBetaTrueServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: MessagesBetaTrueCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessagesBetaTrueCreateResponse>
    }
}
