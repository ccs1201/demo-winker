#export JAVA_HOME=/home/csouza/.jdks/openjdk-21.0.1/
#java --version
#mvn package
sudo docker buildx b -f ./infra/docker/dockerfile . -t ccs1201/demo-winker