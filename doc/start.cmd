

set NACOS_HOME=F:\workSoft\nacos-server-2.0.2\nacos\bin\startup
set SENTINEL_HOME=F:\workSoft\sentinel-dashboard-1.8.1.jar


start %NACOS_HOME% -m standalone


java -Dserver.port=7999 -Dcsp.sentinel.dashboard.server=localhost:7999 -Dproject.name=dashboard -Dsentinel.dashboard.auth.username=sentinel  -Dsentinel.dashboard.auth.password=123456 -jar -Dcsp.sentinel.log.dir=./logs/csp -Dcsp.sentinel.log.use.pid=true %SENTINEL_HOME%
