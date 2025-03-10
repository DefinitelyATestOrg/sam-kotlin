// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.messages.batches

import com.google.errorprone.annotations.MustBeClosed
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.models.MessageBatchBetaTrueDeleteParams
import me.elborai.api.models.MessageBatchBetaTrueDeleteResponse
import me.elborai.api.models.MessageBatchBetaTrueRetrieveParams
import me.elborai.api.models.MessageBatchBetaTrueRetrieveResponse

interface BetaTrueService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * This endpoint is idempotent and can be used to poll for Message Batch completion. To access
     * the results of a Message Batch, make a request to the `results_url` field in the response.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    fun retrieve(
        params: MessageBatchBetaTrueRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageBatchBetaTrueRetrieveResponse

    /**
     * Delete a Message Batch.
     *
     * Message Batches can only be deleted once they've finished processing. If you'd like to delete
     * an in-progress batch, you must first cancel it.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    fun delete(
        params: MessageBatchBetaTrueDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageBatchBetaTrueDeleteResponse

    /** A view of [BetaTrueService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/messages/batches/{message_batch_id}?beta=true`,
         * but is otherwise the same as [BetaTrueService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: MessageBatchBetaTrueRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageBatchBetaTrueRetrieveResponse>

        /**
         * Returns a raw HTTP response for `delete
         * /v1/messages/batches/{message_batch_id}?beta=true`, but is otherwise the same as
         * [BetaTrueService.delete].
         */
        @MustBeClosed
        fun delete(
            params: MessageBatchBetaTrueDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageBatchBetaTrueDeleteResponse>
    }
}
