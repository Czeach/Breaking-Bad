object Hilt {
    const val version = "2.38.1"
    const val hiltAndroid = "com.google.dagger:hilt-android:$version"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$version"

    private const val hiltNavigationVersion = "1.0.0-alpha03"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:$hiltNavigationVersion"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:$hiltNavigationVersion"

    private const val hiltVersion = "1.0.0"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:$hiltVersion"
}