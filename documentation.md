# Documentation on working with DJaw


## Formatting a project
First off, find your `projects` folder.
Create a `data.dji` file there first. Learn more about creating `*.dji` [here](https://github.com/Maxuss/djaw/blob/main/format.md)
Then, create a new package there, it should look something like that:
```
djaw
  |- djaw.jar
  |- djaw
  |     |- projects
        |         |- example-id
                  |         |- data.dji
                            |- com.project.djaw
                            |- everything else
                            |
```                                 

Note, that package **HAS TO** end with .djaw. That's the _DJDAS_ standard.

Then you should create your main class.


If you did everything correctly when you launch djaw.jar, it will send "Hello World!" in console.

That's all for now.