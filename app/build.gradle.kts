plugins {
    plugins(
        BuildPlugins.androidApplication,
        BuildPlugins.seLogerConfigGradleModule,
        BuildPlugins.kotlinAndroid,
        BuildPlugins.Kapt
    )
}

android {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }
}

dependencies {

    implementationProjects(
        ":common",
        ":data",
        ":presentation",
        ":domain",
        ":Network"
    )

    implementations(
        Libraries.kotlinStdLib,
        Libraries.fresco,
        Libraries.timber,
        Libraries.retrofit,
        Libraries.retrofitRxjava,
        Libraries.retrofitGson,
        Libraries.okHttp,
        Libraries.okhttpLoggingInterceptor,
        Libraries.stethoOkhttp,
        Libraries.dagger,
        Libraries.daggerAndroid,
        Libraries.daggerAndroidSupp
    )

    kapts(
        Libraries.daggerCompiler,
        Libraries.daggerAndroidCompiler
    )
}