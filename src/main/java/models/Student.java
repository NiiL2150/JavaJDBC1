package models;

public class Student {
    private int id;
    private String fullName;
    private int age;
    private int groupId;

    public Student() {
    }

    public Student(String fullName, int age) {
        this(fullName, age, 0);
    }

    public Student(String fullName, int age, int groupId) {
        this.fullName = fullName;
        this.age = age;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", groupId=" + groupId +
                '}';
    }
}
