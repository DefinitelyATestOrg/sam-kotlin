// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async.simulations

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import kotlin.LazyThreadSafetyMode.PUBLICATION
import java.time.LocalDate
import java.time.Duration
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Base64
import java.util.Optional
import java.util.UUID
import java.util.concurrent.CompletableFuture
import java.util.stream.Stream
import software.elborai.api.core.Enum
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.errors.IncreaseInvalidDataException
import software.elborai.api.models.CheckDeposit
import software.elborai.api.models.SimulationCheckDepositRejectParams
import software.elborai.api.models.SimulationCheckDepositReturnParams
import software.elborai.api.models.SimulationCheckDepositSubmitParams
import software.elborai.api.core.ClientOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.core.http.BinaryResponseContent
import software.elborai.api.core.JsonField
import software.elborai.api.core.JsonValue
import software.elborai.api.core.RequestOptions
import software.elborai.api.errors.IncreaseError
import software.elborai.api.services.emptyHandler
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.multipartFormData
import software.elborai.api.services.stringHandler
import software.elborai.api.services.binaryHandler
import software.elborai.api.services.withErrorHandler

class CheckDepositServiceAsyncImpl constructor(private val clientOptions: ClientOptions, ) : CheckDepositServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val rejectHandler: Handler<CheckDeposit> =
    jsonHandler<CheckDeposit>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Simulates the rejection of a [Check Deposit](#check-deposits) by Increase due to
     * factors like poor image quality. This Check Deposit must first have a `status`
     * of `pending`.
     */
    override suspend fun reject(params: SimulationCheckDepositRejectParams, requestOptions: RequestOptions): CheckDeposit {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("simulations", "check_deposits", params.getPathParam(0), "reject")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .apply {
            params.getBody()?.also {
                body(json(clientOptions.jsonMapper, it))
            }
        }
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              rejectHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val returnHandler: Handler<CheckDeposit> =
    jsonHandler<CheckDeposit>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Simulates the return of a [Check Deposit](#check-deposits). This Check Deposit
     * must first have a `status` of `submitted`.
     */
    override suspend fun return_(params: SimulationCheckDepositReturnParams, requestOptions: RequestOptions): CheckDeposit {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("simulations", "check_deposits", params.getPathParam(0), "return")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .apply {
            params.getBody()?.also {
                body(json(clientOptions.jsonMapper, it))
            }
        }
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              returnHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val submitHandler: Handler<CheckDeposit> =
    jsonHandler<CheckDeposit>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Simulates the submission of a [Check Deposit](#check-deposits) to the Federal
     * Reserve. This Check Deposit must first have a `status` of `pending`.
     */
    override suspend fun submit(params: SimulationCheckDepositSubmitParams, requestOptions: RequestOptions): CheckDeposit {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("simulations", "check_deposits", params.getPathParam(0), "submit")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .apply {
            params.getBody()?.also {
                body(json(clientOptions.jsonMapper, it))
            }
        }
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              submitHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
