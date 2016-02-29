cd src

javac -d ../bin *.java

cd ..
cp  bin/* bld/
mkdir bld/META-INF
cp  MANIFEST.MF bld/META-INF
cd bld
jar cvfM ../Mousey-App.jar *
cd ..
java -jar Mousey-App.jar
