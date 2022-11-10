plugins {
    id("adventuretime.android.library")
    id("adventuretime.android.hilt")
    id("adventuretime.android.library.compose")
    id("kotlinx-serialization")
}

dependencies {
    implementation(projects.common.commonModel)

    implementation(libs.coroutine.core)
    implementation(libs.coroutine.android)

    implementation(libs.androidx.compose.lifecycle.runtime)
    implementation(libs.androidx.compose.compiler)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}