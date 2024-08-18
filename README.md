# Microservices Freddy's BBQ

## Run with Docker Compose

### 0. Set up Keycloak Hostname

For the authentication to work you need to locally resolve the hostname `keycloak` to `127.0.0.1`. To do that add the
following line in your `/etc/hosts` on Mac/Linux or on Windows `c:\Windows\System32\Drivers\etc\hosts` as admin: 

    127.0.0.1   keycloak

##  1. Run with Docker Compose

    docker compose up

https://github.com/open-telemetry/opentelemetry-java-instrumentation/issues/9987


    docker compose up kafka-zookeeper kafka kafka-ui
    docker compose rm kafka-zookeeper kafka kafka-ui

## Golang

https://github.com/open-telemetry/opentelemetry-go-contrib/blob/main/instrumentation/net/http/httptrace/otelhttptrace/example/client/client.go

oauth2-proxy
    --email-domain=*
    --provider=keycloak-oidc
    --client-id=launchpad-dev
    --client-secret=44168aba-e917-4677-934e-d961a5dbc8d8
    --redirect-url=https://internal.yourcompany.com/oauth2/callback
    --oidc-issuer-url=http://localhost:8080/realms/launchpad-dev
    --code-challenge-method=S256 // PKCE