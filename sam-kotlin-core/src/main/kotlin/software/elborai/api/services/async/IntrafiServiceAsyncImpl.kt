// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.async

import software.elborai.api.core.ClientOptions
import software.elborai.api.core.http.HttpResponse.Handler
import software.elborai.api.errors.IncreaseError
import software.elborai.api.services.async.intrafi.AccountEnrollmentServiceAsync
import software.elborai.api.services.async.intrafi.AccountEnrollmentServiceAsyncImpl
import software.elborai.api.services.async.intrafi.BalanceServiceAsync
import software.elborai.api.services.async.intrafi.BalanceServiceAsyncImpl
import software.elborai.api.services.async.intrafi.ExclusionServiceAsync
import software.elborai.api.services.async.intrafi.ExclusionServiceAsyncImpl
import software.elborai.api.services.errorHandler

class IntrafiServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : IntrafiServiceAsync {

    private val errorHandler: Handler<IncreaseError> = errorHandler(clientOptions.jsonMapper)

    private val accountEnrollments: AccountEnrollmentServiceAsync by lazy {
        AccountEnrollmentServiceAsyncImpl(clientOptions)
    }

    private val balances: BalanceServiceAsync by lazy { BalanceServiceAsyncImpl(clientOptions) }

    private val exclusions: ExclusionServiceAsync by lazy {
        ExclusionServiceAsyncImpl(clientOptions)
    }

    override fun accountEnrollments(): AccountEnrollmentServiceAsync = accountEnrollments

    override fun balances(): BalanceServiceAsync = balances

    override fun exclusions(): ExclusionServiceAsync = exclusions
}
