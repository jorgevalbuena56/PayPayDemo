plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.realm) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kmp.native.coroutines) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
