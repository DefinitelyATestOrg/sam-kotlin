plugins {
    id("increase.kotlin")
    id("increase.publish")
}

dependencies {
    api(project(":sam-kotlin-client-okhttp"))
}
