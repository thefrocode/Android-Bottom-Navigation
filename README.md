# Bottom Navigation Example

This project demonstrates three different ways to implement bottom navigation in an Android application using Jetpack Compose and traditional XML-based layouts.

## Table of Contents

1. [Overview](#overview)
2. [Technologies Used](#technologies-used)
3. [Setup and Run](#setup-and-run)
4. [Implementation Details](#implementation-details)
    - [1. Bottom Navigation with Fragments](#1-bottom-navigation-with-fragments)
    - [2. Bottom Navigation with NavController and XML](#2-bottom-navigation-with-navcontroller-and-xml)
    - [3. Bottom Navigation with Jetpack Compose](#3-bottom-navigation-with-jetpack-compose)

## Overview

This repository showcases three different approaches to implementing a bottom navigation bar in Android:
- **BottomNavigationOne**: Uses traditional XML and `Fragments`.
- **BottomNavigationTwo**: Uses `NavController` and `BottomNavigationView` with XML-based navigation.
- **BottomNavigationThree**: Uses Jetpack Compose for a fully Compose-based UI, including navigation.

## Technologies Used

- **Jetpack Compose**
- **Navigation Component**
- **Material Design Components**
- **Kotlin**
- **Fragments (for legacy UI)**

## Setup and Run

To set up and run this project:

1. Clone the repository.
   ```bash
   git clone https://github.com/your-repo-url/bottom-navigation-example.git
# Bottom Navigation Example

This project demonstrates three different ways to implement bottom navigation in an Android application using Jetpack Compose and traditional XML-based layouts.

## Setup and Run

2. Open the project in Android Studio.
3. Build and run the project on an emulator or a physical device.

## Implementation Details

### 1. Bottom Navigation with Fragments

This approach (**BottomNavigationOne**) demonstrates the use of `BottomNavigationView` with `Fragments`. It manually handles fragment transactions and updates the UI based on user interaction with the bottom navigation items.

**Key Features:**
- **Fragment-based UI**: Each tab in the navigation switches between different fragments.
- **Manual Fragment Transactions**: Using `supportFragmentManager` to replace the content view.
- **Badge Support**: Badges are displayed on the navigation icons.

### 2. Bottom Navigation with NavController and XML

In this approach (**BottomNavigationTwo**), the `NavController` is used in conjunction with the `BottomNavigationView`. Navigation actions are managed via an XML navigation graph, enabling smoother transitions and back-stack management.

**Key Features:**
- **NavController and XML-based navigation**: This provides a more structured way of handling navigation between different sections.
- **No manual fragment management**: The `NavController` automatically handles fragment transactions.

### 3. Bottom Navigation with Jetpack Compose

In this implementation (**BottomNavigationThree**), Jetpack Compose is used to create a fully compose-based UI. The `NavHost` is used for navigation, and `Scaffold` for laying out the screen with a bottom navigation bar.

**Key Features:**
- **Fully Compose-based UI**: Leverages Jetpack Compose to create a modern and declarative UI.
- **Compose Navigation**: Uses the `NavHost` for managing screen navigation.
- **Badges and Icons**: Badges and dynamic icons are displayed within the bottom navigation bar.

