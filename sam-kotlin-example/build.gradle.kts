plugins {
    id("sam.kotlin")
    application
}

dependencies {
    implementation(project(":sam-kotlin"))
}

application {
    // Use `./gradlew :sam-kotlin-example:run` to run `Main`
    // Use `./gradlew :sam-kotlin-example:run -Dexample=Something` to run `SomethingExample`
    mainClass = "me.elborai.api.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}ExampleKt"
        else
            "MainKt"
    }"
}
