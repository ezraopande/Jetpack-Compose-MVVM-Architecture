# MVVM Architecture Project in Kotlin with Jetpack Compose

This project demonstrates the implementation of the MVVM (Model-View-ViewModel) architecture using Kotlin and Jetpack Compose. The project includes screen navigation, a bottom navigation bar, a floating action button (FAB), and an image slider for enhanced user experience.

## Features

- **MVVM Architecture**: Separation of concerns by dividing the app into Model, View, and ViewModel layers.
- **Jetpack Compose**: UI development with declarative and modern UI toolkit.
- **Navigation**: Seamless navigation between different screens.
- **Bottom Navigation**: A bottom navigation bar for easy switching between main sections.
- **Floating Action Button (FAB)**: A FAB for quick access to key actions.
- **Image Slider**: A visually appealing horizontal image slider with smooth transitions and animations.

## Project Structure

The project is organized into the following packages:

- **model/**: Contains the data classes and repository for data handling.
- **view/**: Composables that define the UI for different screens.
- **viewmodel/**: ViewModel classes that hold UI data and business logic.

## Screens

- **Home Screen**: Displays main content with a top app bar, bottom navigation, a FAB, and an image slider.
- **Detail Screen**: A secondary screen that can be navigated to from the Home Screen.

## Navigation

Navigation in this project is handled using the `NavController` provided by Jetpack Compose. Each screen is linked through a composable function, and the navigation logic is managed in the ViewModel layer to maintain clean separation of concerns.

## How to Run

1. **Clone the repository:**

    ```bash
    git clone https://github.com/ezraopande/Jetpack-Compose-MVVM-Architecture.git
    ```

2. **Open the project in Android Studio:**

    - Make sure you have the latest version of Android Studio installed.

3. **Build and run the project:**

    - Select an emulator or connected device and click the "Run" button.

## Dependencies

- **Jetpack Compose**: For building the UI.
- **Navigation Component**: For handling in-app navigation.
- **Kotlin Coroutines**: For managing asynchronous tasks.
- **ViewModel & LiveData**: For managing UI-related data in a lifecycle-conscious way.

## Usage

- **Home Screen**: Contains a top app bar with a title, a bottom navigation bar for switching between sections, a FAB for additional actions, and an image slider for showcasing visuals.
- **Bottom Navigation**: Switch between different sections of the app.
- **FAB**: Triggers actions like opening a new screen or performing quick tasks.
- **Image Slider**: Displays a carousel of images with smooth transitions and animations to enhance the user experience.
- **ViewModel**: Handles the UI logic and manages the data displayed on the screen.

## Contact

For any questions or feedback, feel free to reach out to:

- Email: [ezraopande@gmail.com](mailto:ezraopande@gmail.com)
- Phone: +254796759850

---

*This project is maintained by [Ezra Opande](https://github.com/ezraopande).*
