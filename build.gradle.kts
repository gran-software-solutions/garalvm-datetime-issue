import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.storage.CacheResetOnProcessCanceled.enabled

plugins {
    kotlin("jvm") version "1.8.21"
    application
    id("org.graalvm.buildtools.native") version "0.9.22"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "17"

val launcherClassName = "MainKt"

graalvmNative {
    toolchainDetection.set(true)

    binaries {
        named("main") {
            imageName.set("application")
            mainClass.set(launcherClassName)
        }
    }
}
