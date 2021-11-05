import java.util.ArrayList;

public class Department {

    private int id;
    private String description;
    private Teacher dean = null;

    // List
    public ArrayList<Teacher> teacherList = new ArrayList<>(); // Teacher list
    public ArrayList<Student> studentList = new ArrayList<>(); // student list

    public Department() {

    }

    public Department(int id, String d) {
        this.id = id;
        this.description = d;
    }

    public Department(int id, String d, Teacher newDean) {
        this.id = id;
        this.description = d;
        this.dean = newDean;
    }
    // Method setters
    public void setDean(Teacher emp) {
        this.dean = emp;
       }
       
    public void setDeptId(int d){
        this.id = d;
    }

    public void setDesc(String dd) {
        this.description = dd;
    }
    public Teacher getDean(){
        return this.dean;
    }

    public String getDescription(){
        return this.description;
    }

    public int getId(){
        return this.id;
    }
    
    // display method
    public void showInfo(){
        System.out.println("Department ID: " + this.id +
                            "\nDescription: " + this.description + "\n");
    }

}
