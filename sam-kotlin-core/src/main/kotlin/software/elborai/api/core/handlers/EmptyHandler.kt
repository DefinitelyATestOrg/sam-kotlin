@file:JvmName("EmptyHandler")

package software.elborai.api.core.handlers

import software.elborai.api.core.http.HttpResponse
import software.elborai.api.core.http.HttpResponse.Handler

internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
