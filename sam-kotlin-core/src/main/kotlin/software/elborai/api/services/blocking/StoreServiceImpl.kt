// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.handlers.emptyHandler
import software.elborai.api.core.handlers.errorHandler
import software.elborai.api.core.handlers.jsonHandler
import software.elborai.api.core.handlers.withErrorHandler
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.core.json
import software.elborai.api.errors.SamError
import software.elborai.api.models.Order
import software.elborai.api.models.StoreCreateOrderParams
import software.elborai.api.models.StoreDeleteParams
import software.elborai.api.models.StoreInventoryParams
import software.elborai.api.models.StoreInventoryResponse
import software.elborai.api.models.StoreRetrieveParams
import software.elborai.api.services.blocking.stores.OrderService
import software.elborai.api.services.blocking.stores.OrderServiceImpl

class StoreServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : StoreService {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val orders: OrderService by lazy { OrderServiceImpl(clientOptions) }

    override fun orders(): OrderService = orders

    private val retrieveHandler: Handler<Order> =
        jsonHandler<Order>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * For valid response try integer IDs with value <= 5 or > 10. Other values will generate
     * exceptions.
     */
    override fun retrieve(params: StoreRetrieveParams, requestOptions: RequestOptions): Order {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments("store", "order", params.getPathParam(0))
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

    private val deleteHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

    /**
     * For valid response try integer IDs with value < 1000. Anything above 1000 or nonintegers will
     * generate API errors
     */
    override fun delete(params: StoreDeleteParams, requestOptions: RequestOptions) {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.DELETE)
                .addPathSegments("store", "order", params.getPathParam(0))
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .apply { params.getBody()?.also { body(json(clientOptions.jsonMapper, it)) } }
                .build()
        clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response.use { deleteHandler.handle(it) }
        }
    }

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
