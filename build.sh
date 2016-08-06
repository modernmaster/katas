#!/bin/bash

COMMITMESSAGE=$(git log --pretty=%s | head -1 | grep -G "^[maven-release-plugin] prepare for next development iteration$")
if [ -z "$COMMITMESSAGE" ]; then 
	mvn verify 
fi
