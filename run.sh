#!/bin/bash

# Set JAVA_HOME to Java 21
export JAVA_HOME=/opt/homebrew/Cellar/openjdk@21/21.0.9/libexec/openjdk.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH

# Run the Spring Boot application
mvn exec:java