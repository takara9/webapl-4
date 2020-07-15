# web-java

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

