// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Account
import software.elborai.api.models.AccountBalanceParams
import software.elborai.api.models.AccountCloseParams
import software.elborai.api.models.AccountCreateParams
import software.elborai.api.models.AccountListPage
import software.elborai.api.models.AccountListParams
import software.elborai.api.models.AccountRetrieveParams
import software.elborai.api.models.AccountUpdateParams
import software.elborai.api.models.BalanceLookup

interface AccountService {

    /** Create an Account */
    fun create(
        params: AccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Account

    /** Retrieve an Account */
    fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Account

    /** Update an Account */
    fun update(
        params: AccountUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Account

    /** List Accounts */
    fun list(
        params: AccountListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountListPage

    /** Retrieve an Account Balance */
    fun balance(
        params: AccountBalanceParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BalanceLookup

    /** Close an Account */
    fun close(
        params: AccountCloseParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Account
}
