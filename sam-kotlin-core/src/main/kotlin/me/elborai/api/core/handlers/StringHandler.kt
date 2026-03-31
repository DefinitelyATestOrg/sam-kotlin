@file:JvmName("StringHandler")

package me.elborai.api.core.handlers

import me.elborai.api.core.http.HttpResponse
import me.elborai.api.core.http.HttpResponse.Handler

internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
