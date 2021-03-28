# **FORMATS FOR CREATING YOUR OWN PROJECTS** 
**NOTE THAT PROJECT IS STILL IN WIP!!!**

### **EDIT**
Since update v.0.9.5.4 you can create simple configuration in the program!

You need only one JSON-like file to create.
Go to `projects/<projectname>/` and create file `data.dji`

What does `.dji` mean? **DJ**aw **I**nformation of course!

File requires JSON syntax!
This is just an example

`data.dji` =>
```json
{
  "_comment": "these comments wont parse",

  "normalSignature": "undefined_unstable",
  "dunjerCache": false,
  "djawCache": false,
  "devjawCache": false,
  "standardCompiler": "djaw",
  "mainClass": "DJWExample",
  "exceptionClass": "DJWExampleExceptions",
  "modifyInnerCode": false,
  "standardRunConfig": "windowed",
  "acceleration": false,
  "createLocalData": false,
  "localDataPath": null,

  "package": "com.ex.djaw",
  "leaveSignature": false,
  "logConsole": false,
  "logLocation": null,

  "projectID": "djaw-example",
  "projectName": "Example DJaw Project",
  "projectDescription": "Example Project!",
  "projectAuthor": "Maksim 'Maxuss' Petrov",
  "projectCredits": "My friends!",
  "projectVersion": "1.31.531 Stable",
  "projectLanguage": "en-US",
  "projectWebsite": "example.com"

}
```

So that's all I guess.
Also, something for you to note.

`dunjerCache/djawCache/devjawCache` are all needed for saving some data locally.

`package` is your main package.

`mainClass` and `exceptionClass` are classes needed for the engine to see your classes.

Check `documentation.md` for some more info!
