plugins {
    plugins(
        BuildPlugins.androidLibrary,
        BuildPlugins.kotlinAndroid,
        BuildPlugins.safeArgs,
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

    buildFeatures.viewBinding = true

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

    testImplementations(
        TestLibraries.junit4,
        TestLibraries.kotlinTest,
        TestLibraries.kluent,
        TestLibraries.kluentAndroid
    )
}