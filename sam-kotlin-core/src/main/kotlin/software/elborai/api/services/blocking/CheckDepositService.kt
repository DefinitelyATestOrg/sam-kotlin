// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.CheckDeposit
import software.elborai.api.models.CheckDepositCreateParams
import software.elborai.api.models.CheckDepositListPage
import software.elborai.api.models.CheckDepositListParams
import software.elborai.api.models.CheckDepositRetrieveParams

interface CheckDepositService {

    /** Create a Check Deposit */
    fun create(
        params: CheckDepositCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CheckDeposit

    /** Retrieve a Check Deposit */
    fun retrieve(
        params: CheckDepositRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CheckDeposit

    /** List Check Deposits */
    fun list(
        params: CheckDepositListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CheckDepositListPage
}
