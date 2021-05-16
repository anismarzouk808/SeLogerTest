plugins {
    plugins(
        BuildPlugins.androidLibrary,
        BuildPlugins.kotlinAndroid,
        BuildPlugins.seLogerConfigGradleModule,
        BuildPlugins.Kapt
    )
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