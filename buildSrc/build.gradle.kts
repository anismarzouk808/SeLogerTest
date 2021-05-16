plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}


gradlePlugin {
    plugins {
        register("seloger-config-module") {
            id = "seloger-config-module"
            implementationClass = "com.miled.dependencies.SelogerConfigModulePlugin"
        }
    }
}

repositories {
    google()
    mavenLocal()
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())

    implementation("com.android.tools.build:gradle:4.2.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5")
}