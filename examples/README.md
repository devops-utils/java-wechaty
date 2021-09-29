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

https://github.com/wechaty/wechaty-puppet-wechat/blob/a82066e952aae4a93c18504fafbcd2e9e1139181/src/puppet-wechat.ts#L473-L478

protoc-gen-grpc-java

https://repo1.maven.org/maven2/io/grpc/protoc-gen-grpc-java/1.37.1/protoc-gen-grpc-java-1.37.1-linux-x86_64.exe

java grpc auth
https://sultanov.dev/blog/securing-java-grpc-services-with-jwt-based-authentication/#:~:text=Securing%20Java%20gRPC%20services%20with%20JWT-based%20authentication%20gRPC,is%20token-based%20authentication%20for%20use%20with%20Google%20services.


java grpc withCallCredentials


const creds = grpc.credentials.createInsecure()

  const client = new puppet.PuppetClient(
    'localhost:8788',
    creds,
    {
      'grpc.default_authority': 'puppet_token',
    },
  )
  
const metadata = fromHttp2Headers.call(MetadataClass, headers)

    if (metadata.get('authorization').length <= 0) {
      const authority = headers[':authority']
      const authorization = `Wechaty ${authority}`
      metadata.set('authorization', authorization)
    }
    return metadata
    
https://sultanov.dev/blog/securing-java-grpc-services-with-jwt-based-authentication/#:~:text=Securing%20Java%20gRPC%20services%20with%20JWT-based%20authentication%20gRPC,is%20token-based%20authentication%20for%20use%20with%20Google%20services.
```
