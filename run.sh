#!/bin/bash
javac  'src/Server.java' 'src/Intermediate.java' 'src/Client.java' 'src/Intermediate.java' 'src/IntermediateHandler.java' 'src/ClientHandler.java'
cd 'src'
gnome-terminal --title="Station" --tab -- java Server 
gnome-terminal --title="Computing" --tab -- java Intermediate 
gnome-terminal --title="Decision" --tab -- java Client


# gnome-terminal --tab  --working-directory='./src' -- javac Client.java

# gnome-terminal --tab --working-directory='./src' -- java Server
# gnome-terminal --tab --working-directory='./src' -- java Intermediate
# gnome-terminal --tab --working-directory='./src' -- java Client




