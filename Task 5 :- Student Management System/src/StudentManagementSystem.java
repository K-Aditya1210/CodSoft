import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Student {

    private String name;
    private int rollNo;
    private String grade;
    public String store = "";

    public Student(String name, int rollNo, String grade) throws IOException
    {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
        strStore();
    }

    public void strStore() throws IOException{

        store = store.concat(name);
        store = store.concat("+"+Integer.toString(rollNo));
        store = store.concat("+"+grade);
        store = store.replace("+", ",");

        String csvFilePath = "datastudent.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true))) {
            writer.write(store);
            writer.newLine();
        }

    }

    public int getRollNo() {
        return rollNo;
    }

    public void showDetials() {
        System.out.println(name);
        System.out.println(rollNo);
        System.out.println(grade);
    }

    @Override
    public String toString() {
        return "Name : " + name + "\nRoll no : " + rollNo + "\nGrade : " + grade;
    }

}

class studentManagemnetSystem {

    private ArrayList<Student> students;

    public studentManagemnetSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student std) {
        students.add(std);
    }

    public boolean removeStudent(int roll_no) {
        for (Student S1 : students) {
            if (S1.getRollNo() == roll_no) {
                students.remove(S1);
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(int roll_no) {
        for (Student S1 : students) {
            if (S1.getRollNo() == roll_no) {
                return S1;
            }
        }
        return null;

    }

    public ArrayList<Student> displayAllStudents() {
        return students;
    }

}

public class StudentManagementSystem  {

    public static void main(String args[])throws IOException {

        System.out.println("STUDENT MANAGEMENT SYSTEM");
        System.out.println("****************************************");

        Scanner sc = new Scanner(System.in);
        studentManagemnetSystem SMS = new studentManagemnetSystem();

        while (true) {

            System.out.println("1. Add Student.");
            System.out.println("2. Remove Student.");
            System.out.println("3. Search Student.");
            System.out.println("4. display all Student.");
            System.out.println("5. Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            System.out.println("****************************************");
            sc.nextLine();

            switch (choice) {
                case 1:

                    System.out.print("Enter Student name : ");
                    String name = sc.nextLine();
                    System.out.print("Enter student roll no : ");
                    int rollAdd = sc.nextInt();
                    System.out.print("Enter Student Grade : ");
                    String grade = sc.next();

                    Student newStudent = new Student(name, rollAdd, grade);
                    SMS.addStudent(newStudent);
                    System.out.println("Student added Successfully!");
                    System.out.println("****************************************");
                    break;

                case 2:
                    System.out.print("Enter Roll no : ");
                    int rollRemove = sc.nextInt();
                    if (SMS.removeStudent(rollRemove)) {
                        System.out.println("Student remove successfully!");
                        System.out.println("****************************************");
                    } else {
                        System.out.println("Student not found...");
                        System.out.println("****************************************");
                    }

                    break;

                case 3:
                    System.out.print("Enter roll no : ");
                    int rollSearch = sc.nextInt();
                    Student searchStudent = SMS.searchStudent(rollSearch);
                    if (searchStudent == null) {
                        System.out.println("Student not found.");
                        System.out.println("****************************************");
                    } else {
                        System.out.println("Student found! ");
                        System.out.println(searchStudent);
                        System.out.println("****************************************");
                    }

                    break;

                case 4:
                    ArrayList<Student> allStudents = SMS.displayAllStudents();
                    if (allStudents.isEmpty()) {
                        System.out.println("No student to be display.");
                        System.out.println("****************************************");
                    } else {
                        System.out.println("ALL STUDENTS");
                        for (Student student : allStudents) {
                            System.out.println(student);
                            System.out.println("****************************************");
                        }
                    }

                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice try again...");
                    break;

            }
        }
    }
}
