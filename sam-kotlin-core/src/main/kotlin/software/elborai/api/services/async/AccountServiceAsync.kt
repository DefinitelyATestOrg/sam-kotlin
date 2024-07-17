// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Account
import software.elborai.api.models.AccountBalanceParams
import software.elborai.api.models.AccountCloseParams
import software.elborai.api.models.AccountCreateParams
import software.elborai.api.models.AccountListPageAsync
import software.elborai.api.models.AccountListParams
import software.elborai.api.models.AccountRetrieveParams
import software.elborai.api.models.AccountUpdateParams
import software.elborai.api.models.BalanceLookup

interface AccountServiceAsync {

    /** Create an Account */
    suspend fun create(
        params: AccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Account

    /** Retrieve an Account */
    suspend fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Account

    /** Update an Account */
    suspend fun update(
        params: AccountUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Account

    /** List Accounts */
    suspend fun list(
        params: AccountListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountListPageAsync

    /** Retrieve an Account Balance */
    suspend fun balance(
        params: AccountBalanceParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BalanceLookup

    /** Close an Account */
    suspend fun close(
        params: AccountCloseParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Account
}
