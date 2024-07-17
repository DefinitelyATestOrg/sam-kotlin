// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.ProofOfAuthorizationRequestSubmission
import software.elborai.api.models.ProofOfAuthorizationRequestSubmissionCreateParams
import software.elborai.api.models.ProofOfAuthorizationRequestSubmissionListPageAsync
import software.elborai.api.models.ProofOfAuthorizationRequestSubmissionListParams
import software.elborai.api.models.ProofOfAuthorizationRequestSubmissionRetrieveParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class ProofOfAuthorizationRequestSubmissionServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : ProofOfAuthorizationRequestSubmissionServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<ProofOfAuthorizationRequestSubmission> =
        jsonHandler<ProofOfAuthorizationRequestSubmission>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Submit Proof of Authorization */
    override suspend fun create(
        params: ProofOfAuthorizationRequestSubmissionCreateParams,
        requestOptions: RequestOptions
    ): ProofOfAuthorizationRequestSubmission {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("proof_of_authorization_request_submissions")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<ProofOfAuthorizationRequestSubmission> =
        jsonHandler<ProofOfAuthorizationRequestSubmission>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Retrieve a Proof of Authorization Request Submission */
    override suspend fun retrieve(
        params: ProofOfAuthorizationRequestSubmissionRetrieveParams,
        requestOptions: RequestOptions
    ): ProofOfAuthorizationRequestSubmission {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "proof_of_authorization_request_submissions",
                    params.getPathParam(0)
                )
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<ProofOfAuthorizationRequestSubmissionListPageAsync.Response> =
        jsonHandler<ProofOfAuthorizationRequestSubmissionListPageAsync.Response>(
                clientOptions.jsonMapper
            )
            .withErrorHandler(errorHandler)

    /** List Proof of Authorization Request Submissions */
    override suspend fun list(
        params: ProofOfAuthorizationRequestSubmissionListParams,
        requestOptions: RequestOptions
    ): ProofOfAuthorizationRequestSubmissionListPageAsync {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("proof_of_authorization_request_submissions")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { ProofOfAuthorizationRequestSubmissionListPageAsync.of(this, params, it) }
        }
    }
}
