// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.EventSubscription
import software.elborai.api.models.EventSubscriptionCreateParams
import software.elborai.api.models.EventSubscriptionListPage
import software.elborai.api.models.EventSubscriptionListParams
import software.elborai.api.models.EventSubscriptionRetrieveParams
import software.elborai.api.models.EventSubscriptionUpdateParams

interface EventSubscriptionService {

    /** Create an Event Subscription */
    fun create(
        params: EventSubscriptionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EventSubscription

    /** Retrieve an Event Subscription */
    fun retrieve(
        params: EventSubscriptionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EventSubscription

    /** Update an Event Subscription */
    fun update(
        params: EventSubscriptionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EventSubscription

    /** List Event Subscriptions */
    fun list(
        params: EventSubscriptionListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): EventSubscriptionListPage
}
