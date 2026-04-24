# Unit Converter Application

A modern and intuitive temperature converter application for Android, built using **Kotlin** and **Material Design 3**. This app features a custom numeric keypad and supports real-time mathematical expression evaluation for flexible temperature conversions.
<img width="468" height="865" alt="image" src="https://github.com/user-attachments/assets/86ba8f6c-b56f-4c6f-a656-0b5214d90784" />

## Features

- **Real-time Conversion**: Instantly convert temperatures between Celsius and Fahrenheit as you type.
- **Mathematical Expression Support**: Integrated with [exp4j](https://www.objecthunter.net/exp4j/) to evaluate basic math expressions (e.g., `25 + 5`) directly in the input field.
- **Unit Swapping**: Easily toggle between Celsius and Fahrenheit as your primary input unit.

## Tech Stack

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: Material Design 3, ConstraintLayout
- **Architecture**: MVVM (Model-View-ViewModel)
- **Data Binding**: LiveData
- **External Library**: [exp4j](https://www.objecthunter.net/exp4j/) for expression evaluation.

## Project Highlights

- **`MainActivity.kt`**: Handles UI interactions, view initialization, and observes ViewModel state.
- **`MainViewModel.kt`**: Contains the core logic for temperature conversion, expression evaluation, and unit switching.
- **Custom Styling**: Uses custom XML drawables for a unique button and input appearance.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/fadillahrohman/unit-converter.git
   ```
2. Open the project in **Android Studio** (Ladybug or newer recommended).
3. Allow Gradle to sync and download dependencies.
4. Run the application on an emulator or physical device.

## Usage

1. Use the on-screen numeric keypad to enter a temperature.
2. You can enter simple math like `10 + 5` and the app will evaluate it before converting.
3. Tap the **SWAP** button to switch the input unit from Celsius to Fahrenheit or vice versa.
4. The result updates automatically in the output section.




---
Developed as a demonstration of Modern Android Development practices.
