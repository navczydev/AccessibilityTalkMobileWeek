plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    /*repositories {
        google()
        mavenCentral()
    }*/
    // compileSdk = 31
    compileSdkPreview = "Tiramisu"

    defaultConfig {
        applicationId = "com.example.accessibilitytalkmobileweek"
        minSdk = 23
        targetSdkPreview = "Tiramisu"
        // targetSdkVer("Tiramisu")
        // targetSdkVersion("Tiramisu")

        // targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.1"
    }

    packagingOptions {
        resources.excludes.add("**/attach_hotspot_windows.dll")
        resources.excludes.add("META-INF/licenses/**")
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
    namespace = "com.example.accessibilitytalkmobileweek"
}

dependencies {

    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.espresso:espresso-accessibility:3.4.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    // Integration with activities
    implementation("androidx.activity:activity-compose:1.3.1")
    // Compose Material Design
    implementation("androidx.compose.material:material:${rootProject.ext.get("compose")}")
    // Animations
    implementation("androidx.compose.animation:animation:1.0.1")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.0.1")
    // Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.0.1")
    // When using a MDC theme
    implementation("com.google.android.material:compose-theme-adapter:1.0.1")

    // When using a AppCompat theme
    // implementation "com.google.accompanist:accompanist-appcompat-theme:0.16.0"
}
