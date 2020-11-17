# GolfScorecard
Project for Android Course at Treehouse

This project is a project for Android course at Treehouse. 

This project is to build Golf Scorecard. Other specifications are:
1. The list must show all 18 holes
2. Each holes must have addition and subtraction of each point.
3. The app must remember the score thus even when the app closed, and the activity destructed when it was restarted it  will still show scores.
4. The only thing to delete score is by clearing the score which will reset the score to zero

the documentation of this project is part of [this Google Doc](https://docs.google.com/document/d/1ZKoIqPzcycTyjynDT15ntokrwF_YpiS_48nIkp_0noc/edit?usp=sharing)
located after Header 1 [The Project](https://docs.google.com/document/d/1ZKoIqPzcycTyjynDT15ntokrwF_YpiS_48nIkp_0noc/edit#bookmark=id.q5tmk15zut4z).

Note: this app is using older JDK 8 thus the use of newer JDK since the design was old. We have to use Open JDK since the Oracle one is not supporting commercial use for free.

For other devices I will suggest to use Open JDK which IntellJ IDEA Android Studio already offers auto installation and downloads for Windows. I don't know about MacOS and Linux. 
I will suggest [adopt open JDK](https://adoptopenjdk.net/?variant=openjdk8&jvmVariant=openj9) for the open JDK option. Please select these parameters:
1. OpenJDK 8 (LTS)
2. the JVM just choose OpenJ9

These option works for me after the fiasco of using the OpenJDK 14
Check the project structure first since it should be available as option there.

WARNING: the JDK used will determine which SDK needed to run the project! Thus it is important to set the JDK to 8 first before building the android source code.