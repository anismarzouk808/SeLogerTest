plugins {
    plugins(
        BuildPlugins.androidLibrary,
        BuildPlugins.kotlinAndroid,
        BuildPlugins.seLogerConfigGradleModule,
        BuildPlugins.KotlinParcelize,
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