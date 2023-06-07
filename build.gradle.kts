buildscript {
    val kotlin_version by extra("1.8.10")
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
    repositories {
        mavenCentral()
    }
}
plugins {
    // trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("7.4.0").apply(false)
    id("com.android.library").version("7.4.0").apply(false)
    kotlin("multiplatform").version("1.8.10").apply(false)
    kotlin("plugin.serialization").version("1.8.10").apply(false)
    id("org.jetbrains.kotlin.android").version("1.8.10").apply(false)
    id("org.jetbrains.compose").version("1.4.0").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

