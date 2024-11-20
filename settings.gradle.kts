pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

<<<<<<< HEAD:Codigo-Fonte/App/settings.gradle.kts
rootProject.name = "ArpeFitness"
include(":app")
 
=======
rootProject.name = "Arpe-fitness"
include(":app")
>>>>>>> edbb66bb4f7d7094281b16b939e63aaba8969e12:settings.gradle.kts
