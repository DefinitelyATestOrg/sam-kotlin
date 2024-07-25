package software.elborai.api.errors

open class IncreaseException
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
