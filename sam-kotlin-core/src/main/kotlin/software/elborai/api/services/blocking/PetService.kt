// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.services.blocking

import software.elborai.api.core.RequestOptions
import software.elborai.api.models.ApiResponse
import software.elborai.api.models.Pet
import software.elborai.api.models.PetCreateParams
import software.elborai.api.models.PetDeleteParams
import software.elborai.api.models.PetFindByStatusParams
import software.elborai.api.models.PetFindByTagsParams
import software.elborai.api.models.PetRetrieveParams
import software.elborai.api.models.PetUpdateParams
import software.elborai.api.models.PetUploadImageParams

interface PetService {

    /** Updates a pet in the store with form data */
    fun create(params: PetCreateParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Returns a single pet */
    fun retrieve(
        params: PetRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Pet

    /** Update an existing pet by Id */
    fun update(params: PetUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): Pet

    /** Deletes a pet */
    fun delete(params: PetDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** Multiple status values can be provided with comma separated strings */
    fun findByStatus(
        params: PetFindByStatusParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): List<Pet>

    /**
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     */
    fun findByTags(
        params: PetFindByTagsParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): List<Pet>

    /** uploads an image */
    fun uploadImage(
        params: PetUploadImageParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): ApiResponse
}
