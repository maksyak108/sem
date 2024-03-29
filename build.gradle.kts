plugins {
    id("java")
    id("org.springframework.boot") version "2.7.8"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "ru.kpfu.itis"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

tasks.jar {
    enabled = false
    manifest {
        attributes["Main-Class"] = "ru.kpfu.itis.Application"
    }
}

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

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-freemarker:3.0.5")
    implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5:3.0.4.RELEASE")
    implementation("org.liquibase:liquibase-core")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    //spring
    implementation ("org.springframework.boot:spring-boot-starter-mail")

    implementation ("org.thymeleaf:thymeleaf-spring5:3.0.15.RELEASE")

    //db
    implementation("org.postgresql:postgresql:42.5.3")
    //lombok
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")
    //webjars
    implementation ("org.webjars:jquery:3.6.0")
    implementation ("org.webjars:bootstrap:4.6.0")
    implementation ("org.webjars:webjars-locator-core:0.46")
    //test
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    implementation ("javax.mail:javax.mail-api:1.6.2")
}
tasks.getByName<Test>("test") {
    useJUnitPlatform()
}