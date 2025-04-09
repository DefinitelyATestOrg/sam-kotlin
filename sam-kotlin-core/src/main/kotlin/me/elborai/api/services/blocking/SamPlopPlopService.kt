// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.models.samplopplop.SamPlopPlopCreateMessageParams
import me.elborai.api.models.samplopplop.SamPlopPlopCreateMessageResponse

interface SamPlopPlopService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Send a structured list of input messages with text and/or image content, and the model will
     * generate the next message in the conversation.
     *
     * The Messages API can be used for either single queries or stateless multi-turn conversations.
     *
     * Learn more about the Messages API in our [user guide](/en/docs/initial-setup)
     */
    fun createMessage(
        params: SamPlopPlopCreateMessageParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SamPlopPlopCreateMessageResponse

    /**
     * A view of [SamPlopPlopService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /v1/sam-plop-plop`, but is otherwise the same as
         * [SamPlopPlopService.createMessage].
         */
        @MustBeClosed
        fun createMessage(
            params: SamPlopPlopCreateMessageParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SamPlopPlopCreateMessageResponse>
    }
}
