// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.client

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.SamError
import software.elborai.api.models.*
import software.elborai.api.services.async.*
import software.elborai.api.services.errorHandler

class SamClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : SamClientAsync {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val sync: SamClient by lazy { SamClientImpl(clientOptions) }

    private val referenceSets: ReferenceSetServiceAsync by lazy {
        ReferenceSetServiceAsyncImpl(clientOptions)
    }

    private val referenceSessions: ReferenceSessionServiceAsync by lazy {
        ReferenceSessionServiceAsyncImpl(clientOptions)
    }

    private val organizations: OrganizationServiceAsync by lazy {
        OrganizationServiceAsyncImpl(clientOptions)
    }

    private val members: MemberServiceAsync by lazy { MemberServiceAsyncImpl(clientOptions) }

    private val feedbacks: FeedbackServiceAsync by lazy { FeedbackServiceAsyncImpl(clientOptions) }

    private val documents: DocumentServiceAsync by lazy { DocumentServiceAsyncImpl(clientOptions) }

    private val corpora: CorporaServiceAsync by lazy { CorporaServiceAsyncImpl(clientOptions) }

    private val agents: AgentServiceAsync by lazy { AgentServiceAsyncImpl(clientOptions) }

    private val actionSets: ActionSetServiceAsync by lazy {
        ActionSetServiceAsyncImpl(clientOptions)
    }

    private val actions: ActionServiceAsync by lazy { ActionServiceAsyncImpl(clientOptions) }

    override fun sync(): SamClient = sync

    override fun referenceSets(): ReferenceSetServiceAsync = referenceSets

    override fun referenceSessions(): ReferenceSessionServiceAsync = referenceSessions

    override fun organizations(): OrganizationServiceAsync = organizations

    override fun members(): MemberServiceAsync = members

    override fun feedbacks(): FeedbackServiceAsync = feedbacks

    override fun documents(): DocumentServiceAsync = documents

    override fun corpora(): CorporaServiceAsync = corpora

    override fun agents(): AgentServiceAsync = agents

    override fun actionSets(): ActionSetServiceAsync = actionSets

    override fun actions(): ActionServiceAsync = actions
}
