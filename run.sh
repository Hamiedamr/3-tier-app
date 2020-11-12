#!/bin/bash
gnome-terminal --tab  -- javac 'src/Server.java'
gnome-terminal --tab  -- javac 'src/Intermediate.java'
gnome-terminal --tab  -- javac 'src/Client.java'

gnome-terminal --tab --working-directory='./src' java Server
gnome-terminal --tab --working-directory='./src' java Intermediate
gnome-terminal --tab --working-directory='./src' java Client




