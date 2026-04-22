plugins {
    `java-library`
    `maven-publish`
    signing
    id("net.thebugmc.gradle.sonatype-central-portal-publisher") version "1.2.4"
}

group = "co.commet"
version = "2.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
}

dependencies {
    api("com.squareup.okhttp3:okhttp:4.12.0")
    api("com.fasterxml.jackson.core:jackson-databind:2.17.2")

    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.named<ProcessResources>("processResources") {
    val props = mapOf("version" to project.version.toString())
    inputs.properties(props)
    filesMatching("commet-version.properties") {
        expand(props)
    }
}

centralPortal {
    username = providers.gradleProperty("centralPortalUsername")
    password = providers.gradleProperty("centralPortalPassword")

    pom {
        name.set("Commet Java SDK")
        description.set("Billing and usage tracking for SaaS applications")
        url.set("https://github.com/commet-labs/commet-java")

        licenses {
            license {
                name.set("MIT License")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        developers {
            developer {
                id.set("commet")
                name.set("Commet Team")
                email.set("dev@commet.co")
            }
        }

        scm {
            url.set("https://github.com/commet-labs/commet-java")
            connection.set("scm:git:git://github.com/commet-labs/commet-java.git")
            developerConnection.set("scm:git:ssh://github.com/commet-labs/commet-java.git")
        }
    }
}

signing {
    useGpgCmd()
}
