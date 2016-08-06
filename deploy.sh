#!/bin/bash
mvn release:prepare -B -Dskiptests
mvn release:perform --settings deploy-settings.xml
