#!/bin/sh

CORE=/home/verena/Project/core-web
YHAGUY=/home/verena/Project/turnos

########### yhaguy ##########################
DESDE=$CORE
HASTA=$YHAGUY

cp $DESDE/WEB-INF/lang-addon.xml $HASTA/WEB-INF/lang-addon.xml

# Archivos .zul
cd $DESDE
zip -r core core/*
mv core.zip  $HASTA/
cd $HASTA
unzip -o core.zip
#chmod 777 -R core
rm core.zip

# Archivos .class (crea jar)

cd $CORE/WEB-INF/classes
zip -r core com/*  -x *.svn*
mv core.zip ../src
cd ../src
zip -r core com/*  -x *.svn*
mv core.zip core.jar
mv core.jar  $HASTA/WEB-INF/lib/


