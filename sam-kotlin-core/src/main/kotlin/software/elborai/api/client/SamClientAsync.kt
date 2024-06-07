// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.client

import java.time.Duration
import java.util.Base64
import java.util.Optional
import java.util.concurrent.CompletableFuture
import software.elborai.api.core.ClientOptions
import software.elborai.api.core.http.HttpMethod
import software.elborai.api.core.http.HttpRequest
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.core.JsonField
import software.elborai.api.core.RequestOptions
import software.elborai.api.errors.SamError
import software.elborai.api.errors.SamInvalidDataException
import software.elborai.api.models.*
import software.elborai.api.services.async.*
import software.elborai.api.services.emptyHandler
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.stringHandler
import software.elborai.api.services.binaryHandler
import software.elborai.api.services.withErrorHandler

interface SamClientAsync {

    fun sync(): SamClient

    fun referenceSets(): ReferenceSetServiceAsync

    fun referenceSessions(): ReferenceSessionServiceAsync

    fun organizations(): OrganizationServiceAsync

    fun members(): MemberServiceAsync

    fun feedbacks(): FeedbackServiceAsync

    fun documents(): DocumentServiceAsync

    fun corpora(): CorporaServiceAsync

    fun agents(): AgentServiceAsync

    fun actionSets(): ActionSetServiceAsync

    fun actions(): ActionServiceAsync
}
