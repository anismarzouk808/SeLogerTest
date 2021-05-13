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