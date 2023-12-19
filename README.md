# Bookstore

## Project Description
Bookstore allows you to browse a specific user's book collection through a login.

## Main Features

- ### Splash
  The application presents a splash screen upon opening.

- ### Login
  Implements a login system that uses SharedPreferences to securely store the user's session and Retrofit to manage the login.

- ### Landing
  After logging in, users are redirected to the home page to explore the book library.

## Stack

- ### API consumption
  Uses Retrofit to make HTTP requests and get information about the books from an external API.

- ### Glide for Image Loading
  Uses the Glide library to efficiently and smoothly load book images.

- ### Dependency Injection with Dagger Hilt
  Implements Dagger Hilt to perform dependency injection.

- ### XML, Android Studio, and Kotlin
  The application was developed in Android Studio with the Kotlin programming language and XML for the creation of the user interface.

- ### MVVM and Clean Architecture
  The application follows the MVVM design pattern to achieve a modular and maintainable code architecture, incorporating Clean Architecture principles.
  
## Execution Instructions

1. Clone the repository.
2. Open the project in Android Studio.
3. Compile and run the application on an emulator or Android device.
