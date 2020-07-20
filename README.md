# Spring Boot アクチュエータによる Liveness Prove と Readiness Prove の実装


Spring Boot Actuator を利用して、Kubernetes の Livness Prove と Readiness Prove に対応する実装を検証したコードである。

Kubernetesにデプロイ後、30秒後に、Liveness Prove へ HTTPレスポンス 200 を返すようになる。それまでの間は、



## コンテナイメージのDocker Hub への登録

~~~
docker login
docker build -t <dockerid>/web-java:0.1 .
docker push <dockerid>/web-java:0.1
~~~

## K8sへのデプロイ

~~~
cd k8s/base
kubectl apply -k ./
~~~

開発用にデプロイ

