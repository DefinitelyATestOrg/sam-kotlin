// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.async

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.EventSubscription
import software.elborai.api.models.EventSubscriptionCreateParams
import software.elborai.api.models.EventSubscriptionListPageAsync
import software.elborai.api.models.EventSubscriptionListParams
import software.elborai.api.models.EventSubscriptionRetrieveParams
import software.elborai.api.models.EventSubscriptionUpdateParams

interface EventSubscriptionServiceAsync {

    /** Create an Event Subscription */
    suspend fun create(
        params: EventSubscriptionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EventSubscription

    /** Retrieve an Event Subscription */
    suspend fun retrieve(
        params: EventSubscriptionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EventSubscription

    /** Update an Event Subscription */
    suspend fun update(
        params: EventSubscriptionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EventSubscription

    /** List Event Subscriptions */
    suspend fun list(
        params: EventSubscriptionListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EventSubscriptionListPageAsync
}
