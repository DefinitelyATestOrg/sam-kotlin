// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.services.async.intrafi.AccountEnrollmentServiceAsync
import software.elborai.api.services.async.intrafi.BalanceServiceAsync
import software.elborai.api.services.async.intrafi.ExclusionServiceAsync

interface IntrafiServiceAsync {

    fun accountEnrollments(): AccountEnrollmentServiceAsync

    fun balances(): BalanceServiceAsync

    fun exclusions(): ExclusionServiceAsync
}
