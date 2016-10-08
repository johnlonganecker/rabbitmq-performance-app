# RabbitMQ Performance App

A simple way to test the performance of your RabbitMQ Service

This project uses the [RabbitMQ Performance Testing Tool]( https://github.com/rabbitmq/rabbitmq-perf-test/ ) to run benchmarks and to graph the results. I created a simple spring app that gives you an easy way to run benchmarks and graph results from the convenience of your browser!

![Screenshot from the chrome](rmq-perf-app-screenshot.png)

## Run the Web App Server

### Command Line
**Download rmq-perf-app.jar Release**
```
java --jar rmq-perf-app.jar
```

### Cloud Foundry
```
cf push
cf bind-service rabbitmq-perf-app
cf restage rabbitmq-perf-app
```

## Releases
Download from the github releases page

## Compile and Package
**Have Maven and Java Installed**
```
mvn install
mvn package
```

## How to Use
You can find the WebApp at `<host>:8080/index.html`

Enter a performance `Scenario config` and how you want to graph it `Graph Config` you can find the documentation for it from this repo: https://github.com/rabbitmq/rabbitmq-perf-test/blob/aeead278089125753268fc61ab91caa155220459/html/README.md

## Report Bugs or Feature Requests
Submit a github issue

## Contribute
Just submit a Pull Request :)

## ToDo
- Make http server ports configurable through CLI
- unit/smoke/integration tests
  - web app
  - spring server
- use better syntax highlight or fix syntax highlighter on keypress
- redirect / to index.html
- Better Errors
  - UI Display
  - Messages from server
- Store results
  - export results
  - import results
