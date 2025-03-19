import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.serialization)
    alias(libs.plugins.kvision)
}

version = "1.0.0"
group = "com.fonrouge.appTestFs"

repositories {
    google()
    mavenCentral()
    mavenLocal()
    maven { url = uri("https://repository.aspose.cloud/repo/") }
}

val mainClassName = "io.ktor.server.netty.EngineMain"

kotlin {
    jvmToolchain(21)
    jvm {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        mainRun {
            mainClass.set(mainClassName)
        }
    }
    js(IR) {
        browser {
            commonWebpackConfig(Action {
                outputFileName = "main.bundle.js"
            })
            runTask(Action {
                sourceMaps = false
            })
            testTask(Action {
                useKarma {
                    useChromeHeadless()
                }
            })
        }
        binaries.executable()
    }
    sourceSets {
        commonMain.dependencies {
            implementation(kotlin("reflect"))
            api(libs.kvision.server.ktor.koin)
            implementation(project(":appTestLib"))
        }
        jvmMain.dependencies {
            implementation(kotlin("stdlib-jdk8"))
            implementation(libs.mssql.jdbc)
            implementation(libs.apache.pdfbox)
            implementation(libs.poi.ooxml)
            implementation(libs.doyaaaaaken.kotlin.csv.jvm)

            implementation(libs.javax.mail.api)
            implementation(libs.javax.mail)
//            implementation("com.sun.mail:pop3:2.0.1")
//            implementation("com.sun.mail:imap:2.0.1")
//            implementation("com.sun.mail:smtp:2.0.1")

            implementation(libs.sdk.twilio)

            implementation(libs.adobe.documentservices.pdfservices.sdk)

            implementation(libs.clicksend.java.client)

            implementation(libs.aspose.cells.cloud)
            implementation(libs.aspose.pdf.cloud)

            implementation(libs.azure.identity)
            implementation(libs.microsoft.graph)

            implementation(libs.kotlinx.html)
        }
    }
}

tasks.withType<Jar> {
    isZip64 = true
}
