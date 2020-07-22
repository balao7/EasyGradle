pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        maven("https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "EasyGradle-dokka"

includeBuild("../dsl")

include("plugin")
