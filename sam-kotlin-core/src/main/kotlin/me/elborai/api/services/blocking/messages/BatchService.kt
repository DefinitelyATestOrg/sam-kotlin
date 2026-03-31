// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.messages

import com.google.errorprone.annotations.MustBeClosed
import me.elborai.api.core.ClientOptions
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.core.http.StreamResponse
import me.elborai.api.models.messages.batches.BatchCancelBetaParams
import me.elborai.api.models.messages.batches.BatchCancelBetaResponse
import me.elborai.api.models.messages.batches.BatchCancelParams
import me.elborai.api.models.messages.batches.BatchCancelResponse
import me.elborai.api.models.messages.batches.BatchCreateParams
import me.elborai.api.models.messages.batches.BatchCreateResponse
import me.elborai.api.models.messages.batches.BatchDeleteParams
import me.elborai.api.models.messages.batches.BatchDeleteResponse
import me.elborai.api.models.messages.batches.BatchListParams
import me.elborai.api.models.messages.batches.BatchListResponse
import me.elborai.api.models.messages.batches.BatchResultsBetaParams
import me.elborai.api.models.messages.batches.BatchResultsBetaResponse
import me.elborai.api.models.messages.batches.BatchResultsParams
import me.elborai.api.models.messages.batches.BatchResultsResponse
import me.elborai.api.models.messages.batches.BatchRetrieveParams
import me.elborai.api.models.messages.batches.BatchRetrieveResponse
import me.elborai.api.services.blocking.messages.batches.BetaTrueService

