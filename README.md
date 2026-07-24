# Radar Traffic Violation System

## Overview

The Radar Traffic Violation System is a Java-based application that simulates a traffic radar used to detect road violations and issue fines. The system processes vehicle observations, checks them against a set of traffic rules, generates violations when necessary, and produces reports of issued fines and violated rules.

The project was developed with a simple, extensible object-oriented design, allowing new traffic rules to be added without modifying the radar processing logic.

---

## Features

- Record vehicle observations including:
  - Plate number
  - Date of observation
  - Vehicle type (Private, Truck, Bus)
  - Vehicle speed
  - Seatbelt status

- Validate user input for:
  - Vehicle type
  - Date format
  - Speed
  - Seatbelt status

- Detect multiple violations for a single vehicle.

- Generate fines containing:
  - Plate number
  - Date
  - List of violations
  - Individual violation fees
  - Total fine amount

- Display reports for:
  - All issued fines
  - Number of violations for each traffic rule

---

## Traffic Rules

The current implementation includes the following rules:

- Truck speed must not exceed **60 km/h**
- Private car speed must not exceed **80 km/h**
- Seatbelt must be fastened

The system can be easily extended by adding new rule classes.

---

## Project Structure

```text
src/
│
├── model/
│   ├── CarDetails.java
│   ├── CarType.java
│   ├── Fine.java
│   └── Violation.java
│
├── rules/
│   ├── ViolationRule.java
│   ├── PrivateSpeedRule.java
│   ├── TruckSpeedRule.java
│   └── SeatbeltRule.java
│
├── service/
│   ├── Radar.java
│   └── FineManager.java
│
└── Main.java
```

---

## Object-Oriented Design

The project follows a modular design:

- **Model** contains the application's data objects.
- **Rules** encapsulate each traffic rule independently.
- **Service** contains the radar processing and fine management logic.

The `Radar` class is independent of specific rules. It simply processes all registered `ViolationRule` objects, making the system easy to extend.

---

## Extending the System

To add a new traffic rule:

1. Create a new class implementing `ViolationRule`.
2. Implement the rule logic.
3. Register the rule in `Main.java`.

No modifications to the `Radar` class are required.

---

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework
- LocalDate API

---

## Sample Workflow

1. Enter vehicle information.
2. The radar checks every registered rule.
3. Zero or more violations are generated.
4. A fine is issued if violations exist.
5. Reports can be displayed showing all fines and rule violation statistics.

---

## Future Improvements

Possible enhancements include:

- Store data in a database.
- Export reports to PDF or CSV.
- Graphical User Interface (GUI).
- Dynamic rule loading from configuration files.
- Different fine amounts based on the degree of speeding.
- Search fines by plate number or date.

---

## Learning Objectives

This project demonstrates:

- Object-Oriented Programming principles
- Encapsulation
- Polymorphism through interfaces
- Extensible software design
- Input validation
- Exception handling
- Collection manipulation using Lists and Maps

---

## Author

Developed as an Object-Oriented Programming project using Java.
