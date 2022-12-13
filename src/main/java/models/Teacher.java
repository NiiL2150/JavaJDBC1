package models;

public class Teacher {
    private int id;
    private String fullName;
    private int groupId;

    public Teacher() {
    }

    public Teacher(String fullName) {
        this(fullName, 0);
    }

    public Teacher(String fullName, int groupId) {
        this.fullName = fullName;
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
