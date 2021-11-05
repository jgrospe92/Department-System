public class Teacher extends Person {

    private double salary;
    private String degree;

    public Teacher(){

    }

    public Teacher(int newId, String newName, String newGender, double salary, String degree ){ 
        super(newId, newName, newGender);
        this.salary = salary;
        this.degree = degree;
    }

    //setters
    public void setConstructor(int newId, String newName, String newGender, double salary, String degree){
        super.setId(newId);
        super.setName(newName);
        super.setGender(newGender);
        this.salary = salary;
        this.degree = degree;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }


    //getters
    public double getSalary() {
        return this.salary;
    }

    public String getDegree() {
        return this.degree;
    }

    @Override public void display(){
        super.display();
        System.out.println("Salary:  " + this.salary +
                            "\nDegree: " + this.degree);
        System.out.println("---------------------------------");
    }

    public void getIdName(){
        System.out.println("Teacher Id: " + super.getId());
        System.out.println("Teacher name: " + super.getName() + "\n");
    }

    public String getName() {
        return super.getName();
    }
    
}
