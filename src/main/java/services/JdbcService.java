package services;

import models.GroupModel;
import models.Student;
import models.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcService {
    private static final String url = "jdbc:sqlserver://localhost:port;database=javatest;";
    private static final String user = "enter here your username";
    private static final String pass = "enter here your password";

    public JdbcService() throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    public void createStudentTable() {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE Student(" +
                    "id INT PRIMARY KEY IDENTITY (1,1), " +
                    "fullName NVARCHAR(50) NOT NULL, " +
                    "age INT NOT NULL, " +
                    "groupId INT NULL)");

            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public void createStudent(Student student) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute("INSERT INTO Student(fullname, age, groupId) VALUES ('" + student.getFullName() + "', " + student.getAge() + ", " + student.getGroupId() + ")");

            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public void createStudents(List<Student> students) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Student(fullname, age, groupId) VALUES (?, ?, ?)");
            students.stream().forEach(student -> {
                try {
                    preparedStatement.setString(1, student.getFullName());
                    preparedStatement.setInt(2, student.getAge());
                    preparedStatement.setInt(3, student.getGroupId());
                    preparedStatement.addBatch();
                } catch (SQLException ignored) {
                    // throwables.printStackTrace();
                }
            });
            preparedStatement.executeBatch();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Student");
            while(resultSet.next()) {
                Student item = new Student();
                item.setId(resultSet.getInt(1));
                item.setFullName(resultSet.getString(2));
                item.setAge(resultSet.getInt("age"));
                item.setGroupId(resultSet.getInt("groupId"));
                list.add(item);
            }
            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
        return list;
    }

    public void createTeacherTable() {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE Teacher(" +
                    "id INT PRIMARY KEY IDENTITY (1,1), " +
                    "fullName NVARCHAR(50) NOT NULL, " +
                    "groupId INT NULL)");

            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public void createTeacher(Teacher teacher) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute("INSERT INTO Teacher(fullname, groupId) VALUES ('" + teacher.getFullName() + "', " + teacher.getGroupId() + ")");

            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public void createTeachers(List<Teacher> teachers) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Teacher(fullname, groupId) VALUES (?, ?)");
            teachers.stream().forEach(student -> {
                try {
                    preparedStatement.setString(1, student.getFullName());
                    preparedStatement.setInt(2, student.getGroupId());
                    preparedStatement.addBatch();
                } catch (SQLException ignored) {
                    // throwables.printStackTrace();
                }
            });
            preparedStatement.executeBatch();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public List<Teacher> getAllTeachers() {
        List<Teacher> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Teacher");
            while(resultSet.next()) {
                Teacher item = new Teacher();
                item.setId(resultSet.getInt(1));
                item.setFullName(resultSet.getString(2));
                item.setGroupId(resultSet.getInt("groupId"));
                list.add(item);
            }
            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
        return list;
    }

    public void createGroupTable() {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE [Group](" +
                    "id INT PRIMARY KEY IDENTITY (1,1), " +
                    "name NVARCHAR(50) NOT NULL, " +
                    "teacherId INT NULL)"
            );

            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public void createGroup(GroupModel group) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute("INSERT INTO [Group](name, teacherId) VALUES ('" + group.getName() + "', " + group.getTeacherId() + ")");

            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public void createGroups(List<GroupModel> groups) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO [Group](name, teacherId) VALUES (?, ?)");
            groups.stream().forEach(student -> {
                try {
                    preparedStatement.setString(1, student.getName());
                    preparedStatement.setInt(2, student.getTeacherId());
                    preparedStatement.addBatch();
                } catch (SQLException ignored) {
                    // throwables.printStackTrace();
                }
            });
            preparedStatement.executeBatch();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public List<GroupModel> getAllGroups() {
        List<GroupModel> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [Group]");
            while(resultSet.next()) {
                GroupModel item = new GroupModel();
                item.setId(resultSet.getInt(1));
                item.setName(resultSet.getString(2));
                item.setTeacherId(resultSet.getInt("teacherId"));
                list.add(item);
            }
            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
        return list;
    }

    public List<Student> getStudentsByGroupId(int groupId) {
        List<Student> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Student WHERE groupId = " + groupId);
            while(resultSet.next()) {
                Student item = new Student();
                item.setId(resultSet.getInt(1));
                item.setFullName(resultSet.getString(2));
                item.setGroupId(resultSet.getInt("groupId"));
                list.add(item);
            }
            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
        return list;
    }

    public Student getStudentById(int id) {
        Student student = new Student();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Student WHERE id = " + id);
            while(resultSet.next()) {
                student.setId(resultSet.getInt(1));
                student.setFullName(resultSet.getString(2));
                student.setGroupId(resultSet.getInt("groupId"));
            }
            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
        return student;
    }

    public Teacher getTeacherById(int id) {
        Teacher teacher = new Teacher();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Teacher WHERE id = " + id);
            while(resultSet.next()) {
                teacher.setId(resultSet.getInt(1));
                teacher.setFullName(resultSet.getString(2));
                teacher.setGroupId(resultSet.getInt("groupId"));
            }
            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
        return teacher;
    }

    public GroupModel getGroupById(int id) {
        GroupModel group = new GroupModel();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [Group] WHERE id = " + id);
            while(resultSet.next()) {
                group.setId(resultSet.getInt(1));
                group.setName(resultSet.getString(2));
                group.setTeacherId(resultSet.getInt("teacherId"));
            }
            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
        return group;
    }

    public void deleteGroup(int id) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM [Group] WHERE id = " + id);
            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public void addStudentToGroup(int studentId, int groupId) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("UPDATE Student SET groupId = " + groupId + " WHERE id = " + studentId);
            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public void deleteStudentFromGroup(int studentId) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("UPDATE Student SET groupId = NULL WHERE id = " + studentId);
            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public void addTeacherToGroup(int teacherId, int groupId) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("UPDATE [Group] SET teacherId = " + teacherId + " WHERE id = " + groupId);
            statement.execute("UPDATE Teacher SET groupId = " + groupId + " WHERE id = " + teacherId);
            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }

    public void deleteTeacherFromGroup(int teacherId) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("UPDATE [Group] SET teacherId = NULL WHERE teacherId = " + teacherId);
            statement.execute("UPDATE Teacher SET groupId = NULL WHERE id = " + teacherId);
            statement.close();
            connection.close();
        } catch (SQLException ignored) {
            // throwables.printStackTrace();
        }
    }
}
