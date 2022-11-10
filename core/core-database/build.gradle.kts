plugins {
    id("adventuretime.android.library")
    id("adventuretime.android.hilt")
    id("kotlinx-serialization")
}

dependencies {
    implementation(projects.common.commonModel)
}