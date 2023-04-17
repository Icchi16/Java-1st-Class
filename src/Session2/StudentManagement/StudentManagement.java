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
                    themStudent();
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
        int studentCount = 0;
        for ( Student student: studentsList
             ) {
            studentCount++;
            System.out.println("Học sinh " + studentCount + ": [Tên: " + student.getName() + " | Giới tính: " + (student.isGender() ? "Nam" : "Nữ") + " | Độ tuổi: " + student.getAge() + " | Địa chỉ: " + student.getAddress() + " | Tình trạng: " + (student.isStatus() ? "Còn sống" : "Toang rồi ông giáo ạ =<"));
        }
        System.out.println("---------------- Students ----------------");
    }

    public boolean themStudent () {// nhập id tự tăng
        System.out.println("---------------- Add Student ----------------");

        System.out.println("Vui lòng nhập tên học sinh");
        String newStudentName = scanner.nextLine();

        System.out.println("Vui lòng chọn giới tính học sinh mới");
        System.out.println("Nam  -----> 1");
        System.out.println("Nữ -------> 2");
        Boolean newStudentGender = null;
        while (newStudentGender == null) {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    newStudentGender = true;
                    break;
                case 2:
                    newStudentGender = false;
                    break;
                default:
                    System.out.println("Đọc yêu cầu cho kỹ vào!!! Nhá");
                    break;
            }
        }

        System.out.println("Vui lòng nhập độ tuổi học sinh mới");
        int newStudentAge = Integer.parseInt(scanner.nextLine());
        System.out.println("Vui lòng nhập địa chỉ học sinh mới");
        String newStudentAddress = scanner.nextLine();
        System.out.println("Học sinh còn sống hay đã ...");
        System.out.println("Sống ------> 1");
        System.out.println("... -------> 2");
        Boolean newStudentStatus = null;
        while (newStudentStatus == null) {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    newStudentStatus = true;
                    break;
                case 2:
                    newStudentStatus = false;
                    break;
                default:
                    System.out.println("Đọc yêu cầu cho kỹ vào!!! Nhá");
                    break;
            }
        }
        int newStudentId = getNewId(studentsList);

        Student newStudent = new Student(newStudentId,newStudentName,newStudentGender,newStudentAge,newStudentAddress,newStudentStatus);

        Student newStudentsList[] = new Student[studentsList.length + 1];

        for (int i = 0; i < studentsList.length; i++) {
            newStudentsList[i] = studentsList[i];
        }

        newStudentsList[newStudentsList.length - 1] = newStudent;

        studentsList = newStudentsList;
        System.out.println("---------------- Đã thêm học sinh thành công ----------------");
        return true;




    }

    public void botStudent () {
        System.out.println("---------------- Remove Student ----------------");
        System.out.println("Vui lòng nhập Id học sinh muốn thủ tiêu");
        int id = Integer.parseInt(scanner.nextLine());
        Student newStudentsList[] = new Student[studentsList.length - 1];
        if ( findById(id) != null) {
            int indexModifier = 0;
            for (int i = 0; i < newStudentsList.length; i++) {
                if (studentsList[i].getId() != id) {
                    newStudentsList[i] = studentsList[i + indexModifier];
                } else {
                    indexModifier++;
                    newStudentsList[i] = studentsList[i + indexModifier];
                }
            }
            studentsList = newStudentsList;
            System.out.println("---------------- Thủ tiêu thành công ----------------");
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

    public int getNewId(Student[] students) {
        int maxId = 0;
        for (Student student: students
             ) {
            if (student.getId() > maxId) {
                maxId = student.getId();
            }
        }
        maxId++;
        return maxId;
    }
}
