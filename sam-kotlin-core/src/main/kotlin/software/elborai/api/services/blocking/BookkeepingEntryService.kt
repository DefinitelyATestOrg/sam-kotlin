// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.BookkeepingEntry
import software.elborai.api.models.BookkeepingEntryListPage
import software.elborai.api.models.BookkeepingEntryListParams
import software.elborai.api.models.BookkeepingEntryRetrieveParams

interface BookkeepingEntryService {

    /** Retrieve a Bookkeeping Entry */
    fun retrieve(
        params: BookkeepingEntryRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BookkeepingEntry

    /** List Bookkeeping Entries */
    fun list(
        params: BookkeepingEntryListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): BookkeepingEntryListPage
}
