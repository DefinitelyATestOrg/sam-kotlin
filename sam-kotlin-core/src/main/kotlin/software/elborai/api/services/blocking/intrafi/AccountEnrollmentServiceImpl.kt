// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.intrafi

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.IntrafiAccountEnrollment
import software.elborai.api.models.IntrafiAccountEnrollmentCreateParams
import software.elborai.api.models.IntrafiAccountEnrollmentListPage
import software.elborai.api.models.IntrafiAccountEnrollmentListParams
import software.elborai.api.models.IntrafiAccountEnrollmentRetrieveParams
import software.elborai.api.models.IntrafiAccountEnrollmentUnenrollParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class AccountEnrollmentServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : AccountEnrollmentService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<IntrafiAccountEnrollment> =
        jsonHandler<IntrafiAccountEnrollment>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Enroll an account in the IntraFi deposit sweep network. */
    override fun create(
        params: IntrafiAccountEnrollmentCreateParams,
        requestOptions: RequestOptions
    ): IntrafiAccountEnrollment {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("intrafi_account_enrollments")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val retrieveHandler: Handler<IntrafiAccountEnrollment> =
        jsonHandler<IntrafiAccountEnrollment>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Get an IntraFi Account Enrollment */
    override fun retrieve(
        params: IntrafiAccountEnrollmentRetrieveParams,
        requestOptions: RequestOptions
    ): IntrafiAccountEnrollment {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("intrafi_account_enrollments", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<IntrafiAccountEnrollmentListPage.Response> =
        jsonHandler<IntrafiAccountEnrollmentListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List IntraFi Account Enrollments */
    override fun list(
        params: IntrafiAccountEnrollmentListParams,
        requestOptions: RequestOptions
    ): IntrafiAccountEnrollmentListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("intrafi_account_enrollments")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { IntrafiAccountEnrollmentListPage.of(this, params, it) }
        }
    }

    private val unenrollHandler: Handler<IntrafiAccountEnrollment> =
        jsonHandler<IntrafiAccountEnrollment>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Unenroll an account from IntraFi. */
    override fun unenroll(
        params: IntrafiAccountEnrollmentUnenrollParams,
        requestOptions: RequestOptions
    ): IntrafiAccountEnrollment {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("intrafi_account_enrollments", params.getPathParam(0), "unenroll")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody()?.also { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { unenrollHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
