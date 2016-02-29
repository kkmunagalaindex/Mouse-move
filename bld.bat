cd D:\u\w\ecScala\w2\MouseyMove\src
d:
javac -d ..\bin *.java
pause
cd  D:\u\w\ecScala\w2\MouseyMove
copy /y bin\* bld\
mkdir bld\META-INF
copy /y MANIFEST.MF bld\META-INF
cd bld
jar cvfM ..\Mousey-App.jar *