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
import software.elborai.api.models.EventSubscription
import software.elborai.api.models.EventSubscriptionCreateParams
import software.elborai.api.models.EventSubscriptionListPageAsync
import software.elborai.api.models.EventSubscriptionListParams
import software.elborai.api.models.EventSubscriptionRetrieveParams
import software.elborai.api.models.EventSubscriptionUpdateParams
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

class EventSubscriptionServiceAsyncImpl constructor(private val clientOptions: ClientOptions, ) : EventSubscriptionServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<EventSubscription> =
    jsonHandler<EventSubscription>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create an Event Subscription */
    override suspend fun create(params: EventSubscriptionCreateParams, requestOptions: RequestOptions): EventSubscription {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("event_subscriptions")
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

    private val retrieveHandler: Handler<EventSubscription> =
    jsonHandler<EventSubscription>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve an Event Subscription */
    override suspend fun retrieve(params: EventSubscriptionRetrieveParams, requestOptions: RequestOptions): EventSubscription {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("event_subscriptions", params.getPathParam(0))
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

    private val updateHandler: Handler<EventSubscription> =
    jsonHandler<EventSubscription>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Update an Event Subscription */
    override suspend fun update(params: EventSubscriptionUpdateParams, requestOptions: RequestOptions): EventSubscription {
      val request = HttpRequest.builder()
        .method(HttpMethod.PATCH)
        .addPathSegments("event_subscriptions", params.getPathParam(0))
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.executeAsync(request, requestOptions)
      .let { response -> 
          response.use {
              updateHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val listHandler: Handler<EventSubscriptionListPageAsync.Response> =
    jsonHandler<EventSubscriptionListPageAsync.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Event Subscriptions */
    override suspend fun list(params: EventSubscriptionListParams, requestOptions: RequestOptions): EventSubscriptionListPageAsync {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("event_subscriptions")
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
              EventSubscriptionListPageAsync.of(this, params, it)
          }
      }
    }
}
