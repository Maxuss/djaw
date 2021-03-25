# **FORMATS FOR CREATING YOUR OWN PROJECTS** 
**NOTE THAT PROJECT IS STILL IN WIP!!!**

You need only few JSON-like files to create.
Current needed files:
`<projectname>Project.djaw` --- needed for main info on project
`<projectname>.info` --- needed for detailed info on dependencies and file locations
`<projectname>.djaw` --- needed for main data for DJaw
`<projectname>Config.djaw` --- config for project

All the files require JSON syntax!
Also, please use these just in case:
```json
{
  "_djawcomment": "Comment that shows in console on load",
  "_comment": "for comments that wont show in console on load",
  "_edit": {
    "_pkg": "change main package of the file",
    "_dirs": {
      "list all the directories to change this way": "look down lol",
      "old": "new",
      "com.your.package.djaw.old": "com.your.package.djaw.new"
    }
  }
}
```
This is just an example
Now let's head into the file formats
note that `<projectname>` should be the same everywhere!

`<projectname>Project.djaw` =>
```json
{
  "projectID": "id-for-your-project",
  "projectName": "Project name",
  "projectDescription": "Project description",
  "projectAuthor": "Author name",
  "projectCredits": "Credits for someone",
  "projectVersion": "version",
  "projectLanguage": "language in format of 'en-US' or 'ru-RU'",
  "projectPKG": "main package name, e.g. 'com.yourname.yourprojectname'. it will find all the stuff needed itself",
  "weblink": "link to your webpage. If it doesnt exist use example.com or just 'null'"
}
```

`<projectname>.info` =>
That's a tough one. follow instruction carefully
```json
{
  "compiler": "djaw",
  "_comment": "compiler is the signature it leaves after editing files, and file extensions will be dependant on it",
  "_comment1": "there are currently 3 compilers. 'djaw', 'devjaw', 'dunjer'",
  "_comment2": "'djaw' mostly works with *.djaw files. However it is limited to last release version.",
  "_comment3": "'devjaw' is experimental compiler. it works with *.djaw but can also work with *.djwd files. Last one is base on *.xml, and not *.json.",
  "_comment4": "'dunjer' is top experimental compiler and you'll need to download DJer compiler too! It has its own function and works only with *.djr file extensions, based on *.xml",
  
  "dep": {
    "_comment-dependantOnEXAMPLE": "LIST OF ALL PROJECTS THAT DEPEND ON THIS PROJECT. USE null IF NOTHING! ",
    "_comment5": "VVV an example below VVV",
    "dependantOn": ["random-project-id"],
    "_comment-dependsOnEXAMPLE": "LIST OF ALL PROJECTS THIS PROJECT DEPENDS. ALWAYS ADD 'djaw-comp', ELSE IT WILL CRASH!",
    "_comment6": "VVV an example below VVV",
    "dependsOn": ["djaw-comp", "random-pkg", "meme-dungeon-main"]
  },
  
  "_comment7": "required for finding file locations.",
  "locs": {
    "pkg-main": "com.yourproject.yourname",
    "pkg-djs-main": ".folder_containing_files_for_compiler",
    "pkg-sgr": ".folder_containing_signature.sgr_file",
    
    "_comment8": "i recommend using djs for the pkg-djs-main and sign for the pkg-sgr"
  },
  
  "?log": true,
  "_comment9": "whether to log the info of program. bool",
  "log-loc": ".tmp"
}
```

.djaw file is also based on json
`<projectname>.djaw`

```json
{
  "sgr": "",
  
  "djwd": {
    "get-info-from-compiler": true,
    "parse-djwd": false,
    "parse-xml-like": false,
    "parse-only-one": false,
    "parse-json-like": true
  },
  
  "compilerT1": "djaw",
  "compilerT2": "devjaw",
  
  "basic-compiler": "djaw",
  
  "mainClassName": "your_project_main_class_name_that_will_exec",
  "mainExceptionsClassName": "your_main_class_with_exceptions_name_if_it_exists",
  "projectIDModifier": "default",
  
  "extra-data": {
    "add-custom-files": false,
    "file-extensions": null,
    "files": [null],
    "custom-compiler": null
  }
  
}
```

Config will generate automatically, you can also create your own using "extra-data".
Anyways, `<projectname>Config.djaw`

```json
{
  "runData": {
    "windowed": true,
    "normal": "windowed"
  },
  "storeCookies": false,
  "settings": {
    "djawType": "fast",
    "_comment": "supports 'fast', 'slow', 'exec-ful'",
    "ram-allocated": "2000",
    "_comment2": "in megabytes"
  }
}
```

so that's all I guess.
