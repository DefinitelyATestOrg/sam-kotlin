// File generated from our OpenAPI spec by Stainless.

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
import software.elborai.api.services.blocking.*
import software.elborai.api.services.emptyHandler
import software.elborai.api.services.errorHandler
import software.elborai.api.services.json
import software.elborai.api.services.jsonHandler
import software.elborai.api.services.stringHandler
import software.elborai.api.services.binaryHandler
import software.elborai.api.services.withErrorHandler

class SamClientImpl constructor(private val clientOptions: ClientOptions, ) : SamClient {

    private val errorHandler: Handler<SamError> = errorHandler(clientOptions.jsonMapper)

    private val async: SamClientAsync by lazy { SamClientAsyncImpl(clientOptions) }

    private val referenceSets: ReferenceSetService by lazy { ReferenceSetServiceImpl(clientOptions) }

    private val referenceSessions: ReferenceSessionService by lazy { ReferenceSessionServiceImpl(clientOptions) }

    private val organizations: OrganizationService by lazy { OrganizationServiceImpl(clientOptions) }

    private val members: MemberService by lazy { MemberServiceImpl(clientOptions) }

    private val feedbacks: FeedbackService by lazy { FeedbackServiceImpl(clientOptions) }

    private val documents: DocumentService by lazy { DocumentServiceImpl(clientOptions) }

    private val corpora: CorporaService by lazy { CorporaServiceImpl(clientOptions) }

    private val agents: AgentService by lazy { AgentServiceImpl(clientOptions) }

    private val actionSets: ActionSetService by lazy { ActionSetServiceImpl(clientOptions) }

    private val actions: ActionService by lazy { ActionServiceImpl(clientOptions) }

    override fun async(): SamClientAsync = async

    override fun referenceSets(): ReferenceSetService = referenceSets

    override fun referenceSessions(): ReferenceSessionService = referenceSessions

    override fun organizations(): OrganizationService = organizations

    override fun members(): MemberService = members

    override fun feedbacks(): FeedbackService = feedbacks

    override fun documents(): DocumentService = documents

    override fun corpora(): CorporaService = corpora

    override fun agents(): AgentService = agents

    override fun actionSets(): ActionSetService = actionSets

    override fun actions(): ActionService = actions
}
