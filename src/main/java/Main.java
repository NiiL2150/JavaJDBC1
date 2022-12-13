import com.microsoft.sqlserver.jdbc.SQLServerException;
import models.GroupModel;
import models.Student;
import models.Teacher;
import services.JdbcService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        try {
//            JdbcService jdbcService = new JdbcService();
//            jdbcService.createStudentTable();
//            jdbcService.createStudent(new Student("Ivan Ivanov", 23));
//            List<Student> studentList = new ArrayList<>();
//            studentList.add(new Student("Oleg Shein", 25));
//            studentList.add(new Student("Vadim Ustimenko", 25));
//            studentList.add(new Student("Vlad Ursol", 24));
//            jdbcService.createStudents(studentList);
//            System.out.println(jdbcService.getAllStudents());
//            System.out.println("hello");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        try {
            JdbcService jdbcService = new JdbcService();
            try { jdbcService.createStudentTable(); } catch (Exception ignored) {}
            try { jdbcService.createTeacherTable(); } catch (Exception ignored) {}
            try { jdbcService.createGroupTable(); } catch (Exception ignored) {}

            while(true){
                System.out.println("1. Create student");
                System.out.println("2. Create teacher");
                System.out.println("3. Create group");
                System.out.println("4. Add student to group");
                System.out.println("5. Add teacher to group");
                System.out.println("6. Get all students");
                System.out.println("7. Get all teachers");
                System.out.println("8. Get all groups");
                System.out.println("9. Get all students from group");
                System.out.println("10. Remove teacher from group");
                System.out.println("11. Remove student from group");
                System.out.println("0. Exit");
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Enter student name");
                        String studentName = scanner.next();
                        System.out.println("Enter student age");
                        int studentAge = scanner.nextInt();
                        jdbcService.createStudent(new Student(studentName, studentAge));
                        break;
                    case 2:
                        System.out.println("Enter teacher name");
                        String teacherName = scanner.next();
                        System.out.println("Enter teacher age");
                        int teacherAge = scanner.nextInt();
                        jdbcService.createTeacher(new Teacher(teacherName, teacherAge));
                        break;
                    case 3:
                        System.out.println("Enter group name");
                        String groupName = scanner.next();
                        System.out.println("Enter group teacher id");
                        int groupTeacherId = scanner.nextInt();
                        jdbcService.createGroup(new GroupModel(groupName, groupTeacherId));
                        break;
                    case 4:
                        System.out.println("Enter student id");
                        int studentId = scanner.nextInt();
                        System.out.println("Enter group id");
                        int groupId = scanner.nextInt();
                        jdbcService.addStudentToGroup(studentId, groupId);
                        break;
                    case 5:
                        System.out.println("Enter teacher id");
                        int teacherId = scanner.nextInt();
                        System.out.println("Enter group id");
                        int groupId1 = scanner.nextInt();
                        jdbcService.addTeacherToGroup(teacherId, groupId1);
                        break;
                    case 6:
                        System.out.println(jdbcService.getAllStudents());
                        break;
                    case 7:
                        System.out.println(jdbcService.getAllTeachers());
                        break;
                    case 8:
                        System.out.println(jdbcService.getAllGroups());
                        break;
                    case 9:
                        System.out.println("Enter group id");
                        int groupId2 = scanner.nextInt();
                        System.out.println(jdbcService.getStudentsByGroupId(groupId2));
                        break;
                    case 10:
                        System.out.println("Enter teacher id");
                        int teacherId1 = scanner.nextInt();
                        jdbcService.deleteTeacherFromGroup(teacherId1);
                        break;
                    case 11:
                        System.out.println("Enter student id");
                        int studentId1 = scanner.nextInt();
                        jdbcService.deleteStudentFromGroup(studentId1);
                        break;
                    case 0:
                        System.exit(0);
                }
                System.out.println("Press any key to continue");
                System.in.read();
                System.out.println("\n\n");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
