#!/bin/bash
export JAVA_HOME=/usr/local/jdk1.8.0_411
export PATH=$JAVA_HOME/bin:$PATH
mvn clean package -DskipTests -Dmaven.test.skip=true -Dcheckstyle.skip=true -Dpmd.skip=true -Dfindbugs.skip=true -U
ret=$?
if [ $ret -ne 0 ];then
    echo "===== mvn build failed! ====="
    exit $ret
else
    echo -n "===== mvn build succeeded! ====="
fi