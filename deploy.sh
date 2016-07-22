#!/bin/bash
git update-ref HEAD master
git checkout master
mvn release:prepare -B
mvn release:perform --settings deploy-settings.xml
