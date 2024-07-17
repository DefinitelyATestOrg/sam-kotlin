// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.DigitalWalletToken
import software.elborai.api.models.DigitalWalletTokenListPageAsync
import software.elborai.api.models.DigitalWalletTokenListParams
import software.elborai.api.models.DigitalWalletTokenRetrieveParams

interface DigitalWalletTokenServiceAsync {

    /** Retrieve a Digital Wallet Token */
    suspend fun retrieve(
        params: DigitalWalletTokenRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DigitalWalletToken

    /** List Digital Wallet Tokens */
    suspend fun list(
        params: DigitalWalletTokenListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DigitalWalletTokenListPageAsync
}
