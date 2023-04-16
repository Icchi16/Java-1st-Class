package Session2.StudentManagement;

import java.util.Arrays;
import java.util.Scanner;

public class StudentManagement {
    public static Scanner scanner = new Scanner(System.in);
    Student student1 = new Student(1, "Trần Thị Ku", true, 20, "Lao", true);
    Student student2 = new Student(2, "Anh Duy Tồ", false, 42, "Vietnam", false);
    Student student3 = new Student(3, "Anh Duy Tồ 2", false, 42, "Vietnam", false);
    Student student4 = new Student(4, "Anh Duy Tồ 3", false, 42, "Vietnam", false);
    public Student[] studentsList = {student1,student2,student3,student4};


    public StudentManagement() {
        while (true) {
            System.out.println("---------------------- Student Management ----------------------");
            System.out.println("1. Show List Students");
            System.out.println("2. Create Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Sort List Students");
            System.out.println("6. Exit");
            System.out.println("---------------------- Student Management ----------------------");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showListStudents();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    botStudent();
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new StudentManagement();
    }

    public void showListStudents () {
        System.out.println("---------------- Students ----------------");
        for ( Student student: studentsList
             ) {
            System.out.println(student);
        }
        System.out.println("---------------- Students ----------------");
    }

    public boolean themStudent (Student student) {// nhập id tự tăng
        Student newStudentsList[] = new Student[studentsList.length + 1];
        for (int i = 0; i < studentsList.length; i++) {
            newStudentsList[i] = studentsList[i];
        }
        newStudentsList[newStudentsList.length - 1] = student;
        studentsList = newStudentsList;
        return true;
    }

    public void botStudent () {
        System.out.println("Nhập Id Student muốn thủ tiêu");
        int id = Integer.parseInt(scanner.nextLine());
        Student newStudentsList[] = new Student[studentsList.length - 1];
        if ( findById(id) != null) {
            int currentOldStudentListIndex = 0;
            for (int i = 0; i < newStudentsList.length; i++) {
                if (studentsList[i].getId() != id) {
                    newStudentsList[i] = studentsList[i + currentOldStudentListIndex];
                } else {
                    currentOldStudentListIndex++;
                    newStudentsList[i] = studentsList[i + currentOldStudentListIndex];
                }
            }
            studentsList = newStudentsList;
            System.out.println("Thủ tiêu thành công!");
        }
    }

    public Student findById(int id) {
        for (Student student: studentsList
             ) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
