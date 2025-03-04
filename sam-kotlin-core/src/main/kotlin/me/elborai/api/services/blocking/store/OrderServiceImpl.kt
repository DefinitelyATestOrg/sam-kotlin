// File generated from our OpenAPI spec by Stainless.

package me.elborai.api.services.blocking.store

import me.elborai.api.core.ClientOptions
import me.elborai.api.core.RequestOptions
import me.elborai.api.core.handlers.emptyHandler
import me.elborai.api.core.handlers.errorHandler
import me.elborai.api.core.handlers.jsonHandler
import me.elborai.api.core.handlers.withErrorHandler
import me.elborai.api.core.http.HttpMethod
import me.elborai.api.core.http.HttpRequest
import me.elborai.api.core.http.HttpResponse
import me.elborai.api.core.http.HttpResponse.Handler
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.core.http.json
import me.elborai.api.core.http.parseable
import me.elborai.api.core.prepare
import me.elborai.api.errors.SamError
import me.elborai.api.models.Order
import me.elborai.api.models.StoreOrderDeleteParams
import me.elborai.api.models.StoreOrderRetrieveParams

class OrderServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    OrderService {

    private val withRawResponse: OrderService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): OrderService.WithRawResponse = withRawResponse

    override fun retrieve(params: StoreOrderRetrieveParams, requestOptions: RequestOptions): Order =
        // get /store/order/{orderId}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun delete(params: StoreOrderDeleteParams, requestOptions: RequestOptions) {
        // delete /store/order/{orderId}
        withRawResponse().delete(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OrderService.WithRawResponse {

        private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<Order> =
            jsonHandler<Order>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: StoreOrderRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Order> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("store", "order", params.getPathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

        override fun delete(
            params: StoreOrderDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("store", "order", params.getPathParam(0))
                    .apply { params._body()?.let { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable { response.use { deleteHandler.handle(it) } }
        }
    }
}
