#!/bin/bash

COMMITMESSAGE=$(git log --pretty=%s | head -1 | grep -G "^\[maven-release-plugin\] prepare for next development iteration$")
if [ -z "$COMMITMESSAGE" ]; then 
  git checkout develop
  mvn release:prepare -B -Dskiptests
  mvn release:perform --settings deploy-settings.xml
fi
