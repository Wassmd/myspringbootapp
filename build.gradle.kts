import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.21"
	kotlin("plugin.jpa") version "1.9.22"
	kotlin("plugin.spring") version "1.9.21"
	application
	idea
}

group = "com.paxier"
java.sourceCompatibility = JavaVersion.VERSION_21

val archUnitVersion = "1.2.1"
val junitVersion = "5.10.1"
val mockkVersion = "1.13.8"

repositories {
	mavenCentral()
}

extra["testContainerVersion"] = "1.19.7"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	//api doc
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.4.0")

	// Circuit breaker
	implementation("io.github.resilience4j:resilience4j-spring-boot2:2.2.0")

	// database
	runtimeOnly("com.h2database:h2")

	// Spring Boot Actuator dependencies
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("io.micrometer:micrometer-core")
	implementation("io.micrometer:micrometer-registry-prometheus")

	//Tests
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("com.tngtech.archunit:archunit-junit5-api:$archUnitVersion")
	testImplementation("com.tngtech.archunit:archunit-junit5-engine:$archUnitVersion")
	testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
	testImplementation("org.assertj:assertj-core")
	testImplementation("io.mockk:mockk:$mockkVersion")
	testImplementation("com.ninja-squad:springmockk:3.0.1")
	testImplementation("io.kotest:kotest-runner-junit5-jvm:5.8.0")

	//test containers
	testImplementation ("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:postgresql:1.20.1")
	testImplementation("com.github.dasniko:testcontainers-keycloak:3.4.0")
	runtimeOnly("org.postgresql:postgresql")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

sourceSets {
	test {
		java {
			setSrcDirs(listOf("src/test/intg", "src/test/unit"))
		}
	}
}
