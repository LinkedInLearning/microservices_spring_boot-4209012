# Order Service

## Docker Build

    ./gradlew bootBuildImage

## Kubernetes deploy

    kubectl apply -f k8s

## k8s

minikube image load order:0.0.1-SNAPSHOT

minikube start
kubectl apply -f k8s/rbac.yml

minikube image load order:0.0.1-SNAPSHOT
kubectl apply -f k8s/config.yml
kubectl apply -f k8s/deployment.yml
kubectl apply -f k8s/service.yml
kubectl logs
kubectl logs order-5b7d76c95c-9tqjd
minikube tunnel


## TODO
- klären ob wir prom metriken brauchen

## Sample Metriken

system_cpu_usage
