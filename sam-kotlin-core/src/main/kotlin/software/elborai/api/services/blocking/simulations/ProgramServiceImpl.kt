// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking.simulations

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.RequestOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.models.Program
import software.elborai.api.models.SimulationProgramCreateParams
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.withErrorHandler

class ProgramServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : ProgramService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Program> =
        jsonHandler<Program>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Simulates a program being created in your group. By default, your group has one program
     * called Commercial Banking. Note that when your group operates more than one program,
     * `program_id` is a required field when creating accounts.
     */
    override fun create(
        params: SimulationProgramCreateParams,
        requestOptions: RequestOptions
    ): Program {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("simulations", "programs")
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
}
