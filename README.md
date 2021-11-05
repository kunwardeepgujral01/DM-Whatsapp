
# DM Whatsapp

Using this app, user doesn't have to save a mobile number in order to send message on Whatsapp. You can directly choose country code and enter mobile number along with message and then it can be send to the number specified.
 
# Documentation

## Gradle
```
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath "com.android.tools.build:gradle:4.2.1"
    }
}

dependencies {

    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'com.google.android.material:material:1.4.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.1'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    
    //Country Code Picker
    implementation 'com.hbb20:ccp:2.5.1'
}
```
### Dependencies

1. [Country Code Picker](https://github.com/hbb20/CountryCodePickerProject)

## Screenshots

###### Splash Screen and Home Screen <img src="https://github.com/kunwardeepgujral01/DM-Whatsapp/blob/master/SplashScreen.png" width="30%"><img src="https://github.com/kunwardeepgujral01/DM-Whatsapp/blob/master/HomeScreen.png" width="30%">

## Feedback

If you have any feedback, please reach out to me at kunwardeepgujral000@gmail.com


If you find a bug or think something could be better, please file an issue! If you think a code change should be made, feel free to raise a PR.





