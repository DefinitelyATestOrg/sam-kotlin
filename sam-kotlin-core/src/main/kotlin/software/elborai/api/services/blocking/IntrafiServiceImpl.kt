// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.services.blocking.intrafi.AccountEnrollmentService
import software.elborai.api.services.blocking.intrafi.AccountEnrollmentServiceImpl
import software.elborai.api.services.blocking.intrafi.BalanceService
import software.elborai.api.services.blocking.intrafi.BalanceServiceImpl
import software.elborai.api.services.blocking.intrafi.ExclusionService
import software.elborai.api.services.blocking.intrafi.ExclusionServiceImpl
import software.elborai.api.services.errorHandler

class IntrafiServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : IntrafiService {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val accountEnrollments: AccountEnrollmentService by lazy {
        AccountEnrollmentServiceImpl(clientOptions)
    }

    private val balances: BalanceService by lazy { BalanceServiceImpl(clientOptions) }

    private val exclusions: ExclusionService by lazy { ExclusionServiceImpl(clientOptions) }

    override fun accountEnrollments(): AccountEnrollmentService = accountEnrollments

    override fun balances(): BalanceService = balances

    override fun exclusions(): ExclusionService = exclusions
}
