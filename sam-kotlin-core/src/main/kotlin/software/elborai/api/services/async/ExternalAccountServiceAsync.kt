// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.ExternalAccount
import software.elborai.api.models.ExternalAccountCreateParams
import software.elborai.api.models.ExternalAccountListPageAsync
import software.elborai.api.models.ExternalAccountListParams
import software.elborai.api.models.ExternalAccountRetrieveParams
import software.elborai.api.models.ExternalAccountUpdateParams

interface ExternalAccountServiceAsync {

    /** Create an External Account */
    suspend fun create(
        params: ExternalAccountCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ExternalAccount

    /** Retrieve an External Account */
    suspend fun retrieve(
        params: ExternalAccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ExternalAccount

    /** Update an External Account */
    suspend fun update(
        params: ExternalAccountUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ExternalAccount

    /** List External Accounts */
    suspend fun list(
        params: ExternalAccountListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ExternalAccountListPageAsync
}
