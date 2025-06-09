// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async.messages.batches

import com.google.errorprone.annotations.MustBeClosed
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.models.messages.batches.betatrue.BetaTrueDeleteParams
import me.elborai.api.models.messages.batches.betatrue.BetaTrueDeleteResponse
import me.elborai.api.models.messages.batches.betatrue.BetaTrueRetrieveParams
import me.elborai.api.models.messages.batches.betatrue.BetaTrueRetrieveResponse

interface BetaTrueServiceAsync {

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
    suspend fun retrieve(
        messageBatchId: String,
        params: BetaTrueRetrieveParams = BetaTrueRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaTrueRetrieveResponse =
        retrieve(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

    /** @see [retrieve] */
    suspend fun retrieve(
        params: BetaTrueRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaTrueRetrieveResponse

    /** @see [retrieve] */
    suspend fun retrieve(
        messageBatchId: String,
        requestOptions: RequestOptions,
    ): BetaTrueRetrieveResponse =
        retrieve(messageBatchId, BetaTrueRetrieveParams.none(), requestOptions)

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
        params: BetaTrueDeleteParams = BetaTrueDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaTrueDeleteResponse =
        delete(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

    /** @see [delete] */
    suspend fun delete(
        params: BetaTrueDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaTrueDeleteResponse

    /** @see [delete] */
    suspend fun delete(
        messageBatchId: String,
        requestOptions: RequestOptions,
    ): BetaTrueDeleteResponse = delete(messageBatchId, BetaTrueDeleteParams.none(), requestOptions)

    /**
     * A view of [BetaTrueServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /v1/messages/batches/{message_batch_id}?beta=true`,
         * but is otherwise the same as [BetaTrueServiceAsync.retrieve].
         */
        @MustBeClosed
        suspend fun retrieve(
            messageBatchId: String,
            params: BetaTrueRetrieveParams = BetaTrueRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaTrueRetrieveResponse> =
            retrieve(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            params: BetaTrueRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaTrueRetrieveResponse>

        /** @see [retrieve] */
        @MustBeClosed
        suspend fun retrieve(
            messageBatchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BetaTrueRetrieveResponse> =
            retrieve(messageBatchId, BetaTrueRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /v1/messages/batches/{message_batch_id}?beta=true`, but is otherwise the same as
         * [BetaTrueServiceAsync.delete].
         */
        @MustBeClosed
        suspend fun delete(
            messageBatchId: String,
            params: BetaTrueDeleteParams = BetaTrueDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaTrueDeleteResponse> =
            delete(params.toBuilder().messageBatchId(messageBatchId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            params: BetaTrueDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaTrueDeleteResponse>

        /** @see [delete] */
        @MustBeClosed
        suspend fun delete(
            messageBatchId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BetaTrueDeleteResponse> =
            delete(messageBatchId, BetaTrueDeleteParams.none(), requestOptions)
    }
}
