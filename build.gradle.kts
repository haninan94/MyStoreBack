plugins {
    id("org.springframework.boot") version "3.2.5" apply false
    id("io.spring.dependency-management") version "1.1.4" apply false
}

allprojects {
    group = "com.mystore"
    version = "1.0.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    extensions.configure<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension> {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2023.0.1")
        }
        dependencies {
            dependency("com.mystore:common:${project.version}")
        }
    }

    dependencies {
        add("compileOnly", "org.projectlombok:lombok")
        add("annotationProcessor", "org.projectlombok:lombok")
        add("testImplementation", "org.springframework.boot:spring-boot-starter-test")
    }
}
