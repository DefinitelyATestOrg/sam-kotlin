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
import software.elborai.api.models.ExternalAccount
import software.elborai.api.models.ExternalAccountCreateParams
import software.elborai.api.models.ExternalAccountListPage
import software.elborai.api.models.ExternalAccountListParams
import software.elborai.api.models.ExternalAccountRetrieveParams
import software.elborai.api.models.ExternalAccountUpdateParams
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

class ExternalAccountServiceImpl constructor(private val clientOptions: ClientOptions, ) : ExternalAccountService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<ExternalAccount> =
    jsonHandler<ExternalAccount>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create an External Account */
    override fun create(params: ExternalAccountCreateParams, requestOptions: RequestOptions): ExternalAccount {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("external_accounts")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
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

    private val retrieveHandler: Handler<ExternalAccount> =
    jsonHandler<ExternalAccount>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve an External Account */
    override fun retrieve(params: ExternalAccountRetrieveParams, requestOptions: RequestOptions): ExternalAccount {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("external_accounts", params.getPathParam(0))
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

    private val updateHandler: Handler<ExternalAccount> =
    jsonHandler<ExternalAccount>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Update an External Account */
    override fun update(params: ExternalAccountUpdateParams, requestOptions: RequestOptions): ExternalAccount {
      val request = HttpRequest.builder()
        .method(HttpMethod.PATCH)
        .addPathSegments("external_accounts", params.getPathParam(0))
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .body(json(clientOptions.jsonMapper, params.getBody()))
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
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

    private val listHandler: Handler<ExternalAccountListPage.Response> =
    jsonHandler<ExternalAccountListPage.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List External Accounts */
    override fun list(params: ExternalAccountListParams, requestOptions: RequestOptions): ExternalAccountListPage {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("external_accounts")
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
              ExternalAccountListPage.of(this, params, it)
          }
      }
    }
}
