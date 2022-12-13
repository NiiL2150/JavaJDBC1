package models;

import java.util.List;

public class GroupModel {
    private int id;
    private String name;
    private int teacherId;
    private List<Integer> studentIds;

    public GroupModel() {
    }

    public GroupModel(String name) {
        this(name, 0);
    }

    public GroupModel(String name, int teacherId) {
        this(name, teacherId, null);
    }

    public GroupModel(String name, int teacherId, List<Integer> studentIds) {
        this.name = name;
        this.teacherId = teacherId;
        this.studentIds = studentIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public List<Integer> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherId=" + teacherId +
                ", studentIds=" + studentIds +
                '}';
    }
}
