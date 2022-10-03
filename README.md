# Breaking-Bad
This is a simple Kotlin Multiplatform Mobile project that retrieves and stores all the characters of the Breaking Bad series from the breaking bad API and displays the results in a list.
The data is cached in an SQLDelight database and displayed to the user from the database. The user can also search for characters by name. This application is built entirely with Jetpack Compose.

## Libraries used
* MVVM and clean architecture
* Jetpack Compose for UI
* Multi-platform support from KMM
* Hilt for dependency injection
* Kotlin ktor for network call
* SQLDelight database for offline caching
* Compose Navigation for smooth navigation
* Kotlin Flow to handle network calls
* JUnit and Mockito for unit testing
* Accompanist coil for loading images
* Explicit error handling system

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