interface BatchService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): BatchService

    fun betaTrue(): BetaTrueService

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
        params: BatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchCreateResponse

    /**
     * This endpoint is idempotent and can be used to poll for Message Batch completion. To access
     * the results of a Message Batch, make a request to the `results_url` field in the response.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    fun retrieve(
        messageBatchId: String,
        params: BatchRetrieveParams = BatchRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchRetrieveResponse =
        retrieve(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        params: BatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchRetrieveResponse

    /** @see retrieve */
    fun retrieve(messageBatchId: String, requestOptions: RequestOptions): BatchRetrieveResponse =
        retrieve(messageBatchId, BatchRetrieveParams.none(), requestOptions)

    /**
     * List all Message Batches within a Workspace. Most recently created batches are returned
     * first.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    fun list(
        params: BatchListParams = BatchListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchListResponse

    /** @see list */
    fun list(requestOptions: RequestOptions): BatchListResponse =
        list(BatchListParams.none(), requestOptions)

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
        messageBatchId: String,
        params: BatchDeleteParams = BatchDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchDeleteResponse =
        delete(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

    /** @see delete */
    fun delete(
        params: BatchDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchDeleteResponse

    /** @see delete */
    fun delete(messageBatchId: String, requestOptions: RequestOptions): BatchDeleteResponse =
        delete(messageBatchId, BatchDeleteParams.none(), requestOptions)

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
    fun cancel(
        messageBatchId: String,
        params: BatchCancelParams = BatchCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchCancelResponse =
        cancel(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

    /** @see cancel */
    fun cancel(
        params: BatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchCancelResponse

    /** @see cancel */
    fun cancel(messageBatchId: String, requestOptions: RequestOptions): BatchCancelResponse =
        cancel(messageBatchId, BatchCancelParams.none(), requestOptions)

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
    fun cancelBeta(
        messageBatchId: String,
        params: BatchCancelBetaParams = BatchCancelBetaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchCancelBetaResponse =
        cancelBeta(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

    /** @see cancelBeta */
    fun cancelBeta(
        params: BatchCancelBetaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchCancelBetaResponse

    /** @see cancelBeta */
    fun cancelBeta(
        messageBatchId: String,
        requestOptions: RequestOptions,
    ): BatchCancelBetaResponse =
        cancelBeta(messageBatchId, BatchCancelBetaParams.none(), requestOptions)

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
    @MustBeClosed
    fun resultsStreaming(
        messageBatchId: String,
        params: BatchResultsParams = BatchResultsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<BatchResultsResponse> =
        resultsStreaming(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

    /** @see resultsStreaming */
    @MustBeClosed
    fun resultsStreaming(
        params: BatchResultsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<BatchResultsResponse>

    /** @see resultsStreaming */
    @MustBeClosed
    fun resultsStreaming(
        messageBatchId: String,
        requestOptions: RequestOptions,
    ): StreamResponse<BatchResultsResponse> =
        resultsStreaming(messageBatchId, BatchResultsParams.none(), requestOptions)

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
    @MustBeClosed
    fun resultsBetaStreaming(
        messageBatchId: String,
        params: BatchResultsBetaParams = BatchResultsBetaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<BatchResultsBetaResponse> =
        resultsBetaStreaming(
            params.toBuilder().messageBatchId(messageBatchId).build(),
            requestOptions,
        )

    /** @see resultsBetaStreaming */
    @MustBeClosed
    fun resultsBetaStreaming(
        params: BatchResultsBetaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<BatchResultsBetaResponse>

    /** @see resultsBetaStreaming */
    @MustBeClosed
    fun resultsBetaStreaming(
        messageBatchId: String,
        requestOptions: RequestOptions,
    ): StreamResponse<BatchResultsBetaResponse> =
        resultsBetaStreaming(messageBatchId, BatchResultsBetaParams.none(), requestOptions)

    /** A view of [BatchService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: (ClientOptions.Builder) -> Unit): BatchService.WithRawResponse

        fun betaTrue(): BetaTrueService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/messages/batches`, but is otherwise the same as
         * [BatchService.create].
         */
        @MustBeClosed
        fun create(
            params: BatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/messages/batches/{message_batch_id}`, but is
         * otherwise the same as [BatchService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            messageBatchId: String,
            params: BatchRetrieveParams = BatchRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchRetrieveResponse> =
            retrieve(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: BatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            messageBatchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchRetrieveResponse> =
            retrieve(messageBatchId, BatchRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/batches`, but is otherwise the same as
         * [BatchService.list].
         */
        @MustBeClosed
        fun list(
            params: BatchListParams = BatchListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchListResponse>

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<BatchListResponse> =
            list(BatchListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/messages/batches/{message_batch_id}`, but is
         * otherwise the same as [BatchService.delete].
         */
        @MustBeClosed
        fun delete(
            messageBatchId: String,
            params: BatchDeleteParams = BatchDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchDeleteResponse> =
            delete(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: BatchDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(
            messageBatchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchDeleteResponse> =
            delete(messageBatchId, BatchDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batches/{message_batch_id}/cancel`,
         * but is otherwise the same as [BatchService.cancel].
         */
        @MustBeClosed
        fun cancel(
            messageBatchId: String,
            params: BatchCancelParams = BatchCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchCancelResponse> =
            cancel(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            params: BatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchCancelResponse>

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            messageBatchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchCancelResponse> =
            cancel(messageBatchId, BatchCancelParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /v1/messages/batches/{message_batch_id}/cancel?beta=true`, but is otherwise the same as
         * [BatchService.cancelBeta].
         */
        @MustBeClosed
        fun cancelBeta(
            messageBatchId: String,
            params: BatchCancelBetaParams = BatchCancelBetaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchCancelBetaResponse> =
            cancelBeta(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

        /** @see cancelBeta */
        @MustBeClosed
        fun cancelBeta(
            params: BatchCancelBetaParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchCancelBetaResponse>

        /** @see cancelBeta */
        @MustBeClosed
        fun cancelBeta(
            messageBatchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchCancelBetaResponse> =
            cancelBeta(messageBatchId, BatchCancelBetaParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/batches/{message_batch_id}/results`,
         * but is otherwise the same as [BatchService.resultsStreaming].
         */
        @MustBeClosed
        fun resultsStreaming(
            messageBatchId: String,
            params: BatchResultsParams = BatchResultsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<BatchResultsResponse>> =
            resultsStreaming(
                params.toBuilder().messageBatchId(messageBatchId).build(),
                requestOptions,
            )

        /** @see resultsStreaming */
        @MustBeClosed
        fun resultsStreaming(
            params: BatchResultsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<BatchResultsResponse>>

        /** @see resultsStreaming */
        @MustBeClosed
        fun resultsStreaming(
            messageBatchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<BatchResultsResponse>> =
            resultsStreaming(messageBatchId, BatchResultsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /v1/messages/batches/{message_batch_id}/results?beta=true`, but is otherwise the same as
         * [BatchService.resultsBetaStreaming].
         */
        @MustBeClosed
        fun resultsBetaStreaming(
            messageBatchId: String,
            params: BatchResultsBetaParams = BatchResultsBetaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<BatchResultsBetaResponse>> =
            resultsBetaStreaming(
                params.toBuilder().messageBatchId(messageBatchId).build(),
                requestOptions,
            )

        /** @see resultsBetaStreaming */
        @MustBeClosed
        fun resultsBetaStreaming(
            params: BatchResultsBetaParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<BatchResultsBetaResponse>>

        /** @see resultsBetaStreaming */
        @MustBeClosed
        fun resultsBetaStreaming(
            messageBatchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<BatchResultsBetaResponse>> =
            resultsBetaStreaming(messageBatchId, BatchResultsBetaParams.none(), requestOptions)
    }
}
