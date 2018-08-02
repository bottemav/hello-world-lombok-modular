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

Fix: compile the Lombok project without the "provides org.mapstruct.ap.spi.AstModifyingAnnotationProcessor with ..." in module-info.jar

The output of the javac then becomes (skipping most parsing and loading messages)

````
...
Round 1:
        input files: {be.bottemav.modular.model.Person, be.bottemav.modular.Application}
        annotations: [lombok.Data]
        last round: false
javax.annotation.processing.FilerException: Cannot write to the given module.
        at jdk.compiler/com.sun.tools.javac.processing.JavacFiler.checkOrInferModule(JavacFiler.java:471)
        at jdk.compiler/com.sun.tools.javac.processing.JavacFiler.createSourceFile(JavacFiler.java:425)
        at lombok.javac.apt.LombokProcessor.forceNewRound(LombokProcessor.java:370)
        at lombok.javac.apt.LombokProcessor.process(LombokProcessor.java:357)
        at lombok.core.AnnotationProcessor$JavacDescriptor.process(AnnotationProcessor.java:156)
        at lombok.core.AnnotationProcessor.process(AnnotationProcessor.java:206)
        at lombok/lombok.launch.AnnotationProcessorHider$AnnotationProcessor.process(AnnotationProcessor.java:99)
        at jdk.compiler/com.sun.tools.javac.processing.JavacProcessingEnvironment.callProcessor(JavacProcessingEnvironment.java:964)
        at jdk.compiler/com.sun.tools.javac.processing.JavacProcessingEnvironment.discoverAndRunProcs(JavacProcessingEnvironment.java:881)
        at jdk.compiler/com.sun.tools.javac.processing.JavacProcessingEnvironment.access$2100(JavacProcessingEnvironment.java:110)
        at jdk.compiler/com.sun.tools.javac.processing.JavacProcessingEnvironment$Round.run(JavacProcessingEnvironment.java:1202)
        at jdk.compiler/com.sun.tools.javac.processing.JavacProcessingEnvironment.doProcessing(JavacProcessingEnvironment.java:1311)
        at jdk.compiler/com.sun.tools.javac.main.JavaCompiler.processAnnotations(JavaCompiler.java:1250)
        at jdk.compiler/com.sun.tools.javac.main.JavaCompiler.compile(JavaCompiler.java:928)
        at jdk.compiler/com.sun.tools.javac.main.Main.compile(Main.java:306)
        at jdk.compiler/com.sun.tools.javac.main.Main.compile(Main.java:165)
        at jdk.compiler/com.sun.tools.javac.Main.compile(Main.java:57)
        at jdk.compiler/com.sun.tools.javac.Main.main(Main.java:43)
Processor lombok.launch.AnnotationProcessorHider$AnnotationProcessor matches [lombok/lombok.Data] and returns true.
warning: Can't force a new processing round. Lombok won't work.
[loading /modules/java.base/java/lang/SuppressWarnings.class]
[loading /modules/java.base/java/lang/Override.class]
Round 2:
        input files: {}
        annotations: []
        last round: true
...        
````
and despite the FilerException all the class files are generated and also the getters and setters on the Person class.