----- CICD set up ------

-> Download "Google Authenticator" app your mobile phone from playstore

-> Login in google account (which connect with Github)

-> Click "Manage your google account" then "Security" and Add "2-step verification" and Select "Authenticator app" from here
	then scan it from Google Authenticator and find 6 digits code your mobile app enter the code in it

-> Back google account and search "App password" from here "Select app" & "Select device" click "Generate" and
	find 16 digits app password and save it for future use

-> Upload your "headless browser" project in your Github

-> Go to this Github project "Settings" then click "Secrets and varible" select "Actions" then click "New repository secret"

	Name*: EMAIL_USERNAME 
	Secret*: Gitub Email
	click "Add secret"

Then again click "New repository secret"

	Name*: EMAIL_PASSWORD 
	Secret*: 16 digits app password
	click "Add secret"

-> Go to this project click "Add file" select "Create new file" name this file "InstallChrome.sh" and paste the code & save it

-> Go to Github "Actions" then "Set up a workflow yourslef/ (New workflow) files main.yml paste the code here

-> Run the "main.yml" code and find the email with attachment



//code

----- Headless Browser -----

options.addArguments("--no-sandbox");

options.addArguments("--disable-dev-shm-usage");

options.addArguments("--headless");

(paste in it Helper.class after driver setup)


----- InstallChrome.sh -----

#!/bin/bash

set -ex

wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb

sudo apt install ./google-chrome-stable_current_amd64.deb

(paste it in "InstallChrome.sh" file)


----- main.yml -----


name: Selenium Java CI

on: [push]

jobs:
  build:
    runs-on: ubuntu-latest # Using linux machine

    steps:
    - uses: actions/checkout@v2 # Checkout the code
    - name: Set up JDK 1.8
      uses: actions/setup-java@v1 # Setup JAVA
      with:
        java-version: 1.8
    - name: Install Google Chrome # Using shell script to install Google Chrome
      run: |
       chmod +x ./InstallChrome.sh
        ./InstallChrome.sh
    - name: Grant execute permission for gradlew
      run: chmod +x gradlew # give permission to Gradle to run the commands
    - name: Build with Gradle
      continue-on-error: true
      id: sanityTest
      run: ./gradlew webRun -DType=webTest # Run our tests using Gradle
    - name: Send email report
     # if: steps.sanityTest.outcome != 'success'
      uses: dawidd6/action-send-mail@v2
      with:
        server_address: smtp.gmail.com
        server_port: 465
        username: ${{secrets.EMAIL_USERNAME}}
        password: ${{secrets.EMAIL_PASSWORD}}
        subject: Automated Test Report
        body: |
          Hi,
        attachments: ./build/reports/webFeature.html
        from: Github Actions
        to: asiffmahmud@gmail.com
        content_type: text/html
        # Optional converting Markdown to HTML (set content_type to text/html too):
        convert_markdown: true

(paste it in "main.yml" file)



body: file://./redx/build/reports/tests/merchantWebUiTest/PaymentsPageSanityTestSuite/PageWiseTests.html
