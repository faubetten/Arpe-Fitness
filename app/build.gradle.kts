plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
<<<<<<< HEAD:Codigo-Fonte/App/app/build.gradle.kts
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.arpefitness"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.arpefitness"
=======
}

android {
    namespace = "pt.iade.arpefitness"
    compileSdk = 35

    defaultConfig {
        applicationId = "pt.iade.arpefitness"
>>>>>>> edbb66bb4f7d7094281b16b939e63aaba8969e12:app/build.gradle.kts
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
<<<<<<< HEAD:Codigo-Fonte/App/app/build.gradle.kts
=======
        vectorDrawables {
            useSupportLibrary = true
        }
>>>>>>> edbb66bb4f7d7094281b16b939e63aaba8969e12:app/build.gradle.kts
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
<<<<<<< HEAD:Codigo-Fonte/App/app/build.gradle.kts
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
=======
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
>>>>>>> edbb66bb4f7d7094281b16b939e63aaba8969e12:app/build.gradle.kts
    }
    buildFeatures {
        compose = true
    }
<<<<<<< HEAD:Codigo-Fonte/App/app/build.gradle.kts
=======
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
>>>>>>> edbb66bb4f7d7094281b16b939e63aaba8969e12:app/build.gradle.kts
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
<<<<<<< HEAD:Codigo-Fonte/App/app/build.gradle.kts
=======
    implementation(libs.androidx.room.runtime.android)
>>>>>>> edbb66bb4f7d7094281b16b939e63aaba8969e12:app/build.gradle.kts
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}