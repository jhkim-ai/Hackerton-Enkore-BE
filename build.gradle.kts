plugins {
	java
	id("org.springframework.boot") version "2.7.8"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.koscom"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-websocket")
	implementation("com.google.guava:guava:31.1-jre")
	implementation("com.googlecode.json-simple:json-simple:1.1.1")

	runtimeOnly("com.h2database:h2")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
