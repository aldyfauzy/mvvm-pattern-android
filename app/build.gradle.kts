@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id (libs.plugins.android.appliation.get().pluginId)
    id (libs.plugins.kotlin.android.get().pluginId)
    id (libs.plugins.kotlin.kapt.get().pluginId)
    id (libs.plugins.kotlin.navigation.safeargs.get().pluginId)
    id (libs.plugins.kotlin.parcelize.get().pluginId)
    id (libs.plugins.hilt.plugin.get().pluginId)
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.aldy.mvvm"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraint)
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.expresso)

    //material
    implementation(libs.material)

    //navigation component
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    //dagger hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.lifecycle)
    kapt(libs.androidx.hilt.compiler)

    //retrofit GSON
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    //paging 3
    implementation(libs.androidx.paging)

    //glide
    implementation(libs.glide)

    //room components
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    androidTestImplementation(libs.androidx.room.testing)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    //lifecycle components
    implementation(libs.androidx.lifecycle.extension)
    annotationProcessor (libs.androidx.lifecycle.compiler)

    /*implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraint)

    implementation(libs.androidx.lifecycle)

    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)

    implementation(libs.glide)
    implementation(libs.glide.pallete)

    implementation(libs.androidx.paging)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    androidTestImplementation(libs.hilt.testing)
    kaptAndroidTest(libs.hilt.compiler)

    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    androidTestImplementation(libs.androidx.room.testing)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    implementation(libs.androidx.lifecycle.extension)
    kapt(libs.androidx.hilt.compiler)
    annotationProcessor (libs.androidx.lifecycle.compiler)

    implementation(libs.coroutines)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.expresso)*/
}

kapt {
    correctErrorTypes = true
}