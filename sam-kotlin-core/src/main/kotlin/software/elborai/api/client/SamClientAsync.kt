// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.client

import software.elborai.api.models.*
import software.elborai.api.services.async.*

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
