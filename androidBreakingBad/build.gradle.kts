plugins {
    id(Plugins.androidApplication)
    id(Plugins.hilt)
    id(Plugins.sqlDelight)
    kotlin(KotlinPlugins.android)
    kotlin(KotlinPlugins.kapt)
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

android {
    compileSdk = Application.compileSdk
    defaultConfig {
        applicationId = Application.appId
        minSdk = Application.minSdk
        targetSdk = Application.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
        buildFeatures {
            compose = true
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        kotlinOptions {
            jvmTarget = "1.8"
        }
        composeOptions {
            kotlinCompilerExtensionVersion = Compose.composeVersion
        }
    }
    packagingOptions {
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {
    implementation(project(":shared"))

    // Google material
    implementation(Google.material)

    // App compact
    implementation(AndroidX.appCompat)
    implementation(AndroidX.core)

    // Compose
    implementation(Compose.runtime)
    implementation(Compose.runtimeLiveData)
    implementation(Compose.ui)
    implementation(Compose.material)
    implementation(Compose.uiTooling)
    implementation(Compose.foundation)
    implementation(Compose.compiler)
    implementation(Compose.constraintLayout)
    implementation(Compose.activity)
    implementation(Compose.navigation)

    // Hilt
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltAndroidCompiler)
    implementation(Hilt.hiltViewModel)
    kapt(Hilt.hiltCompiler)
    implementation(Hilt.hiltNavigation)

    //Coroutines
    implementation(Coroutines.coroutinesCore)
    implementation(Coroutines.coroutinesAndroid)
    implementation(Coroutines.coroutinesAdapter)

    // Ktor
    implementation(Ktor.android)

    // Coil
    implementation(Accompanist.coil)

    implementation(SQLDelight.runtime)
    implementation(SQLDelight.androidDriver)
    implementation(SQLDelight.nativeDriver)
    implementation("com.squareup.sqldelight:sqlite-driver:1.4.4")

    //Testing
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.0")
    testImplementation("org.mockito:mockito-core:3.11.2")
    testImplementation("org.mockito:mockito-inline:3.11.2")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}