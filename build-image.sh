export JAVA_HOME=/home/csouza/.jdks/openjdk-21.0.1/
java --version
mvn package -DskipTests
sudo docker buildx b . -t ccs1201/demo-winker