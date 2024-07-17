// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.services.blocking.intrafi.AccountEnrollmentService
import software.elborai.api.services.blocking.intrafi.BalanceService
import software.elborai.api.services.blocking.intrafi.ExclusionService

interface IntrafiService {

    fun accountEnrollments(): AccountEnrollmentService

    fun balances(): BalanceService

    fun exclusions(): ExclusionService
}
