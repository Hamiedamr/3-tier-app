#!/bin/bash
#Compile
javac  'src/Server.java' 'src/Intermediate.java' 'src/Client.java' 'src/Intermediate.java' 'src/IntermediateHandler.java' 'src/ClientHandler.java'
cd 'src'
#Run the app
gnome-terminal --title="Station" --tab -- java Server 
gnome-terminal --title="Computing" --tab -- java Intermediate 
gnome-terminal --title="Decision" --tab -- java Client







