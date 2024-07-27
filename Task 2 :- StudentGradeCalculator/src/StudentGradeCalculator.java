
import java.util.Scanner;

public class StudentGradeCalculator {
 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("STUDENT GRADE CALCULATOR");
        System.out.println("************************");

        int TotalMarks = 0;
        int TotalSubject;

        System.out.print("Enter total number of subjects : ");
        TotalSubject = sc.nextInt();

        for (int i = 1; i <= TotalSubject; i++) {
            System.out.print("Enter the marks of " + i + " subject : ");
            int marks = sc.nextInt();
            TotalMarks = TotalMarks + marks;
        }

        float AveragePercentage = (TotalMarks / (TotalSubject * 100.0f)) * 100.0f;

        char grade;
        if (AveragePercentage >= 90) {
            grade = 'A';
        } else if (AveragePercentage >= 80 && AveragePercentage < 90) {
            grade = 'B';
        } else if (AveragePercentage >= 70 && AveragePercentage < 80) {
            grade = 'C';
        } else if (AveragePercentage >= 60 && AveragePercentage < 70) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("************************");
        System.out.println("Total marks : " + TotalMarks);
        System.out.printf("Average percentage : %.2f \n" , AveragePercentage);
        System.out.println("Grade : " + grade);
        sc.close();
    }
}
