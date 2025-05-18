# 🤖 Dizzy Robot - Shake Detection Android App

A simple Android app written in Java that detects a shake (via the accelerometer sensor) and displays an animated GIF in response. Built as a technical test to demonstrate sensor-based interactions and animation handling in Android.

## 🚀 Features

- Detects phone shake using the accelerometer
- Displays a GIF animation upon shake detection
- A button to stop the GIF playback
- Clean and minimal architecture for easy extensibility

## 🛠 Technologies Used

- Java (Android SDK)
- Android Studio
- SensorManager (Accelerometer)
- [`android-gif-drawable`](https://github.com/koral--/android-gif-drawable) library for GIF support

## 📋 Requirements

- Android Studio 4.0+
- Minimum SDK: 24
- Place a GIF file named `dizzy.gif` in the `res/drawable/` directory

## 📦 Setup Instructions

1. Clone the repository:

   ```bash
   git clone https://github.com/sarahghorbani/dizzy-robot.git
   cd dizzy-robot
   ```

2. Open the project in Android Studio.

3. Add your GIF to `res/drawable/` and update its name in the layout and Java file if needed.

4. Run the app on a device or emulator.

## 📁 Project Structure

```
app/
├── java/
│   └── com.example.dizzy_robot/
│       └── MainActivity.java
├── res/
│   ├── layout/
│   │   └── activity_main.xml
│   └── drawable/
│       └── dizzy.gif
```

## ⚙️ Gradle Configuration

Make sure to include the GIF library in your `build.gradle (Module)`:

```gradle
implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.27'
```

And add this to your `build.gradle (Project)` if not already present:

```gradle
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
```

## 👤 Author

- Name: [Sara Ghorbani]
- GitHub: [https://github.com/sarahghorbani](https://github.com/sarahghorbani)
- Email: sara.qorbani73@gmail.com

## 📄 License

This project is licensed under the MIT License – see the [LICENSE](LICENSE) file for details.

---

Made with ❤️ for a hands-on technical assessment challenge.
