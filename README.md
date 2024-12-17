# Sam Kotlin API Library

The Sam Kotlin SDK provides convenient access to the Sam REST API from applications written in Kotlin. It includes helper classes with helpful types and documentation for every request and response property.

The Sam Kotlin SDK is similar to the Sam Java SDK but with minor differences that make it more ergonomic for use in Kotlin, such as nullable values instead of `Optional`, `Sequence` instead of `Stream`, and suspend functions instead of `CompletableFuture`.

It is generated with [Stainless](https://www.stainlessapi.com/).

## Documentation

The REST API documentation can be found on [docs.sam.com](https://docs.sam.com).

---

## Getting started

### Install dependencies

#### Gradle

```kotlin
implementation("com.sam.api:sam-kotlin:0.1.0-alpha.1")
```

#### Maven

```xml
<dependency>
    <groupId>com.sam.api</groupId>
    <artifactId>sam-kotlin</artifactId>
    <version>0.1.0-alpha.1</version>
</dependency>
```

### Configure the client

Use `SamOkHttpClient.builder()` to configure the client. At a minimum you need to set `.apiKey()`:

```kotlin
import com.sam.api.client.SamClient
import com.sam.api.client.okhttp.SamOkHttpClient

val client = SamOkHttpClient.builder()
    .apiKey("My API Key")
    .build()
```

Alternately, set the environment with `API_KEY`, and use `SamOkHttpClient.fromEnv()` to read from the environment.

```kotlin
val client = SamOkHttpClient.fromEnv()

// Note: you can also call fromEnv() from the client builder, for example if you need to set additional properties
val client = SamOkHttpClient.builder()
    .fromEnv()
    // ... set properties on the builder
    .build()
```

| Property | Environment variable | Required | Default value |
| -------- | -------------------- | -------- | ------------- |
| apiKey   | `API_KEY`            | true     | —             |

Read the documentation for more configuration options.

---

### Example: creating a resource

To create a new user, first use the `UserCreateParams` builder to specify attributes,
then pass that to the `create` method of the `users` service.

```kotlin
import com.sam.api.models.User
import com.sam.api.models.UserCreateParams

val params = UserCreateParams.builder().build()
val user = client.users().create(params)
```

---

## Requests

### Parameters and bodies

To make a request to the Sam API, you generally build an instance of the appropriate `Params` class.

In [Example: creating a resource](#example-creating-a-resource) above, we used the `UserCreateParams.builder()` to pass to
the `create` method of the `users` service.

Sometimes, the API may support other properties that are not yet supported in the Kotlin SDK types. In that case,
you can attach them using the `putAdditionalProperty` method.

```kotlin
import com.sam.api.models.core.JsonValue
val params = UserCreateParams.builder()
    // ... normal properties
    .putAdditionalProperty("secret_param", JsonValue.from("4242"))
    .build()
```

## Responses

### Response validation

When receiving a response, the Sam Kotlin SDK will deserialize it into instances of the typed model classes. In rare cases, the API may return a response property that doesn't match the expected Kotlin type. If you directly access the mistaken property, the SDK will throw an unchecked `SamInvalidDataException` at runtime. If you would prefer to check in advance that that response is completely well-typed, call `.validate()` on the returned model.

```kotlin
val user = client.users().create().validate()
```

### Response properties as JSON

In rare cases, you may want to access the underlying JSON value for a response property rather than using the typed version provided by
this SDK. Each model property has a corresponding JSON version, with an underscore before the method name, which returns a `JsonField` value.

```kotlin
val field = responseObj._field

if (field.isMissing()) {
  // Value was not specified in the JSON response
} else if (field.isNull()) {
  // Value was provided as a literal null
} else {
  // See if value was provided as a string
  val jsonString: String? = field.asString();

  // If the value given by the API did not match the shape that the SDK expects
  // you can deserialise into a custom type
  val myObj = responseObj._field.asUnknown()?.convert(MyClass.class)
}
```

### Additional model properties

Sometimes, the server response may include additional properties that are not yet available in this library's types. You can access them using the model's `_additionalProperties` method:

```kotlin
val secret = order._additionalProperties().get("secret_field")
```

---

---

## Error handling

This library throws exceptions in a single hierarchy for easy handling:

- **`SamException`** - Base exception for all exceptions

  - **`SamServiceException`** - HTTP errors with a well-formed response body we were able to parse. The exception message and the `.debuggingRequestId()` will be set by the server.

    | 400    | BadRequestException           |
    | ------ | ----------------------------- |
    | 401    | AuthenticationException       |
    | 403    | PermissionDeniedException     |
    | 404    | NotFoundException             |
    | 422    | UnprocessableEntityException  |
    | 429    | RateLimitException            |
    | 5xx    | InternalServerException       |
    | others | UnexpectedStatusCodeException |

  - **`SamIoException`** - I/O networking errors
  - **`SamInvalidDataException`** - any other exceptions on the client side, e.g.:
    - We failed to serialize the request body
    - We failed to parse the response body (has access to response code and body)

## Network options

### Retries

Requests that experience certain errors are automatically retried 2 times by default, with a short exponential backoff. Connection errors (for example, due to a network connectivity problem), 408 Request Timeout, 409 Conflict, 429 Rate Limit, and >=500 Internal errors will all be retried by default.
You can provide a `maxRetries` on the client builder to configure this:

```kotlin
val client = SamOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build()
```

### Timeouts

Requests time out after 1 minute by default. You can configure this on the client builder:

```kotlin
val client = SamOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build()
```

### Proxies

Requests can be routed through a proxy. You can configure this on the client builder:

```kotlin
val client = SamOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
        Type.HTTP,
        new InetSocketAddress("proxy.com", 8080)
    ))
    .build()
```

## Logging

We use the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

You can enable logging by setting the environment variable `SAM_LOG` to `info`.

```sh
$ export SAM_LOG=info
```

Or to `debug` for more verbose logging.

```sh
$ export SAM_LOG=debug
```

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals)_.
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/stainless-sdks/sam-kotlin/issues) with questions, bugs, or suggestions.

## Requirements

This library requires Java 8 or later.
