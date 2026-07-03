rootProject.name = "morphe-patches-template"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/MorpheApp/registry")
            credentials {
                // Solo setea credenciales si existen, para evitar IllegalArgumentException
                val user = providers.gradleProperty("gpr.user").orNull ?: System.getenv("GITHUB_ACTOR")
                val token = providers.gradleProperty("gpr.key").orNull ?: System.getenv("GITHUB_TOKEN")
                if (!user.isNullOrBlank() && !token.isNullOrBlank()) {
                    username = user
                    password = token
                }
            }
        }

        maven { url = uri("https://jitpack.io") }
    }
}

plugins {
    id("app.morphe.patches") version "1.3.2"
}
