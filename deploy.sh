#!/bin/bash
git fetch
git checkout master
mvn release:prepare -B
mvn release:perform --settings deploy-settings.xml
