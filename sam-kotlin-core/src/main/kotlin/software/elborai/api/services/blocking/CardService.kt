// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.Card
import software.elborai.api.models.CardCreateParams
import software.elborai.api.models.CardDetails
import software.elborai.api.models.CardListPage
import software.elborai.api.models.CardListParams
import software.elborai.api.models.CardRetrieveParams
import software.elborai.api.models.CardRetrieveSensitiveDetailsParams
import software.elborai.api.models.CardUpdateParams

interface CardService {

    /** Create a Card */
    fun create(
        params: CardCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Card

    /** Retrieve a Card */
    fun retrieve(
        params: CardRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Card

    /** Update a Card */
    fun update(
        params: CardUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Card

    /** List Cards */
    fun list(
        params: CardListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardListPage

    /** Retrieve sensitive details for a Card */
    fun retrieveSensitiveDetails(
        params: CardRetrieveSensitiveDetailsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CardDetails
}
