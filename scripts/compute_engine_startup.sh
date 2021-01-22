! /bin/bash
sudo add-apt-repository ppa:openjdk-r/ppa -y && sudo apt-get update -y
sudo apt install openjdk-11-jdk -y
wget https://github.com/abilaashsai/GCP-Workshop/releases/download/1/demo-0.0.1-SNAPSHOT.jar
java -jar demo-0.0.1-SNAPSHOT.jar