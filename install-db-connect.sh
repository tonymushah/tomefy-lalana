#!/bin/bash

./mvnw \
	install:install-file \
	-Dfile="$(pwd)/src/main/resources/lib/java-dbconnect-1.0-SNAPSHOT.1.jar"