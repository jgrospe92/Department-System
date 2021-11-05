public abstract class Person {
    private int id;
    private String name;
    private String gender;


    public Person() {
        this.id = 0;
        this.name = null;
        this.gender = null;
    }

    public Person(int newId, String newName, String newGender){
        this.id = newId;
        this.name = newName;
        this.gender = newGender;
    }

    // getters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void display(){
        System.out.println("ID: " + this.id + "\nName: " + this.name +
                            "\nGender: " + this.gender);
    }

    // getters

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }
}
