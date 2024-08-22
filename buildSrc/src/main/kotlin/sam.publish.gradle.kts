import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.get

plugins {
    `maven-publish`
    `signing`
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Swagger Petstore - OpenAPI 3.0")
                description.set("This is a sample Pet Store Server based on the OpenAPI 3.0 specification. You\ncan find out more about Swagger at [http://swagger.io](http://swagger.io). In\nthe third iteration of the pet store, we\'ve switched to the design first\napproach! You can now help us improve the API whether it\'s by making changes to\nthe definition itself or to the code. That way, with time, we can improve the\nAPI in general, and expose some of the new features in OAS3.\n\nSome useful links:\n\n- [The Pet Store repository](https://github.com/swagger-api/swagger-petstore)\n- [The source API definition for the Pet Store](https://github.com/swagger-api/swagger-petstore/blob/master/src/main/resources/openapi.yaml)")
                url.set("https://docs.sam.com.")

                licenses {
                    license {
                        name.set("Apache-2.0")
                    }
                }

                developers {
                    developer {
                        name.set("Sam")
                        email.set("apiteam@swagger.io")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/DefinitelyATestOrg/sam-kotlin.git")
                    developerConnection.set("scm:git:git://github.com/DefinitelyATestOrg/sam-kotlin.git")
                    url.set("https://github.com/DefinitelyATestOrg/sam-kotlin")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
