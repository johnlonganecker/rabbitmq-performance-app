# RabbitMQ Performance App

A simple way to test the performance of your RabbitMQ Service

This project uses the [RabbitMQ Performance Testing Tool]( https://github.com/rabbitmq/rabbitmq-perf-test/ ) to run benchmarks and to graph the results. I created a simple spring app that gives you an easy way to run benchmarks and graph results from the convenience of your browser!

![Screenshot from the chrome](rmq-perf-app-screenshot.png)

## Run the Web App Server

### Docker
```
docker pull johnlonganecker/rmq-perf-app
docker run -p 8080:8080 johnlonganecker/rmq-perf-app
```

### Command Line
**Download latest [release](https://github.com/johnlonganecker/rabbitmq-performance-app/releases)**
```
java -jar rmq-perf-app.jar
```

### Cloud Foundry
```
mvn install
cf push
cf bind-service rabbitmq-perf-app rmq-service
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

## Take it out for a spin

If you don't have a rabbitmq service running you can run one with docker
```
docker pull rabbitmq
docker run -d -p 5672:5672 rabbitmq
```

Run the RabbitMQ Performance App
```
java -jar rmq-perf-app.jar
```

The server will use rabbitmq's default URI to connect to the docker container. If you need to set your own URI read below.

You can find the WebApp at `localhost:8080`

Enter a performance `Scenario config` and how you want to graph it by setting the `Graph Config` 

You can find the documentation for both scenarios and graphs from [this repo](https://github.com/rabbitmq/rabbitmq-perf-test/blob/aeead278089125753268fc61ab91caa155220459/html/README.md)

### Example Configs
**Scenario**
```
{
  "name":      "no-ack",
  "type":      "simple",
  "params":    [{"time-limit":     10}]
}
```
**Graph**
```
{
  "type": "chart",
  "fields": {
    "data-type":"time",
    "data-x-axis":"time (s)",
  }
}
```
```
{
  "type": "small-chart",
  "fields": {
    "data-type":"time",
    "data-x-axis":"time (s)",
  }
}
```
```
{
  "type": "summary",
  "fields": {}
}
```
------
**Scenario**
```
{
  "name":      "message-sizes-and-producers",
  "type":      "varying",
  "params":    [{"time-limit":     30,
                 "consumer-count": 0}],
  "variables": [{"name":   "min-msg-size",
                 "values": [0, 1000, 10000, 100000]},
                {"name":   "producer-count",
                 "values": [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]}]
}
```

**Graph**
```
{
  "type": "chart",
  "fields": {
    "data-type": "series",
    "data-x-key":"producerCount",
    "data-x-axis":"producers",
    "data-y-axis":"rate (msg/s)",
    "data-plot-key":"send-msg-rate",
    "data-series-key":"minMsgSize"
  }
}
```
------
**Scenario**
```
{
  "name":      "message-sizes-large",
  "type":      "varying",
  "params":    [{"time-limit": 30}],
  "variables": [{"name":   "min-msg-size",
                 "values": [5000, 10000, 50000, 100000, 500000, 1000000]}]
}
```
**Graph**
```
{
  "type": "chart",
  "fields": {
    "data-type": "x-y",
    "data-x-key":"minMsgSize",
    "data-plot-keys":"send-msg-rate send-bytes-rate",
    "data-x-axis":"message size (bytes)",
    "data-y-axis":"rate (msg/s)",
    "data-y-axis2":"rate (bytes/s)",
    "data-legend":"ne"
  }
}
```
------
**Scenario**
```
{
  "name":      "rate-vs-latency",
  "type":      "rate-vs-latency",
  "params":    [{"time-limit": 30}]
}
```
**Graph**
```
{
  "type": "chart",
  "fields": {
    "data-type":"r-l",
    "data-x-axis":"rate attempted (msg/s)",
    "data-y-axis":"rate (msg/s)"
  }
}
```

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
  - when creating new row have dialog box with pre-made exampels
  - examples endpoint (list examples for dialog box)
- Make http server ports configurable through CLI
- unit/smoke/integration tests
  - web app
  - spring server
- Better Errors
  - UI Display
  - Messages from server
- Store results
  - export results
  - import results
  - save results to PG/MySQL/other DB
  - store info of system with results?
    - number of nodes
    - policy
    - hostname (not full uri)
