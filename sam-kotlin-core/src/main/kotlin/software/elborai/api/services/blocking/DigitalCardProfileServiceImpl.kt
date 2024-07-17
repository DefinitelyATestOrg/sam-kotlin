// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.DigitalCardProfile
import software.elborai.api.models.DigitalCardProfileArchiveParams
import software.elborai.api.models.DigitalCardProfileCloneParams
import software.elborai.api.models.DigitalCardProfileCreateParams
import software.elborai.api.models.DigitalCardProfileListPage
import software.elborai.api.models.DigitalCardProfileListParams
import software.elborai.api.models.DigitalCardProfileRetrieveParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class DigitalCardProfileServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : DigitalCardProfileService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<DigitalCardProfile> =
        jsonHandler<DigitalCardProfile>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Create a Digital Card Profile */
    override fun create(
        params: DigitalCardProfileCreateParams,
        requestOptions: RequestOptions
    ): DigitalCardProfile {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("digital_card_profiles")
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

    private val retrieveHandler: Handler<DigitalCardProfile> =
        jsonHandler<DigitalCardProfile>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieve a Digital Card Profile */
    override fun retrieve(
        params: DigitalCardProfileRetrieveParams,
        requestOptions: RequestOptions
    ): DigitalCardProfile {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("digital_card_profiles", params.getPathParam(0))
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

    private val listHandler: Handler<DigitalCardProfileListPage.Response> =
        jsonHandler<DigitalCardProfileListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** List Card Profiles */
    override fun list(
        params: DigitalCardProfileListParams,
        requestOptions: RequestOptions
    ): DigitalCardProfileListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("digital_card_profiles")
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
                .let { DigitalCardProfileListPage.of(this, params, it) }
        }
    }

    private val archiveHandler: Handler<DigitalCardProfile> =
        jsonHandler<DigitalCardProfile>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Archive a Digital Card Profile */
    override fun archive(
        params: DigitalCardProfileArchiveParams,
        requestOptions: RequestOptions
    ): DigitalCardProfile {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("digital_card_profiles", params.getPathParam(0), "archive")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody()?.also { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { archiveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val cloneHandler: Handler<DigitalCardProfile> =
        jsonHandler<DigitalCardProfile>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Clones a Digital Card Profile */
    override fun clone(
        params: DigitalCardProfileCloneParams,
        requestOptions: RequestOptions
    ): DigitalCardProfile {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("digital_card_profiles", params.getPathParam(0), "clone")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { cloneHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
