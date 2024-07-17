// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.AccountNumber
import software.elborai.api.models.AccountNumberCreateParams
import software.elborai.api.models.AccountNumberListPageAsync
import software.elborai.api.models.AccountNumberListParams
import software.elborai.api.models.AccountNumberRetrieveParams
import software.elborai.api.models.AccountNumberUpdateParams

interface AccountNumberServiceAsync {

    /** Create an Account Number */
    suspend fun create(
        params: AccountNumberCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountNumber

    /** Retrieve an Account Number */
    suspend fun retrieve(
        params: AccountNumberRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountNumber

    /** Update an Account Number */
    suspend fun update(
        params: AccountNumberUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountNumber

    /** List Account Numbers */
    suspend fun list(
        params: AccountNumberListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AccountNumberListPageAsync
}
