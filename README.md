## Assessment (NY Times Most Popular Articles)

# Steps to setup/Run application
* Download Android studio and configure it.
* Download project into android studio from git repo https://github.com/sharma4frnds/NyTimesMostPopular.git .
* goto Build(top of android studio) -> Clean Build -> Once cleanup done -> Build Bundle(s)/Apk(s).
* After successfully generate apk install into device/android phone.
* use below command to install apk into phone/tablet. 
* adb install -r "Path of apk" make sure adb is configured. 

* If you failed to build, I am attaching debug apk inside apk folder, please download and use that. 

## Designing
* Model–view–viewmodel (MVVM) architectural pattern
* Retrofit server call 
* UI & functions tested using JUnit & espress
* Glide to load the images provided in urls.  

# Test cases Report
* HLD, SonarLint report are attached under images folder. Please check the same. 


## Screens

<b>Main article list Screen</b>
<img src="images/main_activity.png" alt="Main article list"/>

<b>Details View Screen</b>
<img src="images/detail_activity.png" alt="Details View Screen"/>

<b>Main article list Screen</b>
<img src="images/hld.png" alt="High level diagram"/>

<b>Main article list Screen</b>
<img src="images/Sonar_Analysis.png" alt="Quality Analysis using Sonar"/>