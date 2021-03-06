plugins {
    `kotlin-dsl`
    kotlin("jvm")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "0.12.0"
}

repositories {
    google()
}

dependencies {
    api(project(":dsl"))

    implementation(gradleApi())
    implementation(kotlin("stdlib"))
    compileOnly("com.android.tools.build:gradle:4.2.0-alpha13")
}

object Plugin {
    const val id = "studio.forface.easygradle-android"
    const val name = "EasyGradle-Android"
    const val version = "3.0.5" // TODO project.version
}

gradlePlugin {
    plugins {
        create(Plugin.id) {
            id = Plugin.id
            version = Plugin.version
            implementationClass = "studio.forface.easygradle.dsl.android.EasyGradleAndroidPlugin"
        }
    }
}

pluginBundle {
    val url = "https://github.com/4face-studi0/EasyGradle"
    website = url
    vcsUrl = url
    description = "Set of APIs for enrich Gradle DSL ( Android only )"
    tags = listOf(
        "Gradle",
        "plugin",
        "dsl",
        "Kotlin",
        "Android"
    )

    plugins.getByName(Plugin.id).displayName = Plugin.name
}

easyPublish {}
