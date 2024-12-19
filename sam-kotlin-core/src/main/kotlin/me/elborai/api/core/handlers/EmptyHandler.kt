@file:JvmName("EmptyHandler")

package me.elborai.api.core.handlers

import me.elborai.api.core.http.HttpResponse
import me.elborai.api.core.http.HttpResponse.Handler

internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
