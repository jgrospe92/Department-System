public class Student extends Person {
    
    private String course;
    private int semester;


    public Student(){

    }

    public Student(int newId, String newName, String newGender, String course, int semester){
        super(newId, newName, newGender);
        this.course = course;
        this.semester = semester;
    }


    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return this.semester;
    }
    // getters

    public String getCourse() {
        return this.course;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void getIdName(){
        System.out.println("Student Id: " + super.getId());
        System.out.println("Student name: " + super.getName() + "\n");
    }

    public String getName(){
        return super.getName();
    }

    public String showDetails(){
        return 
        "Student Id: " + super.getId() + "\n" +
        "Student name: " + super.getName() + "\n";
    }

    @Override public void display(){
        super.display();
        System.out.println("Course:  " + this.course +
                            "\nSemester: " + this.semester);
        System.out.println("---------------------------------");
    }

}
