// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking.intrafi

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.IntrafiBalance
import software.elborai.api.models.IntrafiBalanceRetrieveParams

interface BalanceService {

    /** Get IntraFi balances by bank */
    fun retrieve(
        params: IntrafiBalanceRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): IntrafiBalance
}
