# DJaw Development API Standards
_DJDAS_ are Standards in developing using DJaw.
_DJDAS_ aren't necessary, but code looks better with them
## Current version: **DJDAS 258**
1. Project ids HAVE to use `_` instead of ` `.
2. Project packages should end with `.djaw`. E.G., `org.example.djaw`.
3. It's better to use DJaw Exceptions class when possible, instead of normal Java exceptions
4. It's better to create `.signature` file in your project package. Expectable contents:
```json
{
  "commonLicence": "GNU General v3.0",
  "compatibility": "1.0.0.0",
  "projectMeta": "djaw-project-common",
  "projectSignature": "your-custom-project-signature"
}
```
5. Follow Java Standards: `JEP`
6. Report all the errors you can witness
7. Read documentation.md