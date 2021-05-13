plugins {
    plugins(
        BuildPlugins.androidLibrary,
        BuildPlugins.kotlinAndroid,
        BuildPlugins.kotlinAndroidExtensions,
        BuildPlugins.Kapt
    )
}

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementations(
        Libraries.kotlinStdLib,
        Libraries.timber,
        Libraries.dagger,
        Libraries.rxJava
    )

    testImplementations(
        TestLibraries.junit4,
        TestLibraries.kotlinTest,
        TestLibraries.mockito
    )
}