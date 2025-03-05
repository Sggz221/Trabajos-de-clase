plugins {
    kotlin("jvm") version "2.0.20"
}

group = "dev.samuel"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // SQLite
    implementation("org.xerial:sqlite-jdbc:3.41.2.1")

    // H2
    implementation("com.h2database:h2:2.1.214")

    // MariaDB
    implementation("org.mariadb.jdbc:mariadb-java-client:3.1.3")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}