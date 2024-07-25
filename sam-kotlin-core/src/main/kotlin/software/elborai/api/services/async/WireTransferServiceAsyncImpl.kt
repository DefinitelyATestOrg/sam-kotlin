// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

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
import software.elborai.api.models.WireTransfer
import software.elborai.api.models.WireTransferApproveParams
import software.elborai.api.models.WireTransferCancelParams
import software.elborai.api.models.WireTransferCreateParams
import software.elborai.api.models.WireTransferListPageAsync
import software.elborai.api.models.WireTransferListParams
import software.elborai.api.models.WireTransferRetrieveParams
import software.elborai.api.models.WireTransferReverseParams
import software.elborai.api.models.WireTransferSubmitParams
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

class WireTransferServiceAsyncImpl constructor(private val clientOptions: ClientOptions, ) : WireTransferServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<WireTransfer> =
    jsonHandler<WireTransfer>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create a Wire Transfer */
    override suspend fun create(params: WireTransferCreateParams, requestOptions: RequestOptions): WireTransfer {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("wire_transfers")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              createHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val retrieveHandler: Handler<WireTransfer> =
    jsonHandler<WireTransfer>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve a Wire Transfer */
    override suspend fun retrieve(params: WireTransferRetrieveParams, requestOptions: RequestOptions): WireTransfer {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("wire_transfers", params.getPathParam(0))
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              retrieveHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val listHandler: Handler<WireTransferListPageAsync.Response> =
    jsonHandler<WireTransferListPageAsync.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Wire Transfers */
    override suspend fun list(params: WireTransferListParams, requestOptions: RequestOptions): WireTransferListPageAsync {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("wire_transfers")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              listHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
          .let {
              WireTransferListPageAsync.of(this, params, it)
          }
      }
    }

    private val approveHandler: Handler<WireTransfer> =
    jsonHandler<WireTransfer>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Approve a Wire Transfer */
    override suspend fun approve(params: WireTransferApproveParams, requestOptions: RequestOptions): WireTransfer {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("wire_transfers", params.getPathParam(0), "approve")
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
              approveHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val cancelHandler: Handler<WireTransfer> =
    jsonHandler<WireTransfer>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Cancel a pending Wire Transfer */
    override suspend fun cancel(params: WireTransferCancelParams, requestOptions: RequestOptions): WireTransfer {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("wire_transfers", params.getPathParam(0), "cancel")
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
              cancelHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val reverseHandler: Handler<WireTransfer> =
    jsonHandler<WireTransfer>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Simulates the reversal of a [Wire Transfer](#wire-transfers) by the Federal
     * Reserve due to error conditions. This will also create a
     * [Transaction](#transaction) to account for the returned funds. This Wire
     * Transfer must first have a `status` of `complete`.
     */
    override suspend fun reverse(params: WireTransferReverseParams, requestOptions: RequestOptions): WireTransfer {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("simulations", "wire_transfers", params.getPathParam(0), "reverse")
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
              reverseHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val submitHandler: Handler<WireTransfer> =
    jsonHandler<WireTransfer>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /**
     * Simulates the submission of a [Wire Transfer](#wire-transfers) to the Federal
     * Reserve. This transfer must first have a `status` of `pending_approval` or
     * `pending_creating`.
     */
    override suspend fun submit(params: WireTransferSubmitParams, requestOptions: RequestOptions): WireTransfer {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("simulations", "wire_transfers", params.getPathParam(0), "submit")
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
