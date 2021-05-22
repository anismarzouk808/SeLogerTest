object BuildPlugins {

    object Versions {
        const val kotlinVersion = "1.4.31"
        const val gradleVersion = "4.0.0"
    }

    const val seLogerConfigGradleModule = "seloger-config-module"
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlin = "kotlin"
    const val KotlinParcelize = "org.jetbrains.kotlin.plugin.parcelize"
    const val Kapt = "kotlin-kapt"
    const val javaLibrary = "java-library"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"

}

object AndroidSdk {
    const val min = 21
    const val compile = 30
    const val target = compile
}

object Libraries {
    object Versions {
        const val jetpack = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val ktx = "1.1.0"
        const val okHttp: String = "4.9.0"
        const val dagger: String = "2.30.1"
        const val retrofit: String = "2.9.0"
        const val stetho: String = "1.5.1"
        const val fresco: String = "2.3.0"
        const val timber: String = "4.7.1"
        const val navigation: String = "2.3.1"
        const val rxandroid: String = "2.1.1"
        const val rxjava: String = "2.2.11"
        const val androidXCoreKtx = "1.3.2"
        const val androidXLiveDataKtx = "2.2.0"
        const val androidXActivityKtx = "1.2.1"
        const val androidXFragment = "1.3.1"
    }

    const val kotlinStdLib =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${BuildPlugins.Versions.kotlinVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okhttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    /** http://facebook.github.io/stetho/ */
    const val stethoOkhttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"


    /** https://github.com/google/dagger */
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupp = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerAndroidCompiler =
        "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    /** https://square.github.io/retrofit/ */
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitRxjava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    /** https://github.com/facebook/fresco */
    const val fresco = "com.facebook.fresco:fresco:${Versions.fresco}"

    /** https://github.com/JakeWharton/timber */
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val androidXCoreKtx = "androidx.core:core-ktx:${Versions.androidXCoreKtx}"

    // Artifact : https://mvnrepository.com/artifact/androidx.lifecycle/lifecycle-livedata-ktx
    const val androidXLiveDataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidXLiveDataKtx}"
    const val androidXActivityKtx = "androidx.activity:activity-ktx:${Versions.androidXLiveDataKtx}"

    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationRuntimeKtx =
        "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"

    // Artifact : https://mvnrepository.com/artifact/androidx.fragment/fragment-ktx
    const val androidXFragmentKtx = "androidx.fragment:fragment-ktx:${Versions.androidXFragment}"

    /** Rx */
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"


}

object TestLibraries {
    private object Versions {
        const val mockk = "1.10.0"
        const val junit4 = "4.13"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val androidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"

    // https://github.com/mockk/mockk
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
}

