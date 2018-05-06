# Android Architecture Components with Koin Dependency Injection
This will demonstrate how to employ Koin dependency injection with Android Architechture Components
## Main Dependencies

    implementation 'android.arch.persistence.room:runtime:1.1.0-rc1'
    implementation 'android.arch.persistence.room:rxjava2:1.1.0-rc1'
    implementation "android.arch.lifecycle:extensions:1.1.1"

    //Koin
    def koin_version = "0.9.2"
    implementation "org.koin:koin-android:$koin_version"
    implementation "org.koin:koin-android-architecture:$koin_version"


    kapt "android.arch.persistence.room:compiler:1.1.0-rc1"
    kapt "android.arch.lifecycle:compiler:1.1.1"
