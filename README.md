# Spring Boot アクチュエータによる Liveness Prove と Readiness Prove の実装

OpenJDK 14、Spring Boot 2.3.1、Spring Boot アクチュエーターを利用したLivenessプローブとReadinessプローブへの応答例


## 模擬アプリケーションの機能

Spring Boot Actuator を利用して、Kubernetes の Livness Prove と Readiness Prove に対応する実装を検証したコードしたコードである。以下のYAML構成ファイルに対応する

~~~yaml:
    spec:
      containers:
      - name: java
        image: maho/web-java:0.1
        readinessProbe:
          httpGet:
            path: /actuator/health/readiness
            port: 8080
          initialDelaySeconds: 30
          timeoutSeconds: 5
        livenessProbe:
          httpGet:
            path: /actuator/health/liveness
            port: 8080
          initialDelaySeconds: 30
          timeoutSeconds: 10
          failureThreshold: 3
~~~

* アプリケーションのコンテンが起動して30秒後に、Readinessプローブへ HTTPレスポンス 200 (OK) を返すようになる。それまでの間は、503 (Service Unavailable:サービス利用不可)を返す。
* http://hostname:8080/greeting をGETでアクセスすると、HTMLで応答を返す。
* http://hostname:8080/bug をGETアクセスでは、Livenessプローブが、BROKENに変わり時期にコンテナがキルされ新しいコンテンが起動される。
* http://hostname:8080/crash をGETでアクセスすると、Nullポインタ例外が発生して、スタックトレースが表示される。



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



