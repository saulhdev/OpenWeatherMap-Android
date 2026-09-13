plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.serialization)
}

allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions {
            freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
            freeCompilerArgs.add("-opt-in=kotlin.time.ExperimentalTime")
        }
    }
}
android {
    namespace = "com.saulhdev.weather.owmlib"
    compileSdk = 37

    defaultConfig {
        minSdk = 23
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        sourceSets {
            getByName("main") {
                java.directories.add("src/main/java")
                aidl.directories.add("src/main/aidl")
                assets.directories.add("src/main/assets")
                res.directories.add("src/main/res")
            }
        }

        buildFeatures {
            compose = true
            dataBinding = true
            viewBinding = true
            buildConfig = true
            aidl = true
        }
    }
}
dependencies {
    implementation(libs.appcompat)
    implementation(libs.core.ktx)
    implementation(libs.okhttp)
    implementation(libs.retrofit) { exclude(module = "okhttp") }
    implementation(libs.retrofit.converter.gson)
}
