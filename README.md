# 🏃‍♂️ Health and Fitness Tracker

A simple Java Swing GUI application to track user activity and estimate calories burned based on steps taken and distance walked. Designed with an aesthetic background and intuitive interface.

---

## 📸 Screenshots

### Input Form  
![Form](./images/inputform.png)

### Output Form
![Result](./images/outputform.png)

---

## 🚀 Features

- Input steps taken and distance in kilometers.
- Dynamically calculates estimated calories burned.
- Clean and modern UI with a motivational background.
- Error handling for invalid inputs.

---

## 🔧 How to Run

1. Ensure you have Java installed (JDK 8 or above).
2. Clone this repository or download the `.java` file.
3. Make sure the image `bgimg.jpg` is located in the correct path:  
   `images/bgimg.jpg`
4. Compile the Java file:

   ```bash
   javac src/fitnesstracker.java

---

## 📂 Folder Structure
   ```
   Health-FitnessTracker/
   ├── images/
   │      └── bgimg.jpg
   ├── src/
   │   └── fitnesstracker.java
   ├── README.md
   ```

---

## 🔢 Calorie Calculation Logic

   ```
   calories = (steps * 0.04) + (distance_km * 0.1);
   ```

- 0.04 calories per step
- 0.1 calories per kilometer walked
