plugins {
    java
    application
    id("org.jetbrains.kotlin.jvm") version "1.9.20"
}

group = "com.diena1dev"
version = "0.0.1"

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("src"))
        }
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.lwjgl:lwjgl:3.3.6")
    implementation("org.lwjgl:lwjgl-opengl:3.3.6")
    implementation("org.lwjgl:lwjgl-glfw:3.3.6")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

// Application Plugin Configuration
application {
    mainClass.set("com.diena1dev.crowrendering.init.Init")
}

// Automatic task execution after build
tasks.register<JavaExec>("runMain") {
    dependsOn("build")
    mainClass.set("com.diena1dev.crowrendering.init.Main")
    classpath = sourceSets.main.get().runtimeClasspath
}

