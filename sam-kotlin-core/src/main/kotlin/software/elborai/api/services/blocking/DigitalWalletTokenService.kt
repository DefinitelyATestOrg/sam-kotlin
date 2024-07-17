// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.DigitalWalletToken
import software.elborai.api.models.DigitalWalletTokenListPage
import software.elborai.api.models.DigitalWalletTokenListParams
import software.elborai.api.models.DigitalWalletTokenRetrieveParams

interface DigitalWalletTokenService {

    /** Retrieve a Digital Wallet Token */
    fun retrieve(
        params: DigitalWalletTokenRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DigitalWalletToken

    /** List Digital Wallet Tokens */
    fun list(
        params: DigitalWalletTokenListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): DigitalWalletTokenListPage
}
