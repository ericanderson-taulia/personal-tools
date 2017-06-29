---- How to override Logging settings so that you can DEBUG just the Loggers that you care about  -----


1)  Create a file on your local system with the JSON log4j settings you care about like such
```{
  "configuration": {
    "status": "warn",
    "name": "tauliaLog",
    "packages": "corg.graylog2.log4j2",
    "appenders": {
      "Console": {
        "name": "standardOut",
        "PatternLayout": {
          "pattern": "%style{%d{MM-dd HH:mm:ss,SSS}}{dim} %highlight{%-5p} %style{%c{1}:%L}{dim} - %style{%X{requestSource}%X{requestTimestamp}:%X{requestId} - %X{clientType}:%X{userId}:%X{userProxyId}}{cyan} - %style{%marker}{magenta} - %m%n"
        }
      }
    },
    "loggers": {
      "logger" : [
        {"name": "org.springframework.beans", "level": "DEBUG"},
        {"name": "com.taulia", "level": "DEBUG"}
      ],
      "root": {
        "level": "info",
        "AppenderRef": {
          "ref": "standardOut"
        }
      }
    }
  }
}```


2) In your server/build.gradle file override your `run` task as such
```run {
  jvmArgs '-XX:MaxPermSize=128m', '-Xverify:none', '-Dlog4j.configurationFile=file:/Users/eanderson/Development/taulia/personal-tools/configurations/logging/log4j2.json'
  standardInput = System.in
}
```
