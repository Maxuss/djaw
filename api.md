# DJaw Development API Standards
_DJDAS_ are Standards in developing using DJaw.
_DJDAS_ aren't necessary, but code looks better with them
## Current version: **DJDAS 040**
1. Project ids should use `-` instead of ` `.
2. Project packages should end with `.djaw`. E.G., `com.maxus.djaw`.
3. It's better to use `DJWCommonExceptions` class when possible, instead of normal Java exceptions
4. It's better to create `.signature` file in your project package. Expectable contents:
```json
{
  "commonLicence": "GNU General v3.0",
  "compatibility": "1.0.0.0", // DJaw version, on which project was created here
  "projectMeta": "djaw-project-common",
  "projectSignature": "your-custom-project-signature"
}
```
5. Follow Java Standards: `JEP`