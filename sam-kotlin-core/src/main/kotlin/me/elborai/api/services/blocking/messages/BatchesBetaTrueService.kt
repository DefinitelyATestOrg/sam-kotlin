// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.messages

import com.google.errorprone.annotations.MustBeClosed
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.models.MessageBatchesBetaTrueCreateParams
import me.elborai.api.models.MessageBatchesBetaTrueCreateResponse
import me.elborai.api.models.MessageBatchesBetaTrueListParams
import me.elborai.api.models.MessageBatchesBetaTrueListResponse

interface BatchesBetaTrueService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Send a batch of Message creation requests.
     *
     * The Message Batches API can be used to process multiple Messages API requests at once. Once a
     * Message Batch is created, it begins processing immediately. Batches can take up to 24 hours
     * to complete.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    fun create(
        params: MessageBatchesBetaTrueCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageBatchesBetaTrueCreateResponse

    /**
     * List all Message Batches within a Workspace. Most recently created batches are returned
     * first.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    fun list(
        params: MessageBatchesBetaTrueListParams = MessageBatchesBetaTrueListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageBatchesBetaTrueListResponse

    /** @see [list] */
    fun list(requestOptions: RequestOptions): MessageBatchesBetaTrueListResponse =
        list(MessageBatchesBetaTrueListParams.none(), requestOptions)

    /**
     * A view of [BatchesBetaTrueService] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/messages/batches?beta=true`, but is otherwise
         * the same as [BatchesBetaTrueService.create].
         */
        @MustBeClosed
        fun create(
            params: MessageBatchesBetaTrueCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageBatchesBetaTrueCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/messages/batches?beta=true`, but is otherwise
         * the same as [BatchesBetaTrueService.list].
         */
        @MustBeClosed
        fun list(
            params: MessageBatchesBetaTrueListParams = MessageBatchesBetaTrueListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageBatchesBetaTrueListResponse>

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): HttpResponseFor<MessageBatchesBetaTrueListResponse> =
            list(MessageBatchesBetaTrueListParams.none(), requestOptions)
    }
}
