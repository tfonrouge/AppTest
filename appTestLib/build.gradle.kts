plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.serialization)
    alias(libs.plugins.androidLibrary)
    `maven-publish`
}

version = "1.0.0"
group = "com.fonrouge.appTestLib"

repositories {
    google()
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

kotlin {
    jvmToolchain(21)
    jvm {
        compilations.all {
            java {
                targetCompatibility = JavaVersion.VERSION_21
            }
            kotlinOptions {
                jvmTarget = "21"
                freeCompilerArgs = listOf("-Xjsr305=strict")
            }
        }
    }
    js {
        browser()
        binaries.library()
    }
    androidTarget {
        publishLibraryVariants("release", "debug")
    }
    sourceSets {
        commonMain.dependencies {
            api(libs.fonrouge.fslib)
        }
        jvmMain.dependencies {
            implementation(libs.poi.ooxml)
        }
    }
}

android {
    namespace = "com.fonrouge.appTestLib"
    compileSdk = 35
    defaultConfig {
        minSdk = 28
        targetSdk = 35
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}
