### Status
[![Build Status](https://travis-ci.org/kul3r4/droidConf.png)](https://travis-ci.org/kul3r4/droidConf)
# droidConf
This project has been created for attending DroidConfIT 2015.
The main idea is having a talk around a sample app to explain the main ideas and show results.
The project is organized in 4 main modules:
* App module
* Java Lib module
* Acceptance tests module
* Bespoke.js presentation module

## londonWeather
This is a really simple app which shows the weather. It contains a Mapping strategy for the icon to display.

## londonWeatherAcceptance
This contains Selenium Acceptance Tests.
In order to run them:
* Clean and build the londonWeather application
* Start your emulator or device
* Use the following VM options: -ea -Daut="com.cchiappini.londonweather" -DapkPath=pathToYourAPK -DhubURL="http://localhost:4444/wd/hub"
  pathToYourAPK for me is -DapkPath="/Users/cchiappini/IProjects/droidConfRefactor/londonWeather/build/outputs/apk/londonWeather-debug.apk"

## londonweatherlib
This contains domain model logic in Java

##src
This contains the bespoke.js presentation.
In order to add a new slide, use index.jade.
To generate a new presentation on your local machine, run gulp. (Instructions here: https://github.com/markdalgleish/bespoke.js)

