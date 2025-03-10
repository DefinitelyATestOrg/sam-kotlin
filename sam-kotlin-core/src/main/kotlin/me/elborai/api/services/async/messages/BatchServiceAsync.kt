// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async.messages

import com.google.errorprone.annotations.MustBeClosed
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.models.MessageBatchCancelBetaParams
import me.elborai.api.models.MessageBatchCancelBetaResponse
import me.elborai.api.models.MessageBatchCancelParams
import me.elborai.api.models.MessageBatchCancelResponse
import me.elborai.api.models.MessageBatchCreateParams
import me.elborai.api.models.MessageBatchCreateResponse
import me.elborai.api.models.MessageBatchDeleteParams
import me.elborai.api.models.MessageBatchDeleteResponse
import me.elborai.api.models.MessageBatchListParams
import me.elborai.api.models.MessageBatchListResponse
import me.elborai.api.models.MessageBatchResultsBetaParams
import me.elborai.api.models.MessageBatchResultsBetaResponse
import me.elborai.api.models.MessageBatchResultsParams
import me.elborai.api.models.MessageBatchResultsResponse
import me.elborai.api.models.MessageBatchRetrieveParams
import me.elborai.api.models.MessageBatchRetrieveResponse
import me.elborai.api.services.async.messages.batches.BetaTrueServiceAsync

interface BatchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun betaTrue(): BetaTrueServiceAsync

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
    suspend fun create(
        params: MessageBatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageBatchCreateResponse

    /**
     * This endpoint is idempotent and can be used to poll for Message Batch completion. To access
     * the results of a Message Batch, make a request to the `results_url` field in the response.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    suspend fun retrieve(
        params: MessageBatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageBatchRetrieveResponse

    /**
     * List all Message Batches within a Workspace. Most recently created batches are returned
     * first.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    suspend fun list(
        params: MessageBatchListParams = MessageBatchListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageBatchListResponse

    /** @see [list] */
    suspend fun list(requestOptions: RequestOptions): MessageBatchListResponse =
        list(MessageBatchListParams.none(), requestOptions)

    /**
     * Delete a Message Batch.
     *
     * Message Batches can only be deleted once they've finished processing. If you'd like to delete
     * an in-progress batch, you must first cancel it.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    suspend fun delete(
        params: MessageBatchDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageBatchDeleteResponse

    /**
     * Batches may be canceled any time before processing ends. Once cancellation is initiated, the
     * batch enters a `canceling` state, at which time the system may complete any in-progress,
     * non-interruptible requests before finalizing cancellation.
     *
     * The number of canceled requests is specified in `request_counts`. To determine which requests
     * were canceled, check the individual results within the batch. Note that cancellation may not
     * result in any canceled requests if they were non-interruptible.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    suspend fun cancel(
        params: MessageBatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageBatchCancelResponse

    /**
     * Batches may be canceled any time before processing ends. Once cancellation is initiated, the
     * batch enters a `canceling` state, at which time the system may complete any in-progress,
     * non-interruptible requests before finalizing cancellation.
     *
     * The number of canceled requests is specified in `request_counts`. To determine which requests
     * were canceled, check the individual results within the batch. Note that cancellation may not
     * result in any canceled requests if they were non-interruptible.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    suspend fun cancelBeta(
        params: MessageBatchCancelBetaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageBatchCancelBetaResponse

    /**
     * Streams the results of a Message Batch as a `.jsonl` file.
     *
     * Each line in the file is a JSON object containing the result of a single request in the
     * Message Batch. Results are not guaranteed to be in the same order as requests. Use the
     * `custom_id` field to match results to requests.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    suspend fun results(
        params: MessageBatchResultsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageBatchResultsResponse

    /**
     * Streams the results of a Message Batch as a `.jsonl` file.
     *
     * Each line in the file is a JSON object containing the result of a single request in the
     * Message Batch. Results are not guaranteed to be in the same order as requests. Use the
     * `custom_id` field to match results to requests.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    suspend fun resultsBeta(
        params: MessageBatchResultsBetaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): MessageBatchResultsBetaResponse

    /** A view of [BatchServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun betaTrue(): BetaTrueServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/messages/batches`, but is otherwise the same as
         * [BatchServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: MessageBatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageBatchCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/messages/batches/{message_batch_id}`, but is
         * otherwise the same as [BatchServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            params: MessageBatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageBatchRetrieveResponse>

        /**
         * Returns a raw HTTP response for `get /v1/messages/batches`, but is otherwise the same as
         * [BatchServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: MessageBatchListParams = MessageBatchListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageBatchListResponse>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(
            requestOptions: RequestOptions
        ): HttpResponseFor<MessageBatchListResponse> =
            list(MessageBatchListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/messages/batches/{message_batch_id}`, but is
         * otherwise the same as [BatchServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            params: MessageBatchDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageBatchDeleteResponse>

        /**
         * Returns a raw HTTP response for `post /v1/messages/batches/{message_batch_id}/cancel`,
         * but is otherwise the same as [BatchServiceAsync.cancel].
         */
        @MustBeClosed
        suspend fun cancel(
            params: MessageBatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageBatchCancelResponse>

        /**
         * Returns a raw HTTP response for `post
         * /v1/messages/batches/{message_batch_id}/cancel?beta=true`, but is otherwise the same as
         * [BatchServiceAsync.cancelBeta].
         */
        @MustBeClosed
        suspend fun cancelBeta(
            params: MessageBatchCancelBetaParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageBatchCancelBetaResponse>

        /**
         * Returns a raw HTTP response for `get /v1/messages/batches/{message_batch_id}/results`,
         * but is otherwise the same as [BatchServiceAsync.results].
         */
        @MustBeClosed
        suspend fun results(
            params: MessageBatchResultsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageBatchResultsResponse>

        /**
         * Returns a raw HTTP response for `get
         * /v1/messages/batches/{message_batch_id}/results?beta=true`, but is otherwise the same as
         * [BatchServiceAsync.resultsBeta].
         */
        @MustBeClosed
        suspend fun resultsBeta(
            params: MessageBatchResultsBetaParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<MessageBatchResultsBetaResponse>
    }
}
