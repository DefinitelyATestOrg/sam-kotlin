// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.SamError
import software.elborai.api.models.Order
import software.elborai.api.models.StoreCreateOrderParams
import software.elborai.api.models.StoreInventoryParams
import software.elborai.api.models.StoreInventoryResponse
import software.elborai.api.services.blocking.stores.OrderService
import software.elborai.api.services.blocking.stores.OrderServiceImpl
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class StoreServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : StoreService {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val orders: OrderService by lazy { OrderServiceImpl(clientOptions) }

    override fun orders(): OrderService = orders

    private val createOrderHandler: Handler<Order> =
        jsonHandler<Order>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Place a new order in the store */
    override fun createOrder(
        params: StoreCreateOrderParams,
        requestOptions: RequestOptions
    ): Order {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("store", "order")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { createOrderHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val inventoryHandler: Handler<StoreInventoryResponse> =
        jsonHandler<StoreInventoryResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Returns a map of status codes to quantities */
    override fun inventory(
        params: StoreInventoryParams,
        requestOptions: RequestOptions
    ): StoreInventoryResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("store", "inventory")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { inventoryHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
