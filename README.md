# Student Grade Manager

A command-line application written in Java for recording students and their grades and for computing basic statistics. It was built as an academic exercise in core Java: static data structures, loops, console input handling, and exception handling.

## Features

- **Add a student** with a name and an integer grade (up to 100 students).
- **Look up a student** by the index they were assigned when added.
- **List all students** with their index, name, and grade out of 100.
- **Compute the average grade** of the recorded students.
- **Menu input validation:** non-numeric input in the main menu is caught (`InputMismatchException`) and reported instead of crashing the program.

## Project Structure

```
student-grade-manager/
├── src/
│   └── StudentGradeManager.java   # Application source code
├── .gitignore
└── README.md
```

## Requirements

- **JDK 25 or newer.** The program declares its entry point as `static void main(String[] args)` (without `public`), which the Java launcher supports starting from JDK 25.

## Build and Run

From the project root:

```bash
# Compile
javac -d out src/StudentGradeManager.java

# Run
java -cp out StudentGradeManager
```

Or run the source file directly:

```bash
java src/StudentGradeManager.java
```

## Usage

The program shows a menu in a loop:

```
what do you want to do
 add a student (1)
 show students (2)
 show all students with their number (3)
 students grade average (4)
 number>>
```

| Option | Action |
| ------ | ------ |
| `1` | Prompts for a student name and grade, stores them, and prints the assigned index. |
| `2` | Prompts for a student index and prints that student's name and grade. |
| `3` | Prints every student as `index -- name -- grade/100`. |
| `4` | Prints the average of the recorded grades. |

The program runs until it is terminated manually (`Ctrl + C`).

### Example

```
number>> 1
Enter student name: Alice
Enter student grade: 90
Alice GRADE 90.0 added as number 0
```

## Implementation Notes

- Students are stored in two parallel fixed-size arrays (`studentsNames` and `studentsGrades`) with a capacity of 100, plus a counter (`studentsNumber`).
- All data lives in memory only; nothing is saved when the program exits.
- Each menu action is implemented as its own static method: `addStudent`, `showStudents`, `studentsInfo`, and `studentGradesAverage`.

## Known Limitations

This is a learning project, and the following points are documented as areas for improvement:

- **Average calculation:** `studentGradesAverage()` iterates over `studentsNumber + 1` entries and divides by `studentsNumber + 1`, so it includes one unused (zero) slot and returns a value lower than the true average.
- **Lookup (option 2):** the entered index is not range-checked, and non-integer input there is not caught.
- **Grade input:** grades are read as integers (`nextInt`), so decimal values are not accepted.
- **No exit option** and **no persistent storage** (file or database).

## Possible Future Work

- Fix the average calculation and add bounds checking for lookups.
- Add an explicit exit option to the menu.
- Replace the parallel arrays with a `Student` class and an `ArrayList<Student>`.
- Persist data to a file.
- Add unit tests (e.g., JUnit).
