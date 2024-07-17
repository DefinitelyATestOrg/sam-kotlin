// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.AccountStatement
import software.elborai.api.models.AccountStatementListPage
import software.elborai.api.models.AccountStatementListParams
import software.elborai.api.models.AccountStatementRetrieveParams

interface AccountStatementService {

    /** Retrieve an Account Statement */
    fun retrieve(
        params: AccountStatementRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountStatement

    /** List Account Statements */
    fun list(
        params: AccountStatementListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountStatementListPage
}
