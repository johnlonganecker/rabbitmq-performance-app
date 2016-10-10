# RabbitMQ Performance App

A simple way to test the performance of your RabbitMQ Service

This project uses the [RabbitMQ Performance Testing Tool]( https://github.com/rabbitmq/rabbitmq-perf-test/ ) to run benchmarks and to graph the results. I created a simple spring app that gives you an easy way to run benchmarks and graph results from the convenience of your browser!

![Screenshot from the chrome](rmq-perf-app-screenshot.png)

## Run the Web App Server

### Command Line
**Download latest [release](https://github.com/johnlonganecker/rabbitmq-performance-app/releases)**
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
Download from the [releases page](https://github.com/johnlonganecker/rabbitmq-performance-app/releases)

## Compile and Package
**Have Maven and Java Installed**
```
mvn install
mvn package
```

## How to Use
You can find the WebApp at `<host>:8080/index.html`

Enter a performance `Scenario config` and how you want to graph it by setting the `Graph Config` 

You can find the documentation for both scenarios and graphs from [this repo](https://github.com/rabbitmq/rabbitmq-perf-test/blob/aeead278089125753268fc61ab91caa155220459/html/README.md)

### Where do the host/user/pass/vhost get set?
In the `scenario config` you can specify a `uri` like this:

```
"uri": "amqp://user:password@host:port/vhost"
```

**Cloud Foudry**<br>
If you bind a rabbitmq service (based on pivotal's rabbitmq release) to this app it will automatically get the credentials it needs to interact with rabbitmq.

You can of course override those credentials by adding the `uri` field to the `scenario config`

**Defaults**<br>
If no credentials are provided this app will use a default rabbitmq `uri` to connect to the service

## Report Bugs or Feature Requests
Submit a github issue

## Contribute
Feel free to do something cool or grab something from the Todo list and just submit a Pull Request :)

## ToDo
- Make a bunch of useful examples
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
