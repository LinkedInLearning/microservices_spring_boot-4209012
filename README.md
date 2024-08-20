# Microservices Freddy's BBQ

## Run with Docker Compose

### 0. Set up Keycloak Hostname

For the authentication to work you need to locally resolve the hostname `keycloak` to `127.0.0.1`. To do that add the
following line in your `/etc/hosts` on Mac/Linux or on Windows `c:\Windows\System32\Drivers\etc\hosts` as admin: 

    127.0.0.1   keycloak

##  1. Run with Docker Compose

    docker compose up

https://github.com/open-telemetry/opentelemetry-java-instrumentation/issues/9987


## Golang

https://github.com/open-telemetry/opentelemetry-go-contrib/blob/main/instrumentation/net/http/httptrace/otelhttptrace/example/client/client.go
