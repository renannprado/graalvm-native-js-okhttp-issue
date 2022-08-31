# GraalVM, Native, GraalJS and OkHttp issue

This is a minimal reproducer for the issue [here](https://graalvm.slack.com/archives/CN9KSFB40/p1661875989816459).

GraalVM version used:

```
openjdk 17.0.4 2022-07-19
OpenJDK Runtime Environment GraalVM CE 22.2.0 (build 17.0.4+8-jvmci-22.2-b06)
OpenJDK 64-Bit Server VM GraalVM CE 22.2.0 (build 17.0.4+8-jvmci-22.2-b06, mixed mode, sharing)
```

## Building & Running on the JVM

> This works!

```
./mvnw clean package
```

```
java -jar ./target/graal-native-js-okhttp-issue-0.0.1-SNAPSHOT.jar
```

## Building & Running the native binary

> This doesn't work!

```
./mvnw -Pnative clean package
```

> There's also a `native-fast` profile

```
./target/graal-native-js-okhttp-issue
```

Fails with

```
Exception in thread "main" TypeError: Request.Builder is not a constructor
        at <js> :program(Unnamed:3:112-132)
        at org.graalvm.polyglot.Context.eval(Context.java:425)
        at dev.renann.issue.Main.main(Main.java:16)
```
