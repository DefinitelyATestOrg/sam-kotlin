// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.client

import software.elborai.api.models.*
import software.elborai.api.services.blocking.*

interface SamClient {

    fun async(): SamClientAsync

    fun referenceSets(): ReferenceSetService

    fun referenceSessions(): ReferenceSessionService

    fun organizations(): OrganizationService

    fun members(): MemberService

    fun feedbacks(): FeedbackService

    fun documents(): DocumentService

    fun corpora(): CorporaService

    fun agents(): AgentService

    fun actionSets(): ActionSetService

    fun actions(): ActionService
}
