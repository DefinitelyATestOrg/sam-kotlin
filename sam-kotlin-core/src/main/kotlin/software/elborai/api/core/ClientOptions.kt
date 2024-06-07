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
  val authToken: String?,
  val headers: ListMultimap<String, String>,
  val responseValidation: Boolean,

) {

    companion object {

        const val PRODUCTION_URL = "http://localhost:8085/"

        fun builder() = Builder()

        fun fromEnv(): ClientOptions = builder().fromEnv().build()
    }

    class Builder {

        private var httpClient: HttpClient? = null
        private var jsonMapper: JsonMapper? = null
        private var clock: Clock = Clock.systemUTC()
        private var baseUrl: String = PRODUCTION_URL
        private var headers: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var responseValidation: Boolean = false
        private var maxRetries: Int = 2
        private var authToken: String? = null

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

        fun responseValidation(responseValidation: Boolean) = apply {
            this.responseValidation = responseValidation
        }

        fun maxRetries(maxRetries: Int) = apply {
            this.maxRetries = maxRetries
        }

        fun authToken(authToken: String?) = apply {
            this.authToken = authToken
        }

        fun fromEnv() = apply {
            System.getenv("MAVENAGI_AUTH_TOKEN")?.let {
                authToken(it)
            }
        }

        fun build(): ClientOptions {
          checkNotNull(httpClient) {
              "`httpClient` is required but was not set"
          }

          val headers = ArrayListMultimap.create<String, String>()
          headers.put("X-Stainless-Lang", "kotlin")
          headers.put("X-Stainless-Arch", getOsArch())
          headers.put("X-Stainless-OS", getOsName())
          headers.put("X-Stainless-OS-Version", getOsVersion())
          headers.put("X-Stainless-Package-Version", getPackageVersion())
          headers.put("X-Stainless-Runtime-Version", getJavaVersion())
          if (!authToken.isNullOrEmpty()) {
              headers.put("Authorization", "Bearer ${authToken}")
          }
          this.headers.forEach(headers::replaceValues)

          return ClientOptions(
              RetryingHttpClient.builder()
              .httpClient(httpClient!!)
              .clock(clock)
              .maxRetries(maxRetries)
              .build(),
              jsonMapper ?: jsonMapper(),
              clock,
              baseUrl,
              authToken,
              headers.toUnmodifiable(),
              responseValidation,
          )
        }
    }
}
