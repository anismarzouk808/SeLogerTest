plugins {
    plugins(
        BuildPlugins.androidLibrary,
        BuildPlugins.kotlinAndroid,
        BuildPlugins.seLogerConfigGradleModule,
        BuildPlugins.safeArgs,
        BuildPlugins.Kapt
    )
}

android {
    buildFeatures.viewBinding = true
}

dependencies {
    implementationProjects(
        ":common",
        ":commonAndroid",
        ":domain"
    )

    implementations(
        Libraries.kotlinStdLib,
        Libraries.fresco,
        Libraries.timber,
        Libraries.rxAndroid,
        Libraries.rxJava,
        Libraries.dagger,
        Libraries.daggerAndroid,
        Libraries.ktxCore,
        Libraries.daggerAndroidSupp,
        Libraries.constraintLayout,
        Libraries.appCompat,
        Libraries.navigationFragmentKtx,
        Libraries.navigationUiKtx,
        Libraries.navigationRuntimeKtx
    )

    kapts(
        Libraries.daggerAndroidCompiler,
        Libraries.daggerCompiler
    )
}