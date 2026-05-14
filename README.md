# ExerciseAppium

Welcome to Appium Exercise Automation

This is Java, TestNG and Appium based project, created to learn and exercise automation of wdiodemoapp app.

***! SETUP DETAILS: !***
[Set up your SSH key with 1Password](https://developer.1password.com/docs/ssh/get-started/)

Everything necessary to start with Appium and the project can be found in the confluence page
(same as for FL Automation)  [Project Prerequisites](https://teamviewer.atlassian.net/wiki/spaces/ARS/folder/484507656?atlOrigin=eyJpIjoiYWJiMmYwNmE1ZTI4NGRlN2I0OWZjOTkyMGY4NzQ5NmIiLCJwIjoiYyJ9)

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

Run server locally, in Power Shell:
cd .\target\site\allure-maven-plugin
python -m http.server 8080

Then proceed in browser to view your local Allure reports:
http://127.0.0.1:8080

