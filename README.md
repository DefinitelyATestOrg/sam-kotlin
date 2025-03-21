# Sam Kotlin API Library

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/me.elborai.api/sam-kotlin)](https://central.sonatype.com/artifact/me.elborai.api/sam-kotlin/0.1.0-alpha.1)
[![javadoc](https://javadoc.io/badge2/me.elborai.api/sam-kotlin/0.1.0-alpha.1/javadoc.svg)](https://javadoc.io/doc/me.elborai.api/sam-kotlin/0.1.0-alpha.1)

<!-- x-release-please-end -->

The Sam Kotlin SDK provides convenient access to the Sam REST API from applications written in Kotlin.

It is generated with [Stainless](https://www.stainless.com/).

<!-- x-release-please-start-version -->

The REST API documentation can be found on [docs.sam.com](https://docs.sam.com). KDocs are also available on [javadoc.io](https://javadoc.io/doc/me.elborai.api/sam-kotlin/0.1.0-alpha.1).

<!-- x-release-please-end -->

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("me.elborai.api:sam-kotlin:0.1.0-alpha.1")
```

### Maven

```xml
<dependency>
    <groupId>me.elborai.api</groupId>
    <artifactId>sam-kotlin</artifactId>
    <version>0.1.0-alpha.1</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

```kotlin
import me.elborai.api.client.SamClient
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.models.messages.MessageCreateParams
import me.elborai.api.models.messages.MessageCreateResponse

// Configures using the `API_KEY` environment variable
val client: SamClient = SamOkHttpClient.fromEnv()

val params: MessageCreateParams = MessageCreateParams.builder()
    .maxTokens(1024L)
    .addMessage(MessageCreateParams.Message.builder()
        .content("Hello, world")
        .role(MessageCreateParams.Message.Role.USER)
        .build())
    .model("claude-3-7-sonnet-20250219")
    .build()
val message: MessageCreateResponse = client.messages().create(params)
```

## Client configuration

Configure the client using environment variables:

```kotlin
import me.elborai.api.client.SamClient
import me.elborai.api.client.okhttp.SamOkHttpClient

// Configures using the `API_KEY` environment variable
val client: SamClient = SamOkHttpClient.fromEnv()
```

Or manually:

```kotlin
import me.elborai.api.client.SamClient
import me.elborai.api.client.okhttp.SamOkHttpClient

val client: SamClient = SamOkHttpClient.builder()
    .apiKey("My API Key")
    .build()
```

Or using a combination of the two approaches:

```kotlin
import me.elborai.api.client.SamClient
import me.elborai.api.client.okhttp.SamOkHttpClient

val client: SamClient = SamOkHttpClient.builder()
    // Configures using the `API_KEY` environment variable
    .fromEnv()
    .apiKey("My API Key")
    .build()
```

See this table for the available options:

| Setter   | Environment variable | Required | Default value |
| -------- | -------------------- | -------- | ------------- |
| `apiKey` | `API_KEY`            | true     | -             |

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

## Requests and responses

To send a request to the Sam API, build an instance of some `Params` class and pass it to the corresponding client method. When the response is received, it will be deserialized into an instance of a Kotlin class.

For example, `client.messages().create(...)` should be called with an instance of `MessageCreateParams`, and it will return an instance of `MessageCreateResponse`.

## Immutability

Each class in the SDK has an associated [builder](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java) or factory method for constructing it.

Each class is [immutable](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html) once constructed. If the class has an associated builder, then it has a `toBuilder()` method, which can be used to convert it back to a builder for making a modified copy.

Because each class is immutable, builder modification will _never_ affect already built class instances.

## Asynchronous execution

The default client is synchronous. To switch to asynchronous execution, call the `async()` method:

```kotlin
import me.elborai.api.client.SamClient
import me.elborai.api.client.okhttp.SamOkHttpClient
import me.elborai.api.models.messages.MessageCreateParams
import me.elborai.api.models.messages.MessageCreateResponse

// Configures using the `API_KEY` environment variable
val client: SamClient = SamOkHttpClient.fromEnv()

val params: MessageCreateParams = MessageCreateParams.builder()
    .maxTokens(1024L)
    .addMessage(MessageCreateParams.Message.builder()
        .content("Hello, world")
        .role(MessageCreateParams.Message.Role.USER)
        .build())
    .model("claude-3-7-sonnet-20250219")
    .build()
val message: MessageCreateResponse = client.async().messages().create(params)
```

Or create an asynchronous client from the beginning:

```kotlin
import me.elborai.api.client.SamClientAsync
import me.elborai.api.client.okhttp.SamOkHttpClientAsync
import me.elborai.api.models.messages.MessageCreateParams
import me.elborai.api.models.messages.MessageCreateResponse

// Configures using the `API_KEY` environment variable
val client: SamClientAsync = SamOkHttpClientAsync.fromEnv()

val params: MessageCreateParams = MessageCreateParams.builder()
    .maxTokens(1024L)
    .addMessage(MessageCreateParams.Message.builder()
        .content("Hello, world")
        .role(MessageCreateParams.Message.Role.USER)
        .build())
    .model("claude-3-7-sonnet-20250219")
    .build()
val message: MessageCreateResponse = client.messages().create(params)
```

The asynchronous client supports the same options as the synchronous one, except most methods are [suspending](https://kotlinlang.org/docs/coroutines-guide.html).

## Raw responses

The SDK defines methods that deserialize responses into instances of Kotlin classes. However, these methods don't provide access to the response headers, status code, or the raw response body.

To access this data, prefix any HTTP method call on a client or service with `withRawResponse()`:

```kotlin
import me.elborai.api.core.http.Headers
import me.elborai.api.core.http.HttpResponseFor
import me.elborai.api.models.messages.MessageCreateParams
import me.elborai.api.models.messages.MessageCreateResponse

val params: MessageCreateParams = MessageCreateParams.builder()
    .maxTokens(1024L)
    .addMessage(MessageCreateParams.Message.builder()
        .content("Hello, world")
        .role(MessageCreateParams.Message.Role.USER)
        .build())
    .model("claude-3-7-sonnet-20250219")
    .build()
val message: HttpResponseFor<MessageCreateResponse> = client.messages().withRawResponse().create(params)

val statusCode: Int = message.statusCode()
val headers: Headers = message.headers()
```

You can still deserialize the response into an instance of a Kotlin class if needed:

```kotlin
import me.elborai.api.models.messages.MessageCreateResponse

val parsedMessage: MessageCreateResponse = message.parse()
```

## Error handling

The SDK throws custom unchecked exception types:

- [`SamServiceException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/SamServiceException.kt): Base class for HTTP errors. See this table for which exception subclass is thrown for each HTTP status code:

  | Status | Exception                                                                                                                 |
  | ------ | ------------------------------------------------------------------------------------------------------------------------- |
  | 400    | [`BadRequestException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/BadRequestException.kt)                     |
  | 401    | [`UnauthorizedException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/UnauthorizedException.kt)                 |
  | 403    | [`PermissionDeniedException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/PermissionDeniedException.kt)         |
  | 404    | [`NotFoundException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/NotFoundException.kt)                         |
  | 422    | [`UnprocessableEntityException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/UnprocessableEntityException.kt)   |
  | 429    | [`RateLimitException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/RateLimitException.kt)                       |
  | 5xx    | [`InternalServerException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/InternalServerException.kt)             |
  | others | [`UnexpectedStatusCodeException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/UnexpectedStatusCodeException.kt) |

- [`SamIoException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/SamIoException.kt): I/O networking errors.

- [`SamInvalidDataException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/SamInvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`SamException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/SamException.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `SAM_LOG` environment variable to `info`:

```sh
$ export SAM_LOG=info
```

Or to `debug` for more verbose logging:

```sh
$ export SAM_LOG=debug
```

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a response.

To set a custom number of retries, configure the client using the `maxRetries` method:

```kotlin
import me.elborai.api.client.SamClient
import me.elborai.api.client.okhttp.SamOkHttpClient

val client: SamClient = SamOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build()
```

### Timeouts

Requests time out after 1 minute by default.

To set a custom timeout, configure the method call using the `timeout` method:

```kotlin
import me.elborai.api.models.messages.MessageCreateParams
import me.elborai.api.models.messages.MessageCreateResponse

val message: MessageCreateResponse = client.messages().create(
  params, RequestOptions.builder().timeout(Duration.ofSeconds(30)).build()
)
```

Or configure the default for all method calls at the client level:

```kotlin
import java.time.Duration
import me.elborai.api.client.SamClient
import me.elborai.api.client.okhttp.SamOkHttpClient

val client: SamClient = SamOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build()
```

### Proxies

To route requests through a proxy, configure the client using the `proxy` method:

```kotlin
import java.net.InetSocketAddress
import java.net.Proxy
import me.elborai.api.client.SamClient
import me.elborai.api.client.okhttp.SamOkHttpClient

val client: SamClient = SamOkHttpClient.builder()
    .fromEnv()
    .proxy(Proxy(
      Proxy.Type.HTTP, InetSocketAddress(
        "https://example.com", 8080
      )
    ))
    .build()
```

## Undocumented API functionality

The SDK is typed for convenient usage of the documented API. However, it also supports working with undocumented or not yet supported parts of the API.

### Parameters

To set undocumented parameters, call the `putAdditionalHeader`, `putAdditionalQueryParam`, or `putAdditionalBodyProperty` methods on any `Params` class:

```kotlin
import me.elborai.api.core.JsonValue
import me.elborai.api.models.messages.MessageCreateParams

val params: MessageCreateParams = MessageCreateParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build()
```

These can be accessed on the built object later using the `_additionalHeaders()`, `_additionalQueryParams()`, and `_additionalBodyProperties()` methods.

To set undocumented parameters on _nested_ headers, query params, or body classes, call the `putAdditionalProperty` method on the nested class:

```kotlin
import me.elborai.api.core.JsonValue
import me.elborai.api.models.messages.MessageCreateParams

val params: MessageCreateParams = MessageCreateParams.builder()
    .metadata(MessageCreateParams.Metadata.builder()
        .putAdditionalProperty("secretProperty", JsonValue.from("42"))
        .build())
    .build()
```

These properties can be accessed on the nested built object later using the `_additionalProperties()` method.

To set a documented parameter or property to an undocumented or not yet supported _value_, pass a [`JsonValue`](sam-kotlin-core/src/main/kotlin/me/elborai/api/core/Values.kt) object to its setter:

```kotlin
import me.elborai.api.models.messages.MessageCreateParams

val params: MessageCreateParams = MessageCreateParams.builder()
    .maxTokens(1024L)
    .addMessage(MessageCreateParams.Message.builder()
        .content("Hello, world")
        .role(MessageCreateParams.Message.Role.USER)
        .build())
    .model("claude-3-7-sonnet-20250219")
    .build()
```

The most straightforward way to create a [`JsonValue`](sam-kotlin-core/src/main/kotlin/me/elborai/api/core/Values.kt) is using its `from(...)` method:

```kotlin
import me.elborai.api.core.JsonValue

// Create primitive JSON values
val nullValue: JsonValue = JsonValue.from(null)
val booleanValue: JsonValue = JsonValue.from(true)
val numberValue: JsonValue = JsonValue.from(42)
val stringValue: JsonValue = JsonValue.from("Hello World!")

// Create a JSON array value equivalent to `["Hello", "World"]`
val arrayValue: JsonValue = JsonValue.from(listOf(
  "Hello", "World"
))

// Create a JSON object value equivalent to `{ "a": 1, "b": 2 }`
val objectValue: JsonValue = JsonValue.from(mapOf(
  "a" to 1, "b" to 2
))

// Create an arbitrarily nested JSON equivalent to:
// {
//   "a": [1, 2],
//   "b": [3, 4]
// }
val complexValue: JsonValue = JsonValue.from(mapOf(
  "a" to listOf(
    1, 2
  ), "b" to listOf(
    3, 4
  )
))
```

### Response properties

To access undocumented response properties, call the `_additionalProperties()` method:

```kotlin
import me.elborai.api.core.JsonBoolean
import me.elborai.api.core.JsonNull
import me.elborai.api.core.JsonNumber
import me.elborai.api.core.JsonValue

val additionalProperties: Map<String, JsonValue> = client.messages().create(params)._additionalProperties()
val secretPropertyValue: JsonValue = additionalProperties.get("secretProperty")

val result = when (secretPropertyValue) {
    is JsonNull -> "It's null!"
    is JsonBoolean -> "It's a boolean!"
    is JsonNumber -> "It's a number!"
    // Other types include `JsonMissing`, `JsonString`, `JsonArray`, and `JsonObject`
    else -> "It's something else!"
}
```

To access a property's raw JSON value, which may be undocumented, call its `_` prefixed method:

```kotlin
import me.elborai.api.core.JsonField

val maxTokens: JsonField<Long> = client.messages().create(params)._maxTokens()

if (maxTokens.isMissing()) {
  // The property is absent from the JSON response
} else if (maxTokens.isNull()) {
  // The property was set to literal null
} else {
  // Check if value was provided as a string
  // Other methods include `asNumber()`, `asBoolean()`, etc.
  val jsonString: String? = maxTokens.asString();

  // Try to deserialize into a custom type
  val myObject: MyClass = maxTokens.asUnknown()!!.convert(MyClass::class.java)
}
```

### Response validation

In rare cases, the API may return a response that doesn't match the expected type. For example, the SDK may expect a property to contain a `String`, but the API could return something else.

By default, the SDK will not throw an exception in this case. It will throw [`SamInvalidDataException`](sam-kotlin-core/src/main/kotlin/me/elborai/api/errors/SamInvalidDataException.kt) only if you directly access the property.

If you would prefer to check that the response is completely well-typed upfront, then either call `validate()`:

```kotlin
import me.elborai.api.models.messages.MessageCreateResponse

val message: MessageCreateResponse = client.messages().create(params).validate()
```

Or configure the method call to validate the response using the `responseValidation` method:

```kotlin
import me.elborai.api.models.messages.MessageCreateParams
import me.elborai.api.models.messages.MessageCreateResponse

val message: MessageCreateResponse = client.messages().create(
  params, RequestOptions.builder().responseValidation(true).build()
)
```

Or configure the default for all method calls at the client level:

```kotlin
import me.elborai.api.client.SamClient
import me.elborai.api.client.okhttp.SamOkHttpClient

val client: SamClient = SamOkHttpClient.builder()
    .fromEnv()
    .responseValidation(true)
    .build()
```

## FAQ

### Why don't you use plain `enum` classes?

Kotlin `enum` classes are not trivially [forwards compatible](https://www.stainless.com/blog/making-java-enums-forwards-compatible). Using them in the SDK could cause runtime exceptions if the API is updated to respond with a new enum value.

### Why do you represent fields using `JsonField<T>` instead of just plain `T`?

Using `JsonField<T>` enables a few features:

- Allowing usage of [undocumented API functionality](#undocumented-api-functionality)
- Lazily [validating the API response against the expected shape](#response-validation)
- Representing absent vs explicitly null values

### Why don't you use [`data` classes](https://kotlinlang.org/docs/data-classes.html)?

It is not [backwards compatible to add new fields to a data class](https://kotlinlang.org/docs/api-guidelines-backward-compatibility.html#avoid-using-data-classes-in-your-api) and we don't want to introduce a breaking change every time we add a field to a class.

### Why don't you use checked exceptions?

Checked exceptions are widely considered a mistake in the Java programming language. In fact, they were omitted from Kotlin for this reason.

Checked exceptions:

- Are verbose to handle
- Encourage error handling at the wrong level of abstraction, where nothing can be done about the error
- Are tedious to propagate due to the [function coloring problem](https://journal.stuffwithstuff.com/2015/02/01/what-color-is-your-function)
- Don't play well with lambdas (also due to the function coloring problem)

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/DefinitelyATestOrg/sam-kotlin/issues) with questions, bugs, or suggestions.
