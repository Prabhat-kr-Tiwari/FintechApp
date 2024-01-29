plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.fintechapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fintechapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding=true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("com.mig35:carousellayoutmanager:1.4.6")
    //swipe button
//    implementation("com.ebanx:swipe-button:0.8.3")
    //proswipe
//    implementation("in.shadowfax:proswipebutton:1.2.2")

//    implementation("com.github.maxwell-kimaiyo:Swipe-Animated-Button:0.1.0")
//    implementation("com.github.MAXDeliveryNG:slideview:1.1.0")

}