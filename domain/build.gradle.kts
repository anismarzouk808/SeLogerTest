plugins {
    plugins(
        BuildPlugins.androidLibrary,
        BuildPlugins.kotlinAndroid,
        BuildPlugins.seLogerConfigGradleModule,
        BuildPlugins.kotlinAndroidExtensions,
        BuildPlugins.Kapt
    )
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