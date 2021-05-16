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
        Libraries.kotlinStdLib,
        Libraries.fresco,
        Libraries.timber,
        Libraries.rxAndroid,
        Libraries.navigationFragmentKtx,
        Libraries.navigationUiKtx,
        Libraries.constraintLayout
    )
}