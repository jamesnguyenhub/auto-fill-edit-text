# Auto Fill EditText
[![Build Status](https://travis-ci.org/nntuyen/auto-fill-edit-text.svg?branch=master)](https://travis-ci.org/nntuyen/auto-fill-edit-text)

You don't need to type the whole text. You just type some and it will suggest the remaining part.

![](screenshots/screenshot-1.gif)
![](screenshots/screenshot-2.gif)

## Usage
*Step 1:* Define your suggestions list
In Java code
```java
editText.addSuggestions(Arrays.asList("hotmail.com", "microsoft.com"));
```
or in xml
```xml
<resources>
  <string-array name="emails">
    <item>tuyenmonkey.com</item>
    <item>tiki.vn</item>
    <item>gmail.com</item>
    <item>yahoo.com</item>
  </string-array>
</resources>
```

*Step 2:* Include view in your layout. At this time, I support 2 modes. The default one is `normal` that will suggest the whole text and the `email` one that will suggest the domain after `@`.
```xml
<com.tuyenmonkey.AutoFillEditText
      android:id="@+id/afetEmail"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      app:mode="email"
      app:suggestions="@array/emails"
      />
```

## Download
Gradle:
```groovy
dependencies {
  compile 'com.tuyenmonkey:auto-fill-edit-text:1.0.0'
}
```
Snapshots of the development version are available in [Sonatype's `snapshots` repository](https://oss.sonatype.org/content/repositories/snapshots/).

## License

    Copyright 2017 Tuyen Monkey

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
