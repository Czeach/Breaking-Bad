# Breaking-Bad
This is a simple Kotlin Multiplatform Mobile project that retrieves and stores all the characters of the Breaking Bad series from the breaking bad API.
The data is cached int an SQLDelight database and displayed to the user from the database. The user can also search for characters by name.

## Libraries used
* [Ktor client:](https://ktor.io/) a multiplatform asynchronous HTTP client that allows you make network requests and handle responses, etc
* [Hilt:](https://developer.android.com/training/dependency-injection/hilt-android) a dependency injection library for Android that provides a standard way to use DI in your application by providing containers for every Android class in your project and managing their lifecycles automatically.
* [SQLDelight:](https://github.com/cashapp/sqldelight) SQLDelight is a cross-platform database library that generates typesafe kotlin APIs from SQL statements.
* [Kotlin Flow:](https://developer.android.com/kotlin/flow)  a conceptually a stream of data that can be computed asynchronously.
* [Jetpack compose:](https://developer.android.com/jetpack/compose?gclsrc=aw.ds&gclid=CjwKCAiA8bqOBhANEiwA-sIlN89YfvkT4TPJ3hbJCjJZswubf_cEPkYvEtYmbghr8Bl1rjWpX1qMNhoCUWkQAvD_BwE) Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android.
* [Accompanist coil:](https://github.com/google/accompanist) Accompanist is a group of libraries that aim to supplement Jetpack Compose with features that are commonly required by developers but not yet available.


```

MIT LICENSE

Copyright (c) 2021 Ezichi Amarachi

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to
do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
IN THE SOFTWARE.

```