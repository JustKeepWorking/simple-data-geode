@echo off

javar -jar simpele.jar -Dserver.port=8080 --app.gemfire.name=BookApp8080  --app.gemfire.start-locator=localhost[40404] --app.gemfire.jmx-manager-port=1199
javar -jar simpele.jar -Dserver.port=8081 --app.gemfire.name=BookApp8081 --app.gemfire.start-locator=localhost[40405] --app.gemfire.jmx-manager-port=1299
javar -jar simpele.jar -Dserver.port=8082 --app.gemfire.name=BookApp8082 --app.gemfire.jmx-manager-port=1399
