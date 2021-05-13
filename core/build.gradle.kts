plugins {
    plugins(
        BuildPlugins.androidLibrary,
        BuildPlugins.kotlinAndroid
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

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
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
        Libraries.fresco,
        Libraries.timber,
        Libraries.rxAndroid,
        Libraries.navigationFragmentKtx,
        Libraries.navigationUiKtx
    )
}