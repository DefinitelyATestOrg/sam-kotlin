@file:JvmName("StringHandler")

package software.elborai.api.core.handlers

import software.elborai.api.core.http.HttpResponse
import software.elborai.api.core.http.HttpResponse.Handler

internal fun stringHandler(): Handler<String> = StringHandlerInternal

private object StringHandlerInternal : Handler<String> {
    override fun handle(response: HttpResponse): String =
        response.body().readBytes().toString(Charsets.UTF_8)
}
