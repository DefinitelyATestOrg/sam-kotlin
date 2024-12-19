plugins {
    id("sam.kotlin")
    application
}

dependencies {
    implementation(project(":sam-kotlin"))
}

application {
    mainClass = "me.elborai.api.example.MainKt"
}
