// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.util.Objects
import software.elborai.api.core.ExcludeMissing
import software.elborai.api.core.JsonValue
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.core.toUnmodifiable
import software.elborai.api.models.*

class ReferenceSessionUpdateParams
constructor(
    private val pathId: String,
    private val bodyId: String?,
    private val createdBy: CreatedBy?,
    private val questions: List<Question>?,
    private val referenceSetId: String?,
    private val updatedBy: UpdatedBy?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun pathId(): String = pathId

    fun bodyId(): String? = bodyId

    fun createdBy(): CreatedBy? = createdBy

    fun questions(): List<Question>? = questions

    fun referenceSetId(): String? = referenceSetId

    fun updatedBy(): UpdatedBy? = updatedBy

    internal fun getBody(): ReferenceSessionUpdateBody {
        return ReferenceSessionUpdateBody(
            bodyId,
            createdBy,
            questions,
            referenceSetId,
            updatedBy,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> pathId
            else -> ""
        }
    }

    @JsonDeserialize(builder = ReferenceSessionUpdateBody.Builder::class)
    @NoAutoDetect
    class ReferenceSessionUpdateBody
    internal constructor(
        private val bodyId: String?,
        private val createdBy: CreatedBy?,
        private val questions: List<Question>?,
        private val referenceSetId: String?,
        private val updatedBy: UpdatedBy?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("id") fun bodyId(): String? = bodyId

        @JsonProperty("createdBy") fun createdBy(): CreatedBy? = createdBy

        @JsonProperty("questions") fun questions(): List<Question>? = questions

        @JsonProperty("referenceSetId") fun referenceSetId(): String? = referenceSetId

        @JsonProperty("updatedBy") fun updatedBy(): UpdatedBy? = updatedBy

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ReferenceSessionUpdateBody &&
                this.bodyId == other.bodyId &&
                this.createdBy == other.createdBy &&
                this.questions == other.questions &&
                this.referenceSetId == other.referenceSetId &&
                this.updatedBy == other.updatedBy &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        bodyId,
                        createdBy,
                        questions,
                        referenceSetId,
                        updatedBy,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "ReferenceSessionUpdateBody{bodyId=$bodyId, createdBy=$createdBy, questions=$questions, referenceSetId=$referenceSetId, updatedBy=$updatedBy, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var bodyId: String? = null
            private var createdBy: CreatedBy? = null
            private var questions: List<Question>? = null
            private var referenceSetId: String? = null
            private var updatedBy: UpdatedBy? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(referenceSessionUpdateBody: ReferenceSessionUpdateBody) = apply {
                this.bodyId = referenceSessionUpdateBody.bodyId
                this.createdBy = referenceSessionUpdateBody.createdBy
                this.questions = referenceSessionUpdateBody.questions
                this.referenceSetId = referenceSessionUpdateBody.referenceSetId
                this.updatedBy = referenceSessionUpdateBody.updatedBy
                additionalProperties(referenceSessionUpdateBody.additionalProperties)
            }

            @JsonProperty("id") fun bodyId(bodyId: String) = apply { this.bodyId = bodyId }

            @JsonProperty("createdBy")
            fun createdBy(createdBy: CreatedBy) = apply { this.createdBy = createdBy }

            @JsonProperty("questions")
            fun questions(questions: List<Question>) = apply { this.questions = questions }

            @JsonProperty("referenceSetId")
            fun referenceSetId(referenceSetId: String) = apply {
                this.referenceSetId = referenceSetId
            }

            @JsonProperty("updatedBy")
            fun updatedBy(updatedBy: UpdatedBy) = apply { this.updatedBy = updatedBy }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): ReferenceSessionUpdateBody =
                ReferenceSessionUpdateBody(
                    bodyId,
                    createdBy,
                    questions?.toUnmodifiable(),
                    referenceSetId,
                    updatedBy,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ReferenceSessionUpdateParams &&
            this.pathId == other.pathId &&
            this.bodyId == other.bodyId &&
            this.createdBy == other.createdBy &&
            this.questions == other.questions &&
            this.referenceSetId == other.referenceSetId &&
            this.updatedBy == other.updatedBy &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            pathId,
            bodyId,
            createdBy,
            questions,
            referenceSetId,
            updatedBy,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "ReferenceSessionUpdateParams{pathId=$pathId, bodyId=$bodyId, createdBy=$createdBy, questions=$questions, referenceSetId=$referenceSetId, updatedBy=$updatedBy, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var pathId: String? = null
        private var bodyId: String? = null
        private var createdBy: CreatedBy? = null
        private var questions: MutableList<Question> = mutableListOf()
        private var referenceSetId: String? = null
        private var updatedBy: UpdatedBy? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(referenceSessionUpdateParams: ReferenceSessionUpdateParams) = apply {
            this.pathId = referenceSessionUpdateParams.pathId
            this.bodyId = referenceSessionUpdateParams.bodyId
            this.createdBy = referenceSessionUpdateParams.createdBy
            this.questions(referenceSessionUpdateParams.questions ?: listOf())
            this.referenceSetId = referenceSessionUpdateParams.referenceSetId
            this.updatedBy = referenceSessionUpdateParams.updatedBy
            additionalQueryParams(referenceSessionUpdateParams.additionalQueryParams)
            additionalHeaders(referenceSessionUpdateParams.additionalHeaders)
            additionalBodyProperties(referenceSessionUpdateParams.additionalBodyProperties)
        }

        fun pathId(pathId: String) = apply { this.pathId = pathId }

        fun bodyId(bodyId: String) = apply { this.bodyId = bodyId }

        fun createdBy(createdBy: CreatedBy) = apply { this.createdBy = createdBy }

        fun questions(questions: List<Question>) = apply {
            this.questions.clear()
            this.questions.addAll(questions)
        }

        fun addQuestion(question: Question) = apply { this.questions.add(question) }

        fun referenceSetId(referenceSetId: String) = apply { this.referenceSetId = referenceSetId }

        fun updatedBy(updatedBy: UpdatedBy) = apply { this.updatedBy = updatedBy }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): ReferenceSessionUpdateParams =
            ReferenceSessionUpdateParams(
                checkNotNull(pathId) { "`pathId` is required but was not set" },
                bodyId,
                createdBy,
                if (questions.size == 0) null else questions.toUnmodifiable(),
                referenceSetId,
                updatedBy,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = CreatedBy.Builder::class)
    @NoAutoDetect
    class CreatedBy
    private constructor(
        private val id: String?,
        private val name: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("id") fun id(): String? = id

        @JsonProperty("name") fun name(): String? = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CreatedBy &&
                this.id == other.id &&
                this.name == other.name &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        id,
                        name,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CreatedBy{id=$id, name=$name, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: String? = null
            private var name: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(createdBy: CreatedBy) = apply {
                this.id = createdBy.id
                this.name = createdBy.name
                additionalProperties(createdBy.additionalProperties)
            }

            @JsonProperty("id") fun id(id: String) = apply { this.id = id }

            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): CreatedBy =
                CreatedBy(
                    id,
                    name,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    @JsonDeserialize(builder = Question.Builder::class)
    @NoAutoDetect
    class Question
    private constructor(
        private val question: String?,
        private val expectedAnswer: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("question") fun question(): String? = question

        @JsonProperty("expectedAnswer") fun expectedAnswer(): String? = expectedAnswer

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Question &&
                this.question == other.question &&
                this.expectedAnswer == other.expectedAnswer &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        question,
                        expectedAnswer,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "Question{question=$question, expectedAnswer=$expectedAnswer, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var question: String? = null
            private var expectedAnswer: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(question: Question) = apply {
                this.question = question.question
                this.expectedAnswer = question.expectedAnswer
                additionalProperties(question.additionalProperties)
            }

            @JsonProperty("question")
            fun question(question: String) = apply { this.question = question }

            @JsonProperty("expectedAnswer")
            fun expectedAnswer(expectedAnswer: String) = apply {
                this.expectedAnswer = expectedAnswer
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Question =
                Question(
                    question,
                    expectedAnswer,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    @JsonDeserialize(builder = UpdatedBy.Builder::class)
    @NoAutoDetect
    class UpdatedBy
    private constructor(
        private val id: String?,
        private val name: String?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("id") fun id(): String? = id

        @JsonProperty("name") fun name(): String? = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is UpdatedBy &&
                this.id == other.id &&
                this.name == other.name &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        id,
                        name,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "UpdatedBy{id=$id, name=$name, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var id: String? = null
            private var name: String? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(updatedBy: UpdatedBy) = apply {
                this.id = updatedBy.id
                this.name = updatedBy.name
                additionalProperties(updatedBy.additionalProperties)
            }

            @JsonProperty("id") fun id(id: String) = apply { this.id = id }

            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): UpdatedBy =
                UpdatedBy(
                    id,
                    name,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }
}
