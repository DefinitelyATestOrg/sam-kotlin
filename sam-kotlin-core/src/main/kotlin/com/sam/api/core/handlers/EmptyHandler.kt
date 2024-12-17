@file:JvmName("EmptyHandler")

package com.sam.api.core.handlers

import com.sam.api.core.http.HttpResponse
import com.sam.api.core.http.HttpResponse.Handler

internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
