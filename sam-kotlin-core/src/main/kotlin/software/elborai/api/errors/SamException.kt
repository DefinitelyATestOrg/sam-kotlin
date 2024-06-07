package software.elborai.api.errors

open class SamException
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
