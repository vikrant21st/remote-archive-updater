import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion = "1.5.10"

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.0"
    id("org.jetbrains.compose") version "0.4.0"
}

group = "me.vikrangh"
version = "1.0.0"

repositories {
    mavenLocal()
    jcenter()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
    implementation(project(":ssh-commands-api"))
    implementation(project(":ssh-command-putty"))
    implementation(project(":ssh-command-jsch"))

    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { 
		jvmTarget = "15"
	}
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

compose.desktop {
    application {
        mainClass = "jetbrains.compose.classfileupdator.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Exe) // other formats: TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb
            packageName = "Remote Archive Updater"
        }
    }
}
