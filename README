# Java Encode/Decode URI Components
URIComponent is a small Java library that provides methods for encoding and decoding URI components. The methods produce the same result as the `encodeURIComponent` and `decodeURIComponent` functions in JavaScript.

## Installation
URIComponent is available as a downloadable `.jar` java library. You can download the JAR file and directly import to your project. The current release version is 1.0.

* [Download **uri-component-1.0.jar** core library](http://cemiltokatli.com/libs/uri-component/uri-component-1.0.jar)
* [Download **uri-component-1.0-sources.jar** optional sources jar](http://cemiltokatli.com/libs/uri-component/uri-component-1.0-sources.jar)
* [Download **uri-component-1.0-javadoc.jar** optional javadoc jar](http://cemiltokatli.com/libs/uri-component/uri-component-1.0-javadoc.jar)

### Maven
If you use Maven to manage the dependencies in your project, you do not need to download the jar file; just place the following code excerpt into your POM's `<dependencies>` section:

```
<dependency>
  <!-- URIComponent - Java Encode/Decode URI Components library @ https://github.com/cemiltokatli/URIComponent -->
  <groupId>io.github.cemiltokatli.uricomponent</groupId>
  <artifactId>uri-component</artifactId>
  <version>1.0</version>
</dependency>
```

### Building from source
If you want to build from source, it's best to use git so that you can stay up to date, and be able to contribute your changes back:

```
git clone https://github.com/cemiltokatli/URIComponent.git
cd URIComponent
mvn install
```

#### Tests
If you are building from source and make some changes, you might want to test your changes. URIComponent uses [JUnit](https://junit.org/junit5/) for testing and all test cases are located under the `src/test/` folder. The data prepared for testing purposes are located as [JSON](http://json.org/) files under the `src/test/resources` directory.

To run tests, you can use the `mvn test`command.

### Dependencies
URIComponent is entirely self contained and has no dependencies but for testing, it uses [JUnit](https://junit.org/junit5/) and [stleary's JSON library](https://github.com/stleary/JSON-java).

URIComponent runs on Java 9 or up.

## Usage
To encode a string, you can use the `encode` method of the `URIComponent` class.

```
import com.cemiltokatli.uricomponent.URIComponent;

public class Main {
    public static void main(String[] args){
        System.out.println(URIComponent.encode("test value")); //test%20value
        System.out.println(URIComponent.encode("test @ value #")); //test%20%40%20value%20%23
        System.out.println(URIComponent.encode("https://domain.com/my test.php?name=java&foo=bar"));
        //https%3A%2F%2Fdomain.com%2Fmy%20test.php%3Fname%3Djava%26foo%3Dbar
    }
}
```

To decode a string, you can use the `decode` method of the same class.

```
import com.cemiltokatli.uricomponent.URIComponent;

public class Main {
    public static void main(String[] args){
        System.out.println(URIComponent.decode("test%20value")); //test value
        System.out.println(URIComponent.decode("test%20%40%20value%20%23")); //test @ value #
        System.out.println(URIComponent.decode("https%3A%2F%2Fdomain.com%2Fmy%20test.php%3Fname%3Djava%26foo%3Dbar"));
        //https://domain.com/my test.php?name=java&foo=bar
    }
}
```


