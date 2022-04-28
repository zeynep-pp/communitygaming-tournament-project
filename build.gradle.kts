import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("kapt") version "1.4.32"
}

group = "com.communitygaming"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

extra["testcontainersVersion"] = "1.16.2"

dependencies {
	api("io.jsonwebtoken:jjwt-api:0.11.2")

	implementation("org.mapstruct:mapstruct:1.4.2.Final")
	//implementation("org.modelmapper:modelmapper:2.1.1")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-graphql")
	implementation("org.springframework.boot:spring-boot-starter-integration")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("org.springframework.integration:spring-integration-http")
	implementation("org.springframework.integration:spring-integration-mongodb")
	implementation("org.springframework.session:spring-session-core")
	implementation("org.mongodb:mongo-java-driver:3.12.10")
	implementation("javax.transaction:javax.transaction-api:1.2")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	//implementation("com.graphql-java-kickstart:graphql-java-tools:12.0.2")
	implementation("com.coxautodev:graphql-java-tools:2.1.2")
	implementation("com.graphql-java:graphql-java-tools:5.2.4")
	//implementation("com.graphql-java:graphql-spring-boot-starter:5.0.2")



	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")

	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.2")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.graphql:spring-graphql-test")
	testImplementation("org.springframework.integration:spring-integration-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:mongodb")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		exclude(module = "mockito-core")
	}
	testImplementation("com.ninja-squad:springmockk:3.0.1")

	kapt("org.mapstruct:mapstruct-processor:1.4.2.Final")
}

dependencyManagement {
	imports {
		mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
