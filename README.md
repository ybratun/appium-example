# ExerciseAppium

Welcome to Appium Exercise Automation

This is Java, TestNG and Appium based project, created to learn and exercise automation of wdiodemoapp app.

***! SETUP DETAILS: !***
Set up your connection with gitlab / github using SSH key.

Everything necessary to start with Appium and the project 
- Install npm, IntelliJ
- install GitLab Runner

- Clone & Open the Project in IntelliJ
- Build the Project 

## Structure

```
ExerciseAppium
├── src/main                     <- Common module, holding reusable components needed for testing│   
└── src/test                     <- Test module, holding reusable BaseTest and tests themselves
```

## For local pipeline (run in folder where Gitlab Runner is installed):

.\gitlab-runner.exe run

## To view locally Allure reports:

Run server locally, for that in Power Shell:
cd .\target\site\allure-maven-plugin
python -m http.server 8080

Then proceed in browser to view your local Allure reports:
http://127.0.0.1:8080

