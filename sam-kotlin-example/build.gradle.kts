plugins {
    id("sam.kotlin")
    application
}

dependencies {
    implementation(project(":sam-kotlin-core"))
    implementation(project(":sam-kotlin-client-okhttp"))
}

application {
    // Use `./gradlew :sam-kotlin-example:run` to run `Main`
    // Use `./gradlew :sam-kotlin-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "me.elborai.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}ExampleKt"
        else
            "MainKt"
    }"
}
