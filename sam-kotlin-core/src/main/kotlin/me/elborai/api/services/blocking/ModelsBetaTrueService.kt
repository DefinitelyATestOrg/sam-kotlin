// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import me.elborai.api.core.ClientOptions
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.models.modelsbetatrue.ModelsBetaTrueListParams
import me.elborai.api.models.modelsbetatrue.ModelsBetaTrueListResponse

interface ModelsBetaTrueService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: (ClientOptions.Builder) -> Unit): ModelsBetaTrueService

    /**
     * List available models.
     *
     * The Models API response can be used to determine which models are available for use in the
     * API. More recently released models are listed first.
     */
    fun list(
        params: ModelsBetaTrueListParams = ModelsBetaTrueListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ModelsBetaTrueListResponse

    /** @see list */
    fun list(requestOptions: RequestOptions): ModelsBetaTrueListResponse =
        list(ModelsBetaTrueListParams.none(), requestOptions)

    /**
     * A view of [ModelsBetaTrueService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: (ClientOptions.Builder) -> Unit
        ): ModelsBetaTrueService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /v1/models?beta=true`, but is otherwise the same as
         * [ModelsBetaTrueService.list].
         */
        @MustBeClosed
        fun list(
            params: ModelsBetaTrueListParams = ModelsBetaTrueListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ModelsBetaTrueListResponse>

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<ModelsBetaTrueListResponse> =
            list(ModelsBetaTrueListParams.none(), requestOptions)
    }
}
