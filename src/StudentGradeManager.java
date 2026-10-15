import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentGradeManager {

    static String[] studentsNames = new String[100];
    static double[] studentsGrades = new double[100];
    static int studentsNumber = 0;



    static void addStudent() {
        if (studentsNumber != 100) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            studentsNames[studentsNumber] = studentName;
            System.out.print("Enter student grade: ");
            int studentGrade = scanner.nextInt();
            studentsGrades[studentsNumber] = studentGrade;
            System.out.println(studentsNames[studentsNumber] + " GRADE " + studentsGrades[studentsNumber] + " added as number " + studentsNumber);
            studentsNumber++;
        }
        else
            System.out.println("your out of space max student number is 100");

    }

    static void showStudents(int studentnumber) {
        System.out.println("The student number " + studentnumber + " is " + studentsNames[studentnumber] + " and there Grade is " + studentsGrades[studentnumber]);

    }


    static void studentsInfo() {
        int counter = 0;
        while (counter <= studentsNumber - 1) {
            boolean test = counter == studentsNumber;
            System.out.println(counter + " -- " + studentsNames[counter] + " -- " + studentsGrades[counter] + "/100");
            counter++;
        }
    }

    static void studentGradesAverage() {
        double sum = 0;
        int counter = 0;
        while (counter != studentsNumber + 1) {
            sum = sum + studentsGrades[counter];
            counter++;
        }
        double average = sum / (studentsNumber + 1);
        System.out.println("Students grades average is: " + average);

    }

    static void main(String[] args)  {

        while (true) {
            int input = 0;
            Scanner mainScanner = new Scanner(System.in);
            System.out.print("what do you want to do \n add a student (1) \n show students (2) \n show all students with their number (3) \n students grade average (4) \n number>> ");

            try {
                 input = mainScanner.nextInt();
            } catch(InputMismatchException error) {
                System.out.println("INVALID INPUT PLEASE ENTER AN INTEGER NUMBER");
            }

            if (input == 1) {
                addStudent();
            } else if (input == 2) {
                Scanner if2 = new Scanner(System.in);
                System.out.print("Enter student number: ");
                int studentNumber = if2.nextInt();
                showStudents(studentNumber);
            } else if (input == 3) {
                if (studentsNumber == 0) {
                    System.out.println("No students added");
                }
                else {
                    studentsInfo();
                }
            } else if (input == 4) {
                if (studentsNumber == 0) {
                    System.out.println("No students added");
                }
                else {
                    studentGradesAverage();
                }


            }
            else
                System.out.println("invalid number");
        }
    }

}
