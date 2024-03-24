import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import java.util.Properties

plugins {
    kotlin("kapt")
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.taggar.dizi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.taggar.dizi"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        manifestPlaceholders["GOOGLE_MAPS_KEY"] = properties.getProperty("GOOGLE_MAPS_KEY") ?: ""
    }

    buildTypes {
        release {
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
    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    debugImplementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.navigation)
    implementation(libs.hilt)
    implementation(libs.hilt.navigation)
    kapt(libs.hilt.compiler)
    implementation(libs.gson)
    implementation(libs.maps)
//    implementation (libs.coil)
}