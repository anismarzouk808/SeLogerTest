plugins {
    plugins(
        BuildPlugins.javaLibrary,
        BuildPlugins.kotlin
    )
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementations(
        Libraries.kotlinStdLib,
        Libraries.rxJava
    )
}