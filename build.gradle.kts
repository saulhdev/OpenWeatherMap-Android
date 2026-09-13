plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
}

tasks.register("clean", Delete::class.java) {
    delete(layout.buildDirectory)
}
