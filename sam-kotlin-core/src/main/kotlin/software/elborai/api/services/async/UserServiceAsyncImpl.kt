// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.SamError
import software.elborai.api.models.User
import software.elborai.api.models.UserCreateParams
import software.elborai.api.models.UserCreateWithListParams
import software.elborai.api.models.UserDeleteParams
import software.elborai.api.models.UserLoginParams
import software.elborai.api.models.UserLogoutParams
import software.elborai.api.models.UserRetrieveParams
import software.elborai.api.models.UserUpdateParams
import software.elborai.api.services.emptyHandler
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.stringHandler
import software.elborai.api.services.withErrorHandler

class UserServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : UserServiceAsync {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /** This can only be done by the logged in user. */
    override suspend fun create(params: UserCreateParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("user")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response.use { createHandler.handle(it) }
        }
    }

    private val retrieveHandler: Handler<User> =
        jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get user by user name */
    override suspend fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions
    ): User {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("user", params.getPathParam(0))
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

    private val updateHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /** This can only be done by the logged in user. */
    override suspend fun update(params: UserUpdateParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.PUT)
                .addPathSegments("user", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response.use { updateHandler.handle(it) }
        }
    }

    private val deleteHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /** This can only be done by the logged in user. */
    override suspend fun delete(params: UserDeleteParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("user", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody()?.also { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response.use { deleteHandler.handle(it) }
        }
    }

    private val createWithListHandler: Handler<User> =
        jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates list of users with given input array */
    override suspend fun createWithList(
        params: UserCreateWithListParams,
        requestOptions: RequestOptions
    ): User {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("user", "createWithList")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response
                .use { createWithListHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val loginHandler: Handler<String> = stringHandler().withErrorHandler(errorHandler)

    /** Logs user into the system */
    override suspend fun login(params: UserLoginParams, requestOptions: RequestOptions): String {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("user", "login")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response.use { loginHandler.handle(it) }
        }
    }

    private val logoutHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /** Logs out current logged in user session */
    override suspend fun logout(params: UserLogoutParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("user", "logout")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).let { response ->
            response.use { logoutHandler.handle(it) }
        }
    }
}
