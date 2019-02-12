plugins {
    id("com.android.library")
    id("kotlin-android-extensions")
    id("kotlin-android")
}

android {
    compileSdkVersion(Versions.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    lintOptions {
        baselineFile = file("lint-baseline.xml")
        isCheckReleaseBuilds = true
        isAbortOnError = true
        isWarningsAsErrors = true
        setLintConfig(File("../lint.xml"))
    }
    testOptions {
        unitTests.setIncludeAndroidResources(true)
    }
}

dependencies {
    testImplementation(Libs.junit)

    testImplementation(Libs.androidTestingSupportLibrary.core)
    testImplementation(Libs.androidTestingSupportLibrary.truth)
    testImplementation(Libs.androidTestingSupportLibrary.rules)
    testImplementation(Libs.androidTestingSupportLibrary.runner)
    testImplementation(Libs.androidTestingSupportLibrary.junit)
    testImplementation(Libs.robolectric)

    implementation(Libs.wrench.core)
    implementation(Libs.support.annotations)
    implementation(Libs.kotlin.stdlib)
}

apply(rootProject.file("gradle/gradle-mvn-push.gradle"))