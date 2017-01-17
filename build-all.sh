#!/bin/bash -x

export PORT=0
export MAVEN_OPTS="-Xmx512m -Xms512m"

env

mvn clean
mvn ${MVN_PHASE:=install} -f ${MVN_FILE:=pom.xml}
