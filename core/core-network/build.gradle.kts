plugins {
    id("adventuretime.android.library")
    id("adventuretime.android.hilt")
    id("kotlinx-serialization")
}

android {
    kapt { correctErrorTypes = true }
}

dependencies {
    implementation(projects.common.commonModel)

    implementation(libs.retrofit.converter.gson)
    implementation(libs.retrofit.converter.scalars)
    implementation(libs.retrofit.flow.adapter)

    implementation(libs.okhttp)
    implementation(libs.google.gson)
}