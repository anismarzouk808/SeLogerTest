plugins {
    plugins(
        BuildPlugins.androidLibrary,
        BuildPlugins.seLogerConfigGradleModule,
        BuildPlugins.kotlinAndroid,
        BuildPlugins.Kapt
    )
}

dependencies {

    implementationProjects(
        ":domain",
        ":Network"
    )

    implementations(
        Libraries.kotlinStdLib,
        Libraries.retrofit,
        Libraries.retrofitRxjava,
        Libraries.retrofitGson,
        Libraries.okHttp,
        Libraries.okhttpLoggingInterceptor,
        Libraries.stethoOkhttp,
        Libraries.dagger
    )

    testImplementations(
        TestLibraries.junit4,
        TestLibraries.kotlinTest,
        TestLibraries.mockitoKotlin,
        TestLibraries.mockito,
        TestLibraries.kluent,
        TestLibraries.kluentAndroid
    )

    kapts(
        Libraries.daggerCompiler
    )
}