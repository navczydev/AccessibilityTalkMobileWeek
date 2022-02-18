// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    val kotlinVersion = "1.5.21"
    val gradlePluginVersion = "7.1.1"

    dependencies {
        classpath("com.android.tools.build:gradle:$gradlePluginVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
allprojects {
    ext {
        set("compose", "1.0.1")
    }
}
task("clean", Delete::class) {
    delete(rootProject.buildDir)
}
