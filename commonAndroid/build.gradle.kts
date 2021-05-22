plugins {
    plugins(
        BuildPlugins.androidLibrary,
        BuildPlugins.seLogerConfigGradleModule,
        BuildPlugins.kotlinAndroid
    )
}

android {
    buildFeatures.viewBinding = true

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }
}

dependencies {

    implementations(
        Libraries.fresco,
        Libraries.timber,
        Libraries.navigationUiKtx,
        Libraries.constraintLayout
    )
}