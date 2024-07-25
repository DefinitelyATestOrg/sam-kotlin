// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

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
import software.elborai.api.models.InboundMailItem
import software.elborai.api.models.InboundMailItemList
import software.elborai.api.models.InboundMailItemListPage
import software.elborai.api.models.InboundMailItemListParams
import software.elborai.api.models.InboundMailItemRetrieveParams
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

class InboundMailItemServiceImpl constructor(private val clientOptions: ClientOptions, ) : InboundMailItemService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<InboundMailItem> =
    jsonHandler<InboundMailItem>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve an Inbound Mail Item */
    override fun retrieve(params: InboundMailItemRetrieveParams, requestOptions: RequestOptions): InboundMailItem {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("inbound_mail_items", params.getPathParam(0))
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
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

    private val listHandler: Handler<InboundMailItemListPage.Response> =
    jsonHandler<InboundMailItemListPage.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Inbound Mail Items */
    override fun list(params: InboundMailItemListParams, requestOptions: RequestOptions): InboundMailItemListPage {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("inbound_mail_items")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
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
              InboundMailItemListPage.of(this, params, it)
          }
      }
    }
}
