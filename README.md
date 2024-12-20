﻿# Assignment-On-Junit_2
# Guest Registration Form Automation

This project automates the user registration process on the [WP Everest Guest Registration Form](https://demo.wpeverest.com/user-registration/guest-registration-form/) using **Selenium WebDriver** with **Java**, and built with **Gradle**.

## Tech Stack

- **Java**: Core language for automation.
- **Selenium WebDriver**: Tool for automating web applications.
- **IntelliJ IDEA**: IDE used for writing and running the automation scripts.
- **Gradle**: Build automation tool for managing dependencies.
- **JUnit**: Framework for structuring and running test cases.

## Automation Flow

### Fields Automated

1. **Basic Information**:
    - First Name
    - Last Name
    - User Email
    - Password
    - Gender (Radio Button)

2. **Contact Details**:
    - Nationality
    - Phone Number
    - Emergency Contact

3. **Dates**:
    - Date of Birth (Date Picker)
    - Arrival Date (Date Picker)

4. **Additional Information**:
    - Length of Stay
    - Room and Bed Preference
    - Occupation and Place of Employment
    - Dietary Requirements (Radio Button)
    - Parking Preference (Radio Button)
    - Room Preference (Radio Button)

5. **Location**:
    - Country: Bangladesh (Dropdown)

6. **Agreement**:
    - Terms & Conditions (Checkbox)

### Form Submission

- After filling all the required fields, the form is submitted automatically.

### Validation

- The script validates that the registration was successful by checking for a success message or handling errors like "Email already exists."

## Project Structure

```bash
.
├── src/               # Source code with the automation script         
└── README.md          # Project documentation
```


## Video Demo



https://github.com/user-attachments/assets/cd97d81f-fdfc-4f2e-8834-cc68723f0ee2


---

**Project Status**: Functional and ready for use.

