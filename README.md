# hello-world-lombok-modular

## How to build (java 8) ##
Using the compiler and runtime of Java 8
````
javac -d build\classes -cp mods\lombok-1.18.0.jar src\main\java\be\bottemav\modular\model\Person.java src\main\java\be\bottemav\modular\Application.java
java -cp build\classes be.bottemav.modular.Application
````

## How to build (java 10) ##

I'm currently trying to compile this project with the following command
````
javac -verbose --processor-module-path mods --module-path mods -d build/classes src/main/java/be/bottemav/modular/model/Person.java src/main/java/be/bottemav/modular/Application.java src/main/java/module-info.java
````
but the only output I get is
````
[total 90ms]
````