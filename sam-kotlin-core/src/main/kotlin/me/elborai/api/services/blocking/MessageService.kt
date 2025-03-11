// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.models.messages.MessageCountTokensBetaParams
import me.elborai.api.models.messages.MessageCountTokensBetaResponse
import me.elborai.api.models.messages.MessageCountTokensParams
import me.elborai.api.models.messages.MessageCountTokensResponse
import me.elborai.api.models.messages.MessageCreateParams
import me.elborai.api.models.messages.MessageCreateResponse
import me.elborai.api.services.blocking.messages.BatchService
import me.elborai.api.services.blocking.messages.BatchesBetaTrueService

interface MessageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for
     * each method.
     */
    fun withRawResponse(): WithRawResponse

    fun batches(): BatchService

    fun batchesBetaTrue(): BatchesBetaTrueService

    /**
     * Send a structured list of input messages with text and/or image content, and the
     * model will generate the next message in the conversation.
     *
     * The Messages API can be used for either single queries or stateless multi-turn
     * conversations.
     *
     * Learn more about the Messages API in our [user guide](/en/docs/initial-setup)
     */
    fun create(params: MessageCreateParams, requestOptions: RequestOptions = RequestOptions.none()): MessageCreateResponse

    /**
     * Count the number of tokens in a Message.
     *
     * The Token Count API can be used to count the number of tokens in a Message,
     * including tools, images, and documents, without creating it.
     *
     * Learn more about token counting in our
     * [user guide](/en/docs/build-with-claude/token-counting)
     */
    fun countTokens(params: MessageCountTokensParams, requestOptions: RequestOptions = RequestOptions.none()): MessageCountTokensResponse

    /**
     * Count the number of tokens in a Message.
     *
     * The Token Count API can be used to count the number of tokens in a Message,
     * including tools, images, and documents, without creating it.
     *
     * Learn more about token counting in our
     * [user guide](/en/docs/build-with-claude/token-counting)
     */
    fun countTokensBeta(params: MessageCountTokensBetaParams, requestOptions: RequestOptions = RequestOptions.none()): MessageCountTokensBetaResponse

    /**
     * A view of [MessageService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        fun batches(): BatchService.WithRawResponse

        fun batchesBetaTrue(): BatchesBetaTrueService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/messages`, but is otherwise the same
         * as [MessageService.create].
         */
        @MustBeClosed
        fun create(params: MessageCreateParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<MessageCreateResponse>

        /**
         * Returns a raw HTTP response for `post /v1/messages/count_tokens`, but is
         * otherwise the same as [MessageService.countTokens].
         */
        @MustBeClosed
        fun countTokens(params: MessageCountTokensParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<MessageCountTokensResponse>

        /**
         * Returns a raw HTTP response for `post /v1/messages/count_tokens?beta=true`, but
         * is otherwise the same as [MessageService.countTokensBeta].
         */
        @MustBeClosed
        fun countTokensBeta(params: MessageCountTokensBetaParams, requestOptions: RequestOptions = RequestOptions.none()): HttpResponseFor<MessageCountTokensBetaResponse>
    }
}
