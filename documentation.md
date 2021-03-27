# DOCUMENTATION ON CREATING CUSTOM PROJECTS
## Using DJaw, an engine powered by Java

First off, find your `projects` folder.
Create a `data.dji` file there first. Learn more about creating `*.dji` [here.](https://github.com/Maxuss/djaw/blob/main/format.md)
Then, create a new package there, it should look something like that:
```
djaw
  |- djaw.jar
  |- data
  |- djs
  |- projects
        |- data.dji
        |- com.project.djaw
                |- everything else
```

Note, that package **HAS TO** end with .djaw. That's the standard.

Then you should create your main class. Here's an example:
```java
package test.project.djaw;
import com.maxus.djaw;

public class TestMainClass {
    public static void main(String[] args){
        DoSomething();
    }
    public static void DoSomething(){
        DJaw.DJMessage("Hello World!", 0);
    }
}
```

If you did everything correctly when you launch djaw.jar, it will send "Hello World!" in console.

That's all for now.