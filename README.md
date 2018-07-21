# hello-world-lombok-modular

## How to build ##

I'm currently trying to compile this project with the following command
````
javac -verbose --processor-module-path mods --module-path mods -d build/classes src/main/java/be/bottemav/modular/model/Person.java src/main/java/be/bottemav/modular/Application.java src/main/java/module-info.java
````
but the only output I get is
````
[total 90ms]
````