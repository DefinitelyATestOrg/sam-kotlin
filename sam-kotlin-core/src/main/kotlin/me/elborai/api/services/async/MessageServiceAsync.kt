// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import com.google.errorprone.annotations.MustBeClosed
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.models.messages.MessageCountTokensBetaParams
import me.elborai.api.models.messages.MessageCountTokensBetaResponse
import me.elborai.api.models.messages.MessageCountTokensParams
import me.elborai.api.models.messages.MessageCountTokensResponse
import me.elborai.api.models.messages.MessageCreateParams
import me.elborai.api.models.messages.MessageCreateResponse
import me.elborai.api.services.async.messages.BatchServiceAsync
import me.elborai.api.services.async.messages.BatchesBetaTrueServiceAsync

interface MessageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    fun batches(): BatchServiceAsync

    fun batchesBetaTrue(): BatchesBetaTrueServiceAsync

    /**
     * Send a structured list of input messages with text and/or image content, and the
     * model will generate the next message in the conversation.
     *
     * The Messages API can be used for either single queries or stateless multi-turn
     * conversations.
     *
     * Learn more about the Messages API in our [user guide](/en/docs/initial-setup)
     */
    suspend fun create(params: MessageCreateParams, requestOptions: RequestOptions = RequestOptions.none()): MessageCreateResponse

    /**
     * Count the number of tokens in a Message.
     *
     * The Token Count API can be used to count the number of tokens in a Message,
     * including tools, images, and documents, without creating it.
     *
     * Learn more about token counting in our
     * [user guide](/en/docs/build-with-claude/token-counting)
     */
    suspend fun countTokens(params: MessageCountTokensParams, requestOptions: RequestOptions = RequestOptions.none()): MessageCountTokensResponse

    /**
     * Count the number of tokens in a Message.
     *
     * The Token Count API can be used to count the number of tokens in a Message,
     * including tools, images, and documents, without creating it.
     *
     * Learn more about token counting in our
     * [user guide](/en/docs/build-with-claude/token-counting)
     */
    suspend fun countTokensBeta(params: MessageCountTokensBetaParams, requestOptions: RequestOptions = RequestOptions.none()): MessageCountTokensBetaResponse

    /**
     * A view of [MessageServiceAsync] that provides access to raw HTTP responses for
     * each method.
     */
    interface WithRawResponse {

        fun batches(): BatchServiceAsync.WithRawResponse

        fun batchesBetaTrue(): BatchesBetaTrueServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/messages`, but is otherwise the same
         * as [MessageServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(params: MessageCreateParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<MessageCreateResponse>

        /**
         * Returns a raw HTTP response for `post /v1/messages/count_tokens`, but is
         * otherwise the same as [MessageServiceAsync.countTokens].
         */
        @MustBeClosed
        suspend fun countTokens(params: MessageCountTokensParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<MessageCountTokensResponse>

        /**
         * Returns a raw HTTP response for `post /v1/messages/count_tokens?beta=true`, but
         * is otherwise the same as [MessageServiceAsync.countTokensBeta].
         */
        @MustBeClosed
        suspend fun countTokensBeta(params: MessageCountTokensBetaParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<MessageCountTokensBetaResponse>
    }
}
