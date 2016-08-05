#!/bin/bash
git update-ref HEAD refs/heads/master
git checkout master
mvn release:prepare -B
mvn release:perform --settings deploy-settings.xml
