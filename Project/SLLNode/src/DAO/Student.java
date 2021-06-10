package DAO;

public class Student {
    String ID;
    String Name;
    
    public Student() {
        ID = "";
        Name = "";
    }

    public Student(String ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return "Student{" + "ID=" + ID + ", Name=" + Name + '}';
    }

}