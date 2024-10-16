// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.stores

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.handlers.errorHandler
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.SamError

class OrderServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : OrderService {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)
}
