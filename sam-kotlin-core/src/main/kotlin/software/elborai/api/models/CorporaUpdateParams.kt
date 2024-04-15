// File generated from our OpenAPI spec by Stainless.

package software.elborai.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.time.OffsetDateTime
import java.util.Objects
import software.elborai.api.core.Enum
import software.elborai.api.core.ExcludeMissing
import software.elborai.api.core.JsonField
import software.elborai.api.core.JsonValue
import software.elborai.api.core.NoAutoDetect
import software.elborai.api.core.toUnmodifiable
import software.elborai.api.errors.SamInvalidDataException
import software.elborai.api.models.*

class CorporaUpdateParams
constructor(
    private val corpusId: String,
    private val agentId: String,
    private val name: String,
    private val active: Boolean?,
    private val crawlSpec: CrawlSpec?,
    private val createdBy: CreatedBy?,
    private val excludeLastUpdatedBefore: OffsetDateTime?,
    private val htmlTransformer: HtmlTransformer?,
    private val includedKbArticleIds: List<String>?,
    private val integration: Integration?,
    private val integrationCategoryId: String?,
    private val sourceUrl: String?,
    private val status: Status?,
    private val tags: List<String>?,
    private val type: Type?,
    private val updatedBy: UpdatedBy?,
    private val urlExclusionPatterns: List<String>?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun corpusId(): String = corpusId

    fun agentId(): String = agentId

    fun name(): String = name

    fun active(): Boolean? = active

    fun crawlSpec(): CrawlSpec? = crawlSpec

    fun createdBy(): CreatedBy? = createdBy

    fun excludeLastUpdatedBefore(): OffsetDateTime? = excludeLastUpdatedBefore

    fun htmlTransformer(): HtmlTransformer? = htmlTransformer

    fun includedKbArticleIds(): List<String>? = includedKbArticleIds

    fun integration(): Integration? = integration

    fun integrationCategoryId(): String? = integrationCategoryId

    fun sourceUrl(): String? = sourceUrl

    fun status(): Status? = status

    fun tags(): List<String>? = tags

    fun type(): Type? = type

    fun updatedBy(): UpdatedBy? = updatedBy

    fun urlExclusionPatterns(): List<String>? = urlExclusionPatterns

    internal fun getBody(): CorporaUpdateBody {
        return CorporaUpdateBody(
            agentId,
            name,
            active,
            crawlSpec,
            createdBy,
            excludeLastUpdatedBefore,
            htmlTransformer,
            includedKbArticleIds,
            integration,
            integrationCategoryId,
            sourceUrl,
            status,
            tags,
            type,
            updatedBy,
            urlExclusionPatterns,
            additionalBodyProperties,
        )
    }

    internal fun getQueryParams(): Map<String, List<String>> = additionalQueryParams

    internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> corpusId
            else -> ""
        }
    }

    @JsonDeserialize(builder = CorporaUpdateBody.Builder::class)
    @NoAutoDetect
    class CorporaUpdateBody
    internal constructor(
        private val agentId: String?,
        private val name: String?,
        private val active: Boolean?,
        private val crawlSpec: CrawlSpec?,
        private val createdBy: CreatedBy?,
        private val excludeLastUpdatedBefore: OffsetDateTime?,
        private val htmlTransformer: HtmlTransformer?,
        private val includedKbArticleIds: List<String>?,
        private val integration: Integration?,
        private val integrationCategoryId: String?,
        private val sourceUrl: String?,
        private val status: Status?,
        private val tags: List<String>?,
        private val type: Type?,
        private val updatedBy: UpdatedBy?,
        private val urlExclusionPatterns: List<String>?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("agentId") fun agentId(): String? = agentId

        @JsonProperty("name") fun name(): String? = name

        @JsonProperty("active") fun active(): Boolean? = active

        @JsonProperty("crawlSpec") fun crawlSpec(): CrawlSpec? = crawlSpec

        @JsonProperty("createdBy") fun createdBy(): CreatedBy? = createdBy

        @JsonProperty("excludeLastUpdatedBefore")
        fun excludeLastUpdatedBefore(): OffsetDateTime? = excludeLastUpdatedBefore

        @JsonProperty("htmlTransformer") fun htmlTransformer(): HtmlTransformer? = htmlTransformer

        @JsonProperty("includedKbArticleIds")
        fun includedKbArticleIds(): List<String>? = includedKbArticleIds

        @JsonProperty("integration") fun integration(): Integration? = integration

        @JsonProperty("integrationCategoryId")
        fun integrationCategoryId(): String? = integrationCategoryId

        @JsonProperty("sourceUrl") fun sourceUrl(): String? = sourceUrl

        @JsonProperty("status") fun status(): Status? = status

        @JsonProperty("tags") fun tags(): List<String>? = tags

        @JsonProperty("type") fun type(): Type? = type

        @JsonProperty("updatedBy") fun updatedBy(): UpdatedBy? = updatedBy

        @JsonProperty("urlExclusionPatterns")
        fun urlExclusionPatterns(): List<String>? = urlExclusionPatterns

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CorporaUpdateBody &&
                this.agentId == other.agentId &&
                this.name == other.name &&
                this.active == other.active &&
                this.crawlSpec == other.crawlSpec &&
                this.createdBy == other.createdBy &&
                this.excludeLastUpdatedBefore == other.excludeLastUpdatedBefore &&
                this.htmlTransformer == other.htmlTransformer &&
                this.includedKbArticleIds == other.includedKbArticleIds &&
                this.integration == other.integration &&
                this.integrationCategoryId == other.integrationCategoryId &&
                this.sourceUrl == other.sourceUrl &&
                this.status == other.status &&
                this.tags == other.tags &&
                this.type == other.type &&
                this.updatedBy == other.updatedBy &&
                this.urlExclusionPatterns == other.urlExclusionPatterns &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        agentId,
                        name,
                        active,
                        crawlSpec,
                        createdBy,
                        excludeLastUpdatedBefore,
                        htmlTransformer,
                        includedKbArticleIds,
                        integration,
                        integrationCategoryId,
                        sourceUrl,
                        status,
                        tags,
                        type,
                        updatedBy,
                        urlExclusionPatterns,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CorporaUpdateBody{agentId=$agentId, name=$name, active=$active, crawlSpec=$crawlSpec, createdBy=$createdBy, excludeLastUpdatedBefore=$excludeLastUpdatedBefore, htmlTransformer=$htmlTransformer, includedKbArticleIds=$includedKbArticleIds, integration=$integration, integrationCategoryId=$integrationCategoryId, sourceUrl=$sourceUrl, status=$status, tags=$tags, type=$type, updatedBy=$updatedBy, urlExclusionPatterns=$urlExclusionPatterns, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var agentId: String? = null
            private var name: String? = null
            private var active: Boolean? = null
            private var crawlSpec: CrawlSpec? = null
            private var createdBy: CreatedBy? = null
            private var excludeLastUpdatedBefore: OffsetDateTime? = null
            private var htmlTransformer: HtmlTransformer? = null
            private var includedKbArticleIds: List<String>? = null
            private var integration: Integration? = null
            private var integrationCategoryId: String? = null
            private var sourceUrl: String? = null
            private var status: Status? = null
            private var tags: List<String>? = null
            private var type: Type? = null
            private var updatedBy: UpdatedBy? = null
            private var urlExclusionPatterns: List<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(corporaUpdateBody: CorporaUpdateBody) = apply {
                this.agentId = corporaUpdateBody.agentId
                this.name = corporaUpdateBody.name
                this.active = corporaUpdateBody.active
                this.crawlSpec = corporaUpdateBody.crawlSpec
                this.createdBy = corporaUpdateBody.createdBy
                this.excludeLastUpdatedBefore = corporaUpdateBody.excludeLastUpdatedBefore
                this.htmlTransformer = corporaUpdateBody.htmlTransformer
                this.includedKbArticleIds = corporaUpdateBody.includedKbArticleIds
                this.integration = corporaUpdateBody.integration
                this.integrationCategoryId = corporaUpdateBody.integrationCategoryId
                this.sourceUrl = corporaUpdateBody.sourceUrl
                this.status = corporaUpdateBody.status
                this.tags = corporaUpdateBody.tags
                this.type = corporaUpdateBody.type
                this.updatedBy = corporaUpdateBody.updatedBy
                this.urlExclusionPatterns = corporaUpdateBody.urlExclusionPatterns
                additionalProperties(corporaUpdateBody.additionalProperties)
            }

            @JsonProperty("agentId") fun agentId(agentId: String) = apply { this.agentId = agentId }

            @JsonProperty("name") fun name(name: String) = apply { this.name = name }

            @JsonProperty("active") fun active(active: Boolean) = apply { this.active = active }

            @JsonProperty("crawlSpec")
            fun crawlSpec(crawlSpec: CrawlSpec) = apply { this.crawlSpec = crawlSpec }

            @JsonProperty("createdBy")
            fun createdBy(createdBy: CreatedBy) = apply { this.createdBy = createdBy }

            @JsonProperty("excludeLastUpdatedBefore")
            fun excludeLastUpdatedBefore(excludeLastUpdatedBefore: OffsetDateTime) = apply {
                this.excludeLastUpdatedBefore = excludeLastUpdatedBefore
            }

            @JsonProperty("htmlTransformer")
            fun htmlTransformer(htmlTransformer: HtmlTransformer) = apply {
                this.htmlTransformer = htmlTransformer
            }

            @JsonProperty("includedKbArticleIds")
            fun includedKbArticleIds(includedKbArticleIds: List<String>) = apply {
                this.includedKbArticleIds = includedKbArticleIds
            }

            @JsonProperty("integration")
            fun integration(integration: Integration) = apply { this.integration = integration }

            @JsonProperty("integrationCategoryId")
            fun integrationCategoryId(integrationCategoryId: String) = apply {
                this.integrationCategoryId = integrationCategoryId
            }

            @JsonProperty("sourceUrl")
            fun sourceUrl(sourceUrl: String) = apply { this.sourceUrl = sourceUrl }

            @JsonProperty("status") fun status(status: Status) = apply { this.status = status }

            @JsonProperty("tags") fun tags(tags: List<String>) = apply { this.tags = tags }

            @JsonProperty("type") fun type(type: Type) = apply { this.type = type }

            @JsonProperty("updatedBy")
            fun updatedBy(updatedBy: UpdatedBy) = apply { this.updatedBy = updatedBy }

            @JsonProperty("urlExclusionPatterns")
            fun urlExclusionPatterns(urlExclusionPatterns: List<String>) = apply {
                this.urlExclusionPatterns = urlExclusionPatterns
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

            fun build(): CorporaUpdateBody =
                CorporaUpdateBody(
                    checkNotNull(agentId) { "`agentId` is required but was not set" },
                    checkNotNull(name) { "`name` is required but was not set" },
                    active,
                    crawlSpec,
                    createdBy,
                    excludeLastUpdatedBefore,
                    htmlTransformer,
                    includedKbArticleIds?.toUnmodifiable(),
                    integration,
                    integrationCategoryId,
                    sourceUrl,
                    status,
                    tags?.toUnmodifiable(),
                    type,
                    updatedBy,
                    urlExclusionPatterns?.toUnmodifiable(),
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

        return other is CorporaUpdateParams &&
            this.corpusId == other.corpusId &&
            this.agentId == other.agentId &&
            this.name == other.name &&
            this.active == other.active &&
            this.crawlSpec == other.crawlSpec &&
            this.createdBy == other.createdBy &&
            this.excludeLastUpdatedBefore == other.excludeLastUpdatedBefore &&
            this.htmlTransformer == other.htmlTransformer &&
            this.includedKbArticleIds == other.includedKbArticleIds &&
            this.integration == other.integration &&
            this.integrationCategoryId == other.integrationCategoryId &&
            this.sourceUrl == other.sourceUrl &&
            this.status == other.status &&
            this.tags == other.tags &&
            this.type == other.type &&
            this.updatedBy == other.updatedBy &&
            this.urlExclusionPatterns == other.urlExclusionPatterns &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            corpusId,
            agentId,
            name,
            active,
            crawlSpec,
            createdBy,
            excludeLastUpdatedBefore,
            htmlTransformer,
            includedKbArticleIds,
            integration,
            integrationCategoryId,
            sourceUrl,
            status,
            tags,
            type,
            updatedBy,
            urlExclusionPatterns,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "CorporaUpdateParams{corpusId=$corpusId, agentId=$agentId, name=$name, active=$active, crawlSpec=$crawlSpec, createdBy=$createdBy, excludeLastUpdatedBefore=$excludeLastUpdatedBefore, htmlTransformer=$htmlTransformer, includedKbArticleIds=$includedKbArticleIds, integration=$integration, integrationCategoryId=$integrationCategoryId, sourceUrl=$sourceUrl, status=$status, tags=$tags, type=$type, updatedBy=$updatedBy, urlExclusionPatterns=$urlExclusionPatterns, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var corpusId: String? = null
        private var agentId: String? = null
        private var name: String? = null
        private var active: Boolean? = null
        private var crawlSpec: CrawlSpec? = null
        private var createdBy: CreatedBy? = null
        private var excludeLastUpdatedBefore: OffsetDateTime? = null
        private var htmlTransformer: HtmlTransformer? = null
        private var includedKbArticleIds: MutableList<String> = mutableListOf()
        private var integration: Integration? = null
        private var integrationCategoryId: String? = null
        private var sourceUrl: String? = null
        private var status: Status? = null
        private var tags: MutableList<String> = mutableListOf()
        private var type: Type? = null
        private var updatedBy: UpdatedBy? = null
        private var urlExclusionPatterns: MutableList<String> = mutableListOf()
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        internal fun from(corporaUpdateParams: CorporaUpdateParams) = apply {
            this.corpusId = corporaUpdateParams.corpusId
            this.agentId = corporaUpdateParams.agentId
            this.name = corporaUpdateParams.name
            this.active = corporaUpdateParams.active
            this.crawlSpec = corporaUpdateParams.crawlSpec
            this.createdBy = corporaUpdateParams.createdBy
            this.excludeLastUpdatedBefore = corporaUpdateParams.excludeLastUpdatedBefore
            this.htmlTransformer = corporaUpdateParams.htmlTransformer
            this.includedKbArticleIds(corporaUpdateParams.includedKbArticleIds ?: listOf())
            this.integration = corporaUpdateParams.integration
            this.integrationCategoryId = corporaUpdateParams.integrationCategoryId
            this.sourceUrl = corporaUpdateParams.sourceUrl
            this.status = corporaUpdateParams.status
            this.tags(corporaUpdateParams.tags ?: listOf())
            this.type = corporaUpdateParams.type
            this.updatedBy = corporaUpdateParams.updatedBy
            this.urlExclusionPatterns(corporaUpdateParams.urlExclusionPatterns ?: listOf())
            additionalQueryParams(corporaUpdateParams.additionalQueryParams)
            additionalHeaders(corporaUpdateParams.additionalHeaders)
            additionalBodyProperties(corporaUpdateParams.additionalBodyProperties)
        }

        fun corpusId(corpusId: String) = apply { this.corpusId = corpusId }

        fun agentId(agentId: String) = apply { this.agentId = agentId }

        fun name(name: String) = apply { this.name = name }

        fun active(active: Boolean) = apply { this.active = active }

        fun crawlSpec(crawlSpec: CrawlSpec) = apply { this.crawlSpec = crawlSpec }

        fun createdBy(createdBy: CreatedBy) = apply { this.createdBy = createdBy }

        fun excludeLastUpdatedBefore(excludeLastUpdatedBefore: OffsetDateTime) = apply {
            this.excludeLastUpdatedBefore = excludeLastUpdatedBefore
        }

        fun htmlTransformer(htmlTransformer: HtmlTransformer) = apply {
            this.htmlTransformer = htmlTransformer
        }

        fun includedKbArticleIds(includedKbArticleIds: List<String>) = apply {
            this.includedKbArticleIds.clear()
            this.includedKbArticleIds.addAll(includedKbArticleIds)
        }

        fun addIncludedKbArticleId(includedKbArticleId: String) = apply {
            this.includedKbArticleIds.add(includedKbArticleId)
        }

        fun integration(integration: Integration) = apply { this.integration = integration }

        fun integrationCategoryId(integrationCategoryId: String) = apply {
            this.integrationCategoryId = integrationCategoryId
        }

        fun sourceUrl(sourceUrl: String) = apply { this.sourceUrl = sourceUrl }

        fun status(status: Status) = apply { this.status = status }

        fun tags(tags: List<String>) = apply {
            this.tags.clear()
            this.tags.addAll(tags)
        }

        fun addTag(tag: String) = apply { this.tags.add(tag) }

        fun type(type: Type) = apply { this.type = type }

        fun updatedBy(updatedBy: UpdatedBy) = apply { this.updatedBy = updatedBy }

        fun urlExclusionPatterns(urlExclusionPatterns: List<String>) = apply {
            this.urlExclusionPatterns.clear()
            this.urlExclusionPatterns.addAll(urlExclusionPatterns)
        }

        fun addUrlExclusionPattern(urlExclusionPattern: String) = apply {
            this.urlExclusionPatterns.add(urlExclusionPattern)
        }

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

        fun build(): CorporaUpdateParams =
            CorporaUpdateParams(
                checkNotNull(corpusId) { "`corpusId` is required but was not set" },
                checkNotNull(agentId) { "`agentId` is required but was not set" },
                checkNotNull(name) { "`name` is required but was not set" },
                active,
                crawlSpec,
                createdBy,
                excludeLastUpdatedBefore,
                htmlTransformer,
                if (includedKbArticleIds.size == 0) null else includedKbArticleIds.toUnmodifiable(),
                integration,
                integrationCategoryId,
                sourceUrl,
                status,
                if (tags.size == 0) null else tags.toUnmodifiable(),
                type,
                updatedBy,
                if (urlExclusionPatterns.size == 0) null else urlExclusionPatterns.toUnmodifiable(),
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = CrawlSpec.Builder::class)
    @NoAutoDetect
    class CrawlSpec
    private constructor(
        private val ingestionWorkflowId: String?,
        private val startUrls: List<String>?,
        private val exclusionPatterns: List<String>?,
        private val htmlTransformer: HtmlTransformer?,
        private val removeElementsCssSelector: String?,
        private val maxCrawlDepth: Long?,
        private val maxCrawlPages: Long?,
        private val initialConcurrency: Long?,
        private val maxConcurrency: Long?,
        private val timeoutSeconds: Long?,
        private val saveHtml: Boolean?,
        private val saveMarkdown: Boolean?,
        private val useSitemaps: Boolean?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("ingestionWorkflowId")
        fun ingestionWorkflowId(): String? = ingestionWorkflowId

        @JsonProperty("startUrls") fun startUrls(): List<String>? = startUrls

        @JsonProperty("exclusionPatterns")
        fun exclusionPatterns(): List<String>? = exclusionPatterns

        @JsonProperty("htmlTransformer") fun htmlTransformer(): HtmlTransformer? = htmlTransformer

        @JsonProperty("removeElementsCssSelector")
        fun removeElementsCssSelector(): String? = removeElementsCssSelector

        @JsonProperty("maxCrawlDepth") fun maxCrawlDepth(): Long? = maxCrawlDepth

        @JsonProperty("maxCrawlPages") fun maxCrawlPages(): Long? = maxCrawlPages

        @JsonProperty("initialConcurrency") fun initialConcurrency(): Long? = initialConcurrency

        @JsonProperty("maxConcurrency") fun maxConcurrency(): Long? = maxConcurrency

        @JsonProperty("timeoutSeconds") fun timeoutSeconds(): Long? = timeoutSeconds

        @JsonProperty("saveHtml") fun saveHtml(): Boolean? = saveHtml

        @JsonProperty("saveMarkdown") fun saveMarkdown(): Boolean? = saveMarkdown

        @JsonProperty("useSitemaps") fun useSitemaps(): Boolean? = useSitemaps

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CrawlSpec &&
                this.ingestionWorkflowId == other.ingestionWorkflowId &&
                this.startUrls == other.startUrls &&
                this.exclusionPatterns == other.exclusionPatterns &&
                this.htmlTransformer == other.htmlTransformer &&
                this.removeElementsCssSelector == other.removeElementsCssSelector &&
                this.maxCrawlDepth == other.maxCrawlDepth &&
                this.maxCrawlPages == other.maxCrawlPages &&
                this.initialConcurrency == other.initialConcurrency &&
                this.maxConcurrency == other.maxConcurrency &&
                this.timeoutSeconds == other.timeoutSeconds &&
                this.saveHtml == other.saveHtml &&
                this.saveMarkdown == other.saveMarkdown &&
                this.useSitemaps == other.useSitemaps &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        ingestionWorkflowId,
                        startUrls,
                        exclusionPatterns,
                        htmlTransformer,
                        removeElementsCssSelector,
                        maxCrawlDepth,
                        maxCrawlPages,
                        initialConcurrency,
                        maxConcurrency,
                        timeoutSeconds,
                        saveHtml,
                        saveMarkdown,
                        useSitemaps,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "CrawlSpec{ingestionWorkflowId=$ingestionWorkflowId, startUrls=$startUrls, exclusionPatterns=$exclusionPatterns, htmlTransformer=$htmlTransformer, removeElementsCssSelector=$removeElementsCssSelector, maxCrawlDepth=$maxCrawlDepth, maxCrawlPages=$maxCrawlPages, initialConcurrency=$initialConcurrency, maxConcurrency=$maxConcurrency, timeoutSeconds=$timeoutSeconds, saveHtml=$saveHtml, saveMarkdown=$saveMarkdown, useSitemaps=$useSitemaps, additionalProperties=$additionalProperties}"

        companion object {

            fun builder() = Builder()
        }

        class Builder {

            private var ingestionWorkflowId: String? = null
            private var startUrls: List<String>? = null
            private var exclusionPatterns: List<String>? = null
            private var htmlTransformer: HtmlTransformer? = null
            private var removeElementsCssSelector: String? = null
            private var maxCrawlDepth: Long? = null
            private var maxCrawlPages: Long? = null
            private var initialConcurrency: Long? = null
            private var maxConcurrency: Long? = null
            private var timeoutSeconds: Long? = null
            private var saveHtml: Boolean? = null
            private var saveMarkdown: Boolean? = null
            private var useSitemaps: Boolean? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            internal fun from(crawlSpec: CrawlSpec) = apply {
                this.ingestionWorkflowId = crawlSpec.ingestionWorkflowId
                this.startUrls = crawlSpec.startUrls
                this.exclusionPatterns = crawlSpec.exclusionPatterns
                this.htmlTransformer = crawlSpec.htmlTransformer
                this.removeElementsCssSelector = crawlSpec.removeElementsCssSelector
                this.maxCrawlDepth = crawlSpec.maxCrawlDepth
                this.maxCrawlPages = crawlSpec.maxCrawlPages
                this.initialConcurrency = crawlSpec.initialConcurrency
                this.maxConcurrency = crawlSpec.maxConcurrency
                this.timeoutSeconds = crawlSpec.timeoutSeconds
                this.saveHtml = crawlSpec.saveHtml
                this.saveMarkdown = crawlSpec.saveMarkdown
                this.useSitemaps = crawlSpec.useSitemaps
                additionalProperties(crawlSpec.additionalProperties)
            }

            @JsonProperty("ingestionWorkflowId")
            fun ingestionWorkflowId(ingestionWorkflowId: String) = apply {
                this.ingestionWorkflowId = ingestionWorkflowId
            }

            @JsonProperty("startUrls")
            fun startUrls(startUrls: List<String>) = apply { this.startUrls = startUrls }

            @JsonProperty("exclusionPatterns")
            fun exclusionPatterns(exclusionPatterns: List<String>) = apply {
                this.exclusionPatterns = exclusionPatterns
            }

            @JsonProperty("htmlTransformer")
            fun htmlTransformer(htmlTransformer: HtmlTransformer) = apply {
                this.htmlTransformer = htmlTransformer
            }

            @JsonProperty("removeElementsCssSelector")
            fun removeElementsCssSelector(removeElementsCssSelector: String) = apply {
                this.removeElementsCssSelector = removeElementsCssSelector
            }

            @JsonProperty("maxCrawlDepth")
            fun maxCrawlDepth(maxCrawlDepth: Long) = apply { this.maxCrawlDepth = maxCrawlDepth }

            @JsonProperty("maxCrawlPages")
            fun maxCrawlPages(maxCrawlPages: Long) = apply { this.maxCrawlPages = maxCrawlPages }

            @JsonProperty("initialConcurrency")
            fun initialConcurrency(initialConcurrency: Long) = apply {
                this.initialConcurrency = initialConcurrency
            }

            @JsonProperty("maxConcurrency")
            fun maxConcurrency(maxConcurrency: Long) = apply {
                this.maxConcurrency = maxConcurrency
            }

            @JsonProperty("timeoutSeconds")
            fun timeoutSeconds(timeoutSeconds: Long) = apply {
                this.timeoutSeconds = timeoutSeconds
            }

            @JsonProperty("saveHtml")
            fun saveHtml(saveHtml: Boolean) = apply { this.saveHtml = saveHtml }

            @JsonProperty("saveMarkdown")
            fun saveMarkdown(saveMarkdown: Boolean) = apply { this.saveMarkdown = saveMarkdown }

            @JsonProperty("useSitemaps")
            fun useSitemaps(useSitemaps: Boolean) = apply { this.useSitemaps = useSitemaps }

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

            fun build(): CrawlSpec =
                CrawlSpec(
                    ingestionWorkflowId,
                    startUrls?.toUnmodifiable(),
                    exclusionPatterns?.toUnmodifiable(),
                    htmlTransformer,
                    removeElementsCssSelector,
                    maxCrawlDepth,
                    maxCrawlPages,
                    initialConcurrency,
                    maxConcurrency,
                    timeoutSeconds,
                    saveHtml,
                    saveMarkdown,
                    useSitemaps,
                    additionalProperties.toUnmodifiable(),
                )
        }

        class HtmlTransformer
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is HtmlTransformer && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                val NONE = HtmlTransformer(JsonField.of("NONE"))

                val EXTRACTUS = HtmlTransformer(JsonField.of("EXTRACTUS"))

                val READABLE_TEXT = HtmlTransformer(JsonField.of("READABLE_TEXT"))

                val READABLE_TEXT_IF_POSSIBLE =
                    HtmlTransformer(JsonField.of("READABLE_TEXT_IF_POSSIBLE"))

                fun of(value: String) = HtmlTransformer(JsonField.of(value))
            }

            enum class Known {
                NONE,
                EXTRACTUS,
                READABLE_TEXT,
                READABLE_TEXT_IF_POSSIBLE,
            }

            enum class Value {
                NONE,
                EXTRACTUS,
                READABLE_TEXT,
                READABLE_TEXT_IF_POSSIBLE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    NONE -> Value.NONE
                    EXTRACTUS -> Value.EXTRACTUS
                    READABLE_TEXT -> Value.READABLE_TEXT
                    READABLE_TEXT_IF_POSSIBLE -> Value.READABLE_TEXT_IF_POSSIBLE
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    NONE -> Known.NONE
                    EXTRACTUS -> Known.EXTRACTUS
                    READABLE_TEXT -> Known.READABLE_TEXT
                    READABLE_TEXT_IF_POSSIBLE -> Known.READABLE_TEXT_IF_POSSIBLE
                    else -> throw SamInvalidDataException("Unknown HtmlTransformer: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
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

    class HtmlTransformer
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is HtmlTransformer && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val NONE = HtmlTransformer(JsonField.of("NONE"))

            val EXTRACTUS = HtmlTransformer(JsonField.of("EXTRACTUS"))

            val READABLE_TEXT = HtmlTransformer(JsonField.of("READABLE_TEXT"))

            val READABLE_TEXT_IF_POSSIBLE =
                HtmlTransformer(JsonField.of("READABLE_TEXT_IF_POSSIBLE"))

            fun of(value: String) = HtmlTransformer(JsonField.of(value))
        }

        enum class Known {
            NONE,
            EXTRACTUS,
            READABLE_TEXT,
            READABLE_TEXT_IF_POSSIBLE,
        }

        enum class Value {
            NONE,
            EXTRACTUS,
            READABLE_TEXT,
            READABLE_TEXT_IF_POSSIBLE,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                NONE -> Value.NONE
                EXTRACTUS -> Value.EXTRACTUS
                READABLE_TEXT -> Value.READABLE_TEXT
                READABLE_TEXT_IF_POSSIBLE -> Value.READABLE_TEXT_IF_POSSIBLE
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                NONE -> Known.NONE
                EXTRACTUS -> Known.EXTRACTUS
                READABLE_TEXT -> Known.READABLE_TEXT
                READABLE_TEXT_IF_POSSIBLE -> Known.READABLE_TEXT_IF_POSSIBLE
                else -> throw SamInvalidDataException("Unknown HtmlTransformer: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Integration
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Integration && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val SALESFORCE = Integration(JsonField.of("SALESFORCE"))

            val ZENDESK = Integration(JsonField.of("ZENDESK"))

            val FRESHDESK = Integration(JsonField.of("FRESHDESK"))

            val SLACK_QA_BOT = Integration(JsonField.of("SLACK_QA_BOT"))

            val TWILIO = Integration(JsonField.of("TWILIO"))

            fun of(value: String) = Integration(JsonField.of(value))
        }

        enum class Known {
            SALESFORCE,
            ZENDESK,
            FRESHDESK,
            SLACK_QA_BOT,
            TWILIO,
        }

        enum class Value {
            SALESFORCE,
            ZENDESK,
            FRESHDESK,
            SLACK_QA_BOT,
            TWILIO,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                SALESFORCE -> Value.SALESFORCE
                ZENDESK -> Value.ZENDESK
                FRESHDESK -> Value.FRESHDESK
                SLACK_QA_BOT -> Value.SLACK_QA_BOT
                TWILIO -> Value.TWILIO
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                SALESFORCE -> Known.SALESFORCE
                ZENDESK -> Known.ZENDESK
                FRESHDESK -> Known.FRESHDESK
                SLACK_QA_BOT -> Known.SLACK_QA_BOT
                TWILIO -> Known.TWILIO
                else -> throw SamInvalidDataException("Unknown Integration: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val PROCESSING = Status(JsonField.of("PROCESSING"))

            val READY = Status(JsonField.of("READY"))

            val FAILED = Status(JsonField.of("FAILED"))

            fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            PROCESSING,
            READY,
            FAILED,
        }

        enum class Value {
            PROCESSING,
            READY,
            FAILED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                PROCESSING -> Value.PROCESSING
                READY -> Value.READY
                FAILED -> Value.FAILED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                PROCESSING -> Known.PROCESSING
                READY -> Known.READY
                FAILED -> Known.FAILED
                else -> throw SamInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Type && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            val URL = Type(JsonField.of("URL"))

            val MANUAL = Type(JsonField.of("MANUAL"))

            val FILE_UPLOAD = Type(JsonField.of("FILE_UPLOAD"))

            val EXTERNAL_INTEGRATION = Type(JsonField.of("EXTERNAL_INTEGRATION"))

            val FRESHDESK_KB = Type(JsonField.of("FRESHDESK_KB"))

            val ZENDESK_KB = Type(JsonField.of("ZENDESK_KB"))

            val CSV = Type(JsonField.of("CSV"))

            val UNKNOWN = Type(JsonField.of("UNKNOWN"))

            fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            URL,
            MANUAL,
            FILE_UPLOAD,
            EXTERNAL_INTEGRATION,
            FRESHDESK_KB,
            ZENDESK_KB,
            CSV,
            UNKNOWN,
        }

        enum class Value {
            URL,
            MANUAL,
            FILE_UPLOAD,
            EXTERNAL_INTEGRATION,
            FRESHDESK_KB,
            ZENDESK_KB,
            CSV,
            UNKNOWN,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                URL -> Value.URL
                MANUAL -> Value.MANUAL
                FILE_UPLOAD -> Value.FILE_UPLOAD
                EXTERNAL_INTEGRATION -> Value.EXTERNAL_INTEGRATION
                FRESHDESK_KB -> Value.FRESHDESK_KB
                ZENDESK_KB -> Value.ZENDESK_KB
                CSV -> Value.CSV
                UNKNOWN -> Value.UNKNOWN
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                URL -> Known.URL
                MANUAL -> Known.MANUAL
                FILE_UPLOAD -> Known.FILE_UPLOAD
                EXTERNAL_INTEGRATION -> Known.EXTERNAL_INTEGRATION
                FRESHDESK_KB -> Known.FRESHDESK_KB
                ZENDESK_KB -> Known.ZENDESK_KB
                CSV -> Known.CSV
                UNKNOWN -> Known.UNKNOWN
                else -> throw SamInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
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
