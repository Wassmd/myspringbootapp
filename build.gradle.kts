import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.21"
	kotlin("plugin.jpa") version "1.9.22"
	kotlin("plugin.spring") version "1.9.21"
}

group = "com.paxier"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

val archUnitVersion = "1.2.1"
val junitVersion = "5.10.1"
val mockkVersion = "1.13.8"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	//api doc
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.4.0")

//	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("com.tngtech.archunit:archunit-junit5-api:$archUnitVersion")
	testImplementation("com.tngtech.archunit:archunit-junit5-engine:$archUnitVersion")
	testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
	testImplementation("org.assertj:assertj-core")
	testImplementation("io.mockk:mockk:$mockkVersion")
	testImplementation("com.ninja-squad:springmockk:3.0.1")
	testImplementation("io.kotest:kotest-runner-junit5-jvm:5.8.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
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
