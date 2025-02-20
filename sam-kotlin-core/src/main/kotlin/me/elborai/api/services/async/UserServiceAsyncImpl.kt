// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.async

import me.elborai.api.core.ClientOptions
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.handlers.emptyHandler
import me.elborai.api.core.handlers.errorHandler
import me.elborai.api.core.handlers.jsonHandler
import me.elborai.api.core.handlers.stringHandler
import me.elborai.api.core.handlers.withErrorHandler
import me.elborai.api.core.http.HttpMethod
import me.elborai.api.core.http.HttpRequest
import me.elborai.api.core.http.HttpResponse.Handler
import me.elborai.api.core.json
import me.elborai.api.core.prepareAsync
import me.elborai.api.errors.SamError
import me.elborai.api.models.User
import me.elborai.api.models.UserCreateListParams
import me.elborai.api.models.UserCreateParams
import me.elborai.api.models.UserDeleteParams
import me.elborai.api.models.UserLoginParams
import me.elborai.api.models.UserLogoutParams
import me.elborai.api.models.UserRetrieveParams
import me.elborai.api.models.UserUpdateParams

class UserServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    UserServiceAsync {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<User> =
        jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** This can only be done by the logged in user. */
    override suspend fun create(params: UserCreateParams, requestOptions: RequestOptions): User {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("user")
                .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                .build()
                .prepareAsync(clientOptions, params)
        val response = clientOptions.httpClient.executeAsync(request, requestOptions)
        return response
            .use { createHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
                }
            }
    }

    private val retrieveHandler: Handler<User> =
        jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Get user by user name */
    override suspend fun retrieve(
        params: UserRetrieveParams,
        requestOptions: RequestOptions,
    ): User {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("user", params.getPathParam(0))
                .build()
                .prepareAsync(clientOptions, params)
        val response = clientOptions.httpClient.executeAsync(request, requestOptions)
        return response
            .use { retrieveHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
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
                .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                .build()
                .prepareAsync(clientOptions, params)
        val response = clientOptions.httpClient.executeAsync(request, requestOptions)
        response.use { updateHandler.handle(it) }
    }

    private val deleteHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /** This can only be done by the logged in user. */
    override suspend fun delete(params: UserDeleteParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("user", params.getPathParam(0))
                .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                .build()
                .prepareAsync(clientOptions, params)
        val response = clientOptions.httpClient.executeAsync(request, requestOptions)
        response.use { deleteHandler.handle(it) }
    }

    private val createListHandler: Handler<User> =
        jsonHandler<User>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates list of users with given input array */
    override suspend fun createList(
        params: UserCreateListParams,
        requestOptions: RequestOptions,
    ): User {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("user", "createWithList")
                .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                .build()
                .prepareAsync(clientOptions, params)
        val response = clientOptions.httpClient.executeAsync(request, requestOptions)
        return response
            .use { createListHandler.handle(it) }
            .also {
                if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                    it.validate()
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
                .build()
                .prepareAsync(clientOptions, params)
        val response = clientOptions.httpClient.executeAsync(request, requestOptions)
        return response.use { loginHandler.handle(it) }
    }

    private val logoutHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /** Logs out current logged in user session */
    override suspend fun logout(params: UserLogoutParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("user", "logout")
                .build()
                .prepareAsync(clientOptions, params)
        val response = clientOptions.httpClient.executeAsync(request, requestOptions)
        response.use { logoutHandler.handle(it) }
    }
}
