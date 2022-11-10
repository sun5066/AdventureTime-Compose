plugins {
    id("adventuretime.android.library")
    id("adventuretime.android.hilt")
    id("kotlinx-serialization")
}

dependencies {
    implementation(libs.coroutine.core)
    implementation(libs.coroutine.android)
    implementation(libs.google.gson)
}