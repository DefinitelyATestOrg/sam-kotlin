// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.core

import com.fasterxml.jackson.databind.json.JsonMapper
import com.google.common.collect.Multimap
import com.google.common.collect.ListMultimap
import com.google.common.collect.ArrayListMultimap
import java.time.Clock
import java.util.Base64
import software.elborai.api.core.http.HttpClient
import software.elborai.api.core.http.RetryingHttpClient

class ClientOptions private constructor(
  val httpClient: HttpClient,
  val jsonMapper: JsonMapper,
  val clock: Clock,
  val baseUrl: String,
  val apiKey: String,
  val webhookSecret: String?,
  val headers: ListMultimap<String, String>,
  val queryParams: ListMultimap<String, String>,
  val responseValidation: Boolean,

) {

    companion object {

        const val PRODUCTION_URL = "https://api.increase.com"

        const val SANDBOX_URL = "https://sandbox.increase.com"

        fun builder() = Builder()

        fun fromEnv(): ClientOptions = builder().fromEnv().build()
    }

    class Builder {

        private var httpClient: HttpClient? = null
        private var jsonMapper: JsonMapper? = null
        private var clock: Clock = Clock.systemUTC()
        private var baseUrl: String = PRODUCTION_URL
        private var headers: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var queryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var responseValidation: Boolean = false
        private var maxRetries: Int = 2
        private var apiKey: String? = null
        private var webhookSecret: String? = null

        fun httpClient(httpClient: HttpClient) = apply {
            this.httpClient = httpClient
        }

        fun jsonMapper(jsonMapper: JsonMapper) = apply {
            this.jsonMapper = jsonMapper
        }

        fun baseUrl(baseUrl: String) = apply {
            this.baseUrl = baseUrl
        }

        fun clock(clock: Clock) = apply {
            this.clock = clock
        }

        fun headers(headers: Map<String, Iterable<String>>) = apply {
            this.headers.clear()
            putAllHeaders(headers)
        }

        fun putHeader(name: String, value: String) = apply {
            this.headers.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.headers.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(headers: Map<String, Iterable<String>>) = apply {
            headers.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply {
            this.headers.put(name, mutableListOf())
        }

        fun queryParams(queryParams: Map<String, Iterable<String>>) = apply {
            this.queryParams.clear()
            putAllQueryParams(queryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.queryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.queryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(queryParams: Map<String, Iterable<String>>) = apply {
            queryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.queryParams.put(name, mutableListOf())
        }

        fun responseValidation(responseValidation: Boolean) = apply {
            this.responseValidation = responseValidation
        }

        fun maxRetries(maxRetries: Int) = apply {
            this.maxRetries = maxRetries
        }

        fun apiKey(apiKey: String) = apply {
            this.apiKey = apiKey
        }

        fun webhookSecret(webhookSecret: String?) = apply {
            this.webhookSecret = webhookSecret
        }

        fun fromEnv() = apply {
            System.getenv("INCREASE_API_KEY")?.let {
                apiKey(it)
            }
            System.getenv("INCREASE_WEBHOOK_SECRET")?.let {
                webhookSecret(it)
            }
        }

        fun build(): ClientOptions {
          checkNotNull(httpClient) {
              "`httpClient` is required but was not set"
          }
          checkNotNull(apiKey) {
              "`apiKey` is required but was not set"
          }

          val headers = ArrayListMultimap.create<String, String>()
          val queryParams = ArrayListMultimap.create<String, String>()
          headers.put("X-Stainless-Lang", "kotlin")
          headers.put("X-Stainless-Arch", getOsArch())
          headers.put("X-Stainless-OS", getOsName())
          headers.put("X-Stainless-OS-Version", getOsVersion())
          headers.put("X-Stainless-Package-Version", getPackageVersion())
          headers.put("X-Stainless-Runtime-Version", getJavaVersion())
          if (!apiKey.isNullOrEmpty()) {
              headers.put("Authorization", "Bearer ${apiKey}")
          }
          this.headers.forEach(headers::replaceValues)
          this.queryParams.forEach(queryParams::replaceValues)

          return ClientOptions(
              RetryingHttpClient.builder()
              .httpClient(httpClient!!)
              .clock(clock)
              .maxRetries(maxRetries)
              .idempotencyHeader("Idempotency-Key")
              .build(),
              jsonMapper ?: jsonMapper(),
              clock,
              baseUrl,
              apiKey!!,
              webhookSecret,
              headers.toUnmodifiable(),
              queryParams.toUnmodifiable(),
              responseValidation,
          )
        }
    }
}
