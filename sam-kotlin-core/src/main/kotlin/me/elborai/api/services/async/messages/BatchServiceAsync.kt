// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async.messages

import com.google.errorprone.annotations.MustBeClosed
import me.elborai.api.core.ClientOptions
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.http.HttpResponseFor
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
import me.elborai.api.models.messages.batches.BatchRetrieveParams
import me.elborai.api.models.messages.batches.BatchRetrieveResponse
import me.elborai.api.services.async.messages.batches.BetaTrueServiceAsync

interface BatchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): BatchServiceAsync

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
    suspend fun retrieve(
        messageBatchId: String,
        params: BatchRetrieveParams = BatchRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchRetrieveResponse =
        retrieve(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: BatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchRetrieveResponse

    /** @see [retrieve] */
    suspend fun retrieve(
        messageBatchId: String,
        requestOptions: RequestOptions,
    ): BatchRetrieveResponse = retrieve(messageBatchId, BatchRetrieveParams.none(), requestOptions)

    /**
     * List all Message Batches within a Workspace. Most recently created batches are returned
     * first.
     *
     * Learn more about the Message Batches API in our
     * [user guide](/en/docs/build-with-claude/batch-processing)
     */
    suspend fun list(
        params: BatchListParams = BatchListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchListResponse

    /** @see [list] */
    suspend fun list(requestOptions: RequestOptions): BatchListResponse =
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
    suspend fun delete(
        messageBatchId: String,
        params: BatchDeleteParams = BatchDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchDeleteResponse =
        delete(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

    /** @see [delete] */
    suspend fun delete(
        params: BatchDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchDeleteResponse

    /** @see [delete] */
    suspend fun delete(
        messageBatchId: String,
        requestOptions: RequestOptions,
    ): BatchDeleteResponse = delete(messageBatchId, BatchDeleteParams.none(), requestOptions)

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
        messageBatchId: String,
        params: BatchCancelParams = BatchCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchCancelResponse =
        cancel(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

    /** @see [cancel] */
    suspend fun cancel(
        params: BatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchCancelResponse

    /** @see [cancel] */
    suspend fun cancel(
        messageBatchId: String,
        requestOptions: RequestOptions,
    ): BatchCancelResponse = cancel(messageBatchId, BatchCancelParams.none(), requestOptions)

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
        messageBatchId: String,
        params: BatchCancelBetaParams = BatchCancelBetaParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchCancelBetaResponse =
        cancelBeta(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

    /** @see [cancelBeta] */
    suspend fun cancelBeta(
        params: BatchCancelBetaParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchCancelBetaResponse

    /** @see [cancelBeta] */
    suspend fun cancelBeta(
        messageBatchId: String,
        requestOptions: RequestOptions,
    ): BatchCancelBetaResponse =
        cancelBeta(messageBatchId, BatchCancelBetaParams.none(), requestOptions)

    /** A view of [BatchServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): BatchServiceAsync.WithRawResponse

        fun betaTrue(): BetaTrueServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/messages/batches`, but is otherwise the same as
         * [BatchServiceAsync.create].
         */
        @MustBeClosed
        suspend fun create(
            params: BatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v1/messages/batches/{message_batch_id}`, but is
         * otherwise the same as [BatchServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            messageBatchId: String,
            params: BatchRetrieveParams = BatchRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchRetrieveResponse> =
            retrieve(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: BatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchRetrieveResponse>

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            messageBatchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchRetrieveResponse> =
            retrieve(messageBatchId, BatchRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v1/messages/batches`, but is otherwise the same as
         * [BatchServiceAsync.list].
         */
        @MustBeClosed
        suspend fun list(
            params: BatchListParams = BatchListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchListResponse>

        /** @see [list] */
        @MustBeClosed
        suspend fun list(requestOptions: RequestOptions): HttpResponseFor<BatchListResponse> =
            list(BatchListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v1/messages/batches/{message_batch_id}`, but is
         * otherwise the same as [BatchServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            messageBatchId: String,
            params: BatchDeleteParams = BatchDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchDeleteResponse> =
            delete(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            params: BatchDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchDeleteResponse>

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            messageBatchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchDeleteResponse> =
            delete(messageBatchId, BatchDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v1/messages/batches/{message_batch_id}/cancel`,
         * but is otherwise the same as [BatchServiceAsync.cancel].
         */
        @MustBeClosed
        suspend fun cancel(
            messageBatchId: String,
            params: BatchCancelParams = BatchCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchCancelResponse> =
            cancel(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

        /** @see [cancel] */
        @MustBeClosed
        suspend fun cancel(
            params: BatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchCancelResponse>

        /** @see [cancel] */
        @MustBeClosed
        suspend fun cancel(
            messageBatchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchCancelResponse> =
            cancel(messageBatchId, BatchCancelParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post
         * /v1/messages/batches/{message_batch_id}/cancel?beta=true`, but is otherwise the same as
         * [BatchServiceAsync.cancelBeta].
         */
        @MustBeClosed
        suspend fun cancelBeta(
            messageBatchId: String,
            params: BatchCancelBetaParams = BatchCancelBetaParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchCancelBetaResponse> =
            cancelBeta(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

        /** @see [cancelBeta] */
        @MustBeClosed
        suspend fun cancelBeta(
            params: BatchCancelBetaParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchCancelBetaResponse>

        /** @see [cancelBeta] */
        @MustBeClosed
        suspend fun cancelBeta(
            messageBatchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BatchCancelBetaResponse> =
            cancelBeta(messageBatchId, BatchCancelBetaParams.none(), requestOptions)
    }
}
