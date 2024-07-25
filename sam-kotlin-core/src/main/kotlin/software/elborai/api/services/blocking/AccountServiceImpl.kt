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
import software.elborai.api.models.Account
import software.elborai.api.models.AccountBalanceParams
import software.elborai.api.models.AccountCloseParams
import software.elborai.api.models.AccountCreateParams
import software.elborai.api.models.AccountListPage
import software.elborai.api.models.AccountListParams
import software.elborai.api.models.AccountRetrieveParams
import software.elborai.api.models.AccountUpdateParams
import software.elborai.api.models.BalanceLookup
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

class AccountServiceImpl constructor(private val clientOptions: ClientOptions, ) : AccountService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Account> =
    jsonHandler<Account>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Create an Account */
    override fun create(params: AccountCreateParams, requestOptions: RequestOptions): Account {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("accounts")
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

    private val retrieveHandler: Handler<Account> =
    jsonHandler<Account>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve an Account */
    override fun retrieve(params: AccountRetrieveParams, requestOptions: RequestOptions): Account {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("accounts", params.getPathParam(0))
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

    private val updateHandler: Handler<Account> =
    jsonHandler<Account>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Update an Account */
    override fun update(params: AccountUpdateParams, requestOptions: RequestOptions): Account {
      val request = HttpRequest.builder()
        .method(HttpMethod.PATCH)
        .addPathSegments("accounts", params.getPathParam(0))
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

    private val listHandler: Handler<AccountListPage.Response> =
    jsonHandler<AccountListPage.Response>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** List Accounts */
    override fun list(params: AccountListParams, requestOptions: RequestOptions): AccountListPage {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("accounts")
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
              AccountListPage.of(this, params, it)
          }
      }
    }

    private val balanceHandler: Handler<BalanceLookup> =
    jsonHandler<BalanceLookup>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Retrieve an Account Balance */
    override fun balance(params: AccountBalanceParams, requestOptions: RequestOptions): BalanceLookup {
      val request = HttpRequest.builder()
        .method(HttpMethod.GET)
        .addPathSegments("accounts", params.getPathParam(0), "balance")
        .putAllQueryParams(clientOptions.queryParams)
        .putAllQueryParams(params.getQueryParams())
        .putAllHeaders(clientOptions.headers)
        .putAllHeaders(params.getHeaders())
        .build()
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              balanceHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }

    private val closeHandler: Handler<Account> =
    jsonHandler<Account>(clientOptions.jsonMapper)
    .withErrorHandler(errorHandler)

    /** Close an Account */
    override fun close(params: AccountCloseParams, requestOptions: RequestOptions): Account {
      val request = HttpRequest.builder()
        .method(HttpMethod.POST)
        .addPathSegments("accounts", params.getPathParam(0), "close")
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
      return clientOptions.httpClient.execute(request, requestOptions)
      .let { response -> 
          response.use {
              closeHandler.handle(it)
          }
          .apply  {
              if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                validate()
              }
          }
      }
    }
}
