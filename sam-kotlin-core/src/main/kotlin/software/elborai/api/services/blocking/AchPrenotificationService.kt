// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.AchPrenotification
import software.elborai.api.models.AchPrenotificationCreateParams
import software.elborai.api.models.AchPrenotificationListPage
import software.elborai.api.models.AchPrenotificationListParams
import software.elborai.api.models.AchPrenotificationRetrieveParams

interface AchPrenotificationService {

    /** Create an ACH Prenotification */
    fun create(
        params: AchPrenotificationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AchPrenotification

    /** Retrieve an ACH Prenotification */
    fun retrieve(
        params: AchPrenotificationRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AchPrenotification

    /** List ACH Prenotifications */
    fun list(
        params: AchPrenotificationListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AchPrenotificationListPage
}
