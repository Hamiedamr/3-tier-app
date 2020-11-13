#!/bin/bash
#Installations of java
sudo apt update
sudo apt install default-jdk
echo java -version
sudo apt install openjdk-8-jdk
sudo apt install software-properties-common
sudo add-apt-repository ppa:linuxuprising/java
sudo apt update
sudo apt install oracle-java11-installer
sudo update-alternatives --config java
#Compile
javac  'src/Server.java' 'src/Intermediate.java' 'src/Client.java' 'src/Intermediate.java' 'src/IntermediateHandler.java' 'src/ClientHandler.java' 'src/ServerHandler.java'
cd 'src'
#Run the app
gnome-terminal --title="Station" --tab -- java Server 
gnome-terminal --title="Computing" --tab -- java Intermediate 
gnome-terminal --title="Decision" --tab -- java Client







