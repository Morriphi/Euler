#!/bin/sh
sbtansicolor=${SBTANSICOLOUR:-false}
java -Dsbt.boot.directory=project/boot/ -Dsbt.log.noformat=$sbtansicolor -XX:MaxPermSize=512M -Xmx1024m -jar `find tools -name sbt-launch-0.12*.jar` "$@"
