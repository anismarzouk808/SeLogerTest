plugins {
    plugins(
        BuildPlugins.androidApplication,
        BuildPlugins.kotlinAndroid,
        BuildPlugins.Kapt
    )
}

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = "com.miled.seloger"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = TestLibraries.androidJunitRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
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
        ":commun",
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