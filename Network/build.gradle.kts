plugins {
    plugins(
        BuildPlugins.androidLibrary,
        BuildPlugins.kotlinAndroid,
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
        Libraries.timber,
        Libraries.dagger,
        Libraries.retrofit,
        Libraries.retrofitGson,
        Libraries.stethoOkhttp,
        Libraries.retrofitRxjava,
        Libraries.okHttp,
        Libraries.okhttpLoggingInterceptor
    )

    kapt(
        Libraries.daggerCompiler
    )
}