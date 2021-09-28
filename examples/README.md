```
mvn clean package
```

```
#!/bin/bash

git pull

cd ..
mvn clean install -Dmaven.test.skip=true

cd examples
mvn clean package -Dmaven.test.skip=true

java -jar target/wechaty-example-1.0.0-SNAPSHOT-jar-with-dependencies.jar
```

```
slf4j
https://blog.csdn.net/foreverling/article/details/51385128

https://blog.csdn.net/hilaryfrank/article/details/110490618
```
