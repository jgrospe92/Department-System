import java.util.Scanner;

import java.util.ArrayList;

public class Main {
    // List for entered ID NUMBERS
    static ArrayList<Integer> pkDept = new ArrayList<>();
    static ArrayList<Integer> pkTeacher = new ArrayList<>();
    static ArrayList<Integer> pkStudent = new ArrayList<>();
    // Active flag to run the program
    static boolean activeFlag = true;

    public static void main(String[] args) {

        // department list
        ArrayList<Department> deptList = new ArrayList<Department>();
        ArrayList<Department> tempDeptList = new ArrayList<Department>(); // Copy of the original department list.

        // Default list
        ArrayList<Student> tempStudentList = new ArrayList<Student>(); // Initial Student List
        ArrayList<Teacher> tempTeachList = new ArrayList<Teacher>(); // Initial Teacher List

        // Copy of the original list
        ArrayList<Student> copySList = new ArrayList<Student>();
        ArrayList<Teacher> copyTList = new ArrayList<Teacher>();

        // Instances
        Department dd = new Department(); // initial department
        Teacher newTeacher = new Teacher(); // new Teacher
        Student newStudent = new Student(); // new Student
        String name; 
        // Runs the program
        do {
            pickANum(InputMenu(), dd, deptList, newTeacher, newStudent, tempTeachList, tempStudentList, tempDeptList,
                    copySList, copyTList);
        } while (activeFlag);

    }

    static String InputMenu() {
        
        Scanner input = new Scanner(System.in);
        String options;
        System.out.println(" ");
        System.out.println("Welcome to Vanier college");
        System.out.println("please select an option: ");
        System.out.println(" ");

        System.out.println("1. Add a department");
        System.out.println("2. Add a Teacher");
        System.out.println("3. Add a Student");
        System.out.println("4. Assign a Dean to a department");
        System.out.println("5. Assign a Teacher to a department");
        System.out.println("6. Assign a Student to a department");
        System.out.println("7. Display Departments");
        System.out.println("8. Display Teachers");
        System.out.println("9. Display Students");
        System.out.println("10. Display Dean");
        System.out.println("11. Search engine");
        System.out.println("press q to exit...");
        return options = input.nextLine();

    }
    // Passing all the elements as arguments for this method
    static void pickANum(String x, Department d, ArrayList<Department> dList, Teacher t, Student s,
            ArrayList<Teacher> tempTList, ArrayList<Student> tempSList, ArrayList<Department> tempD,
            ArrayList<Student> sCopy, ArrayList<Teacher> tCopy) {

        Scanner input = new Scanner(System.in);

        switch (x) {
        case "1":
            int deptId;
            String deptName;
            System.out.println("Enter department ID: ");
            deptId = input.nextInt();

            // pkDepth is a list of entered Department ID Numbers 
            if (pkDept.contains(deptId)) {
                System.out.println("Error, Duplicate ID");

            } else {
                System.out.println("Enter department name: ");
                deptName = input.next();
                dList.add(new Department(deptId, deptName));
                tempD.add(new Department(deptId, deptName));
                pkDept.add(deptId);

                System.out.println("Successfully created!");
            }
            break;
        case "2":
            int teacherID;
            String teacherName;
            String newGender;
            double salary;
            String degree;
            System.out.println("Enter ID: ");
            teacherID = input.nextInt();
            if (pkTeacher.contains(teacherID)) {
                System.out.println("Error, Duplicate ID");
            } else {
                System.out.println("Enter name: ");
                teacherName = input.next();
                System.out.println("Enter Gender: ");
                newGender = input.next();
                System.out.println("Enter Salary: ");
                salary = input.nextDouble();
                System.out.println("Enter Degree: ");
                degree = input.next();

                System.out.println("Successfully created!");

                pkTeacher.add(teacherID);
                tempTList.add(new Teacher(teacherID, teacherName, newGender, salary, degree));
                tCopy.add(new Teacher(teacherID, teacherName, newGender, salary, degree));
            }
            break;
        case "3":
            int studentId;
            String studentName;
            String studentGender;
            String studentCourse;
            int studentSemester;
            System.out.println("Enter ID: ");
            studentId = input.nextInt();

            if (pkStudent.contains(studentId)) {
                System.out.println("Error, Duplicate ID");
            } else {
                System.out.println("Enter Name: ");
                studentName = input.next();
                System.out.println("Enter Gender: ");
                studentGender = input.next();
                System.out.println("Enter Course: ");
                studentCourse = input.next();
                System.out.println("Enter Semester: ");
                studentSemester = input.nextInt();

                System.out.println("Successfully created!");

                tempSList.add(new Student(studentId, studentName, studentGender, studentCourse, studentSemester));
                sCopy.add(new Student(studentId, studentName, studentGender, studentCourse, studentSemester));
                pkStudent.add(studentId);
            }
            break;
        case "4":
            boolean isTeacher = false;
            boolean isDepartment = false;

            if (tempTList.isEmpty()) {

                System.out.println("No available teachers.\n");

            } else {
                System.out.println("Listing all unassigned Teachers...\n");
                for (Teacher tt : tempTList) {
                    tt.getIdName();
                }
                System.out.println(" ");
                if (dList.isEmpty()) {
                    System.out.println("No available departments\n");
                } else {
                    System.out.println("Listing all available Departments...\n");
                    // Variables used to assign new dean
                    int departmentId, teacherId = 0, indexOfDept = 0;
                    for (Department dd : dList) {
                        if (dd.getDean() == null) {
                            dd.showInfo();
                        }
                    }
                    System.out.println("------------------------------------");
                    System.out.println("Enter the department ID you want to assign a Dean: ");
                    departmentId = input.nextInt();
                    for (Department dd : dList) {
                        if (dd.getId() == departmentId) {
                            isDepartment = true;
                            indexOfDept = dList.indexOf(dd);
                            System.out.println("Enter the Teacher ID to be assigned: ");
                            teacherId = input.nextInt();

                            for (Teacher tt : tempTList) {

                                if (tt.getId() == teacherId) {

                                    isTeacher = true;
                                    int indexOfTeacher = tempTList.indexOf(tt);
                                    dList.get(indexOfDept).setDean(tempTList.get(indexOfTeacher));
                                    tempTList.remove(indexOfTeacher);

                                    System.out.println(
                                            dList.get(indexOfDept).getDean().getName() + " is assigned as Dean to "
                                                    + dList.get(indexOfDept).getDescription() + " department.");
                                    break;

                                } else {

                                    continue;
                                }
                            }

                            if (!isTeacher) {
                                System.out.println("Invalid Teacher ID!");
                            }

                        } else {

                            continue;

                        }

                    }
                    if (!isDepartment) {
                        System.out.println("Invalid Department ID:");
                    }
                }
            }
            break;

        case "5":
            isTeacher = false;
            isDepartment = false;
            boolean doesExist = false;

            if (tempTList.isEmpty()) {

                System.out.println("No teachers have been added.\n");

            } else {

                System.out.println("Listing all available Teachers...\n");

                for (Teacher tt : tempTList) {

                    tt.getIdName();

                }

                if (dList.isEmpty()) {

                    System.out.println("No departments have been added\n");
                    break;

                } else {

                    System.out.println("Listing all departments...\n");

                    // Variables used to assign new dean
                    int departmentId, teacherId = 0;

                    for (Department dd : dList) {

                        dd.showInfo();
                    }
                    System.out.println("Enter the Teacher ID you would like to add: ");

                    teacherId = input.nextInt();

                    for (Teacher tt : tempTList) {
                        if (teacherId == tt.getId()) {
                            isTeacher = true;
                            int teacherIndex = tempTList.indexOf(tt);

                            System.out.println("Enter the Department ID: ");
                            departmentId = input.nextInt();
                            for (Department dd : dList) {

                                if (dd.teacherList.isEmpty()) {
                                    // does nothing
                                } else {
                                    for (Teacher newT : dd.teacherList) {
                                        if (tempTList.get(teacherIndex).getId() == newT.getId()
                                                && departmentId == dd.getId()) {
                                            doesExist = true;
                                            break;
                                        }
                                    }
                                }
                                if (departmentId == dd.getId()) {

                                    int deptIndex = dList.indexOf(dd);
                                    isDepartment = true;

                                    if (doesExist == false) {
                                        dList.get(deptIndex).teacherList.add(tempTList.get(teacherIndex));
                                        System.out.println(
                                                tempTList.get(teacherIndex).getName() + " is successfully assigned to "
                                                        + dList.get(deptIndex).getDescription() + " department");
                                    } else {
                                        System.out.println("You already added this teacher to this department");
                                    }

                                } else {
                                    
                                    continue;
                                }
                            }
                            if (!isDepartment) {
                                System.out.println("Invalid Department ID:");
                            }

                        } else {

                            continue;
                        }
                    }
                    if (!isTeacher) {
                        System.out.println("Invalid Teacher ID;");
                    }
                }
            }
            break;
        case "6":
            isDepartment = false;
            boolean isStudent = false;
            boolean doesStuExist = false;
            if (tempSList.isEmpty()) {

                System.out.println("No students have been added\n");

            } else {
                System.out.println("Listing all unassigned students\n");
                for (Student ss : tempSList) {

                    ss.getIdName();
                }

                if (dList.isEmpty()) {

                    System.out.println("No departments have been added\n");
                    break;

                } else {

                    System.out.println("Listing all departments...\n");

                    // Variables used to assign new dean
                    int departmentId, studentID;

                    for (Department dd : dList) {

                        dd.showInfo();
                    }
                    System.out.println("Enter Student ID you would like to add: ");
                    studentID = input.nextInt();
                    for (Student ss : tempSList) {

                        if (studentID == ss.getId()) {

                            isStudent = true;
                            int studentIndex = tempSList.indexOf(ss);

                            System.out.println("Enter department ID: ");
                            departmentId = input.nextInt();
                            for (Department dd : dList) {

                                if (dd.studentList.isEmpty()) {
                                    // does nothing
                                } else {
                                    for (Student newS : dd.studentList) {
                                        if (tempSList.get(studentIndex).getId() == newS.getId()
                                                && departmentId == dd.getId()) {
                                            doesStuExist = true;
                                            break;
                                        }
                                    }
                                }
                                if (departmentId == dd.getId()) {
                                    isDepartment = true;
                                    int deptIndex = dList.indexOf(dd);

                                    if (doesStuExist == false) {
                                        dList.get(deptIndex).studentList.add(tempSList.get(studentIndex));
                                        System.out.println(
                                                tempSList.get(studentIndex).getName() + " is successfully added to the "
                                                        + dList.get(deptIndex).getDescription() + " department");
                                    } else {
                                        System.out.println("You already added this teacher to this department");
                                    }
                                } else {
                                    continue;
                                }
                            }
                            if (!isDepartment) {
                                System.out.println("Invalid department ID");
                            }
                        } else {
            
                            continue;
                        }
                    }
                    if (!isStudent) {
                        System.out.println("Invalid student ID.");
                    }

                }
            }
            break;
        case "7":

            if (dList.isEmpty()) {

                System.out.println("No departments have been added\n");
                break;

            } else {

                System.out.println("Listing all departments...\n");

                for (Department dd : dList) {

                    dd.showInfo();

                }
            }
            break;
        case "8":
            if (tCopy.isEmpty()) {
                System.out.println("No Teachers have been added\n");
            } else {
                System.out.println("Listing all Teachers... \n");
                for (Teacher tt : tCopy) {
                    tt.display();
                }
            }
            break;

        case "9":
            if (tempSList.isEmpty()) {

                System.out.println("No students have been added\n");

            } else {
                System.out.println("Listing all students\n");
                for (Student ss : tempSList) {

                    ss.display();
                }
            }
            break;
        case "10":
            if (dList.isEmpty()) {

                System.out.println("You have not created any departments nor assigned any Deans...\n");
                break;

            } else {

                System.out.println("Listing all Deans...\n");

                for (Department dd : dList) {

                    if (dd.getDean() == null) {
                        System.out.println(dd.getDescription() + " has no Dean...\n");
                    } else {
                        System.out.println(dd.getDescription() + " assigned Dean:");
                        dd.getDean().display();
                    }

                }
            }
            break;
        case "11":
            int inputId;
            boolean notFound = true;

            System.out.println("Enter any department ID number and I will return its information: ");
            inputId = input.nextInt();

            for (Department dd : dList) {

                if (inputId == dd.getId()) {
                    System.out.println("Department Information found.");
                    dd.showInfo();
                    notFound = false;
                    System.out.println("------------------------------");

                    if (dd.getDean() == null) {
                        System.out.println("No dean assign on this department");
                    } else {
                        System.out.println("Dean assign on this department");
                        dd.getDean().display();
                    }
                    System.out.println("------------------------------");
                    if (dd.teacherList.isEmpty()) {
                        System.out.println("No Teachers assign on this department");
                    } else {
                        System.out.println("Teachers on this department: ");
                        for (Teacher teach : dd.teacherList) {
                            teach.display();
                        }
                    }
                    System.out.println("------------------------------");
                    if (dd.studentList.isEmpty()) {
                        System.out.println("No Student assign on this department");
                    } else {
                        System.out.println("Students on this department: ");
                        for (Student ss : dd.studentList) {
                            ss.display();
                        }
                    }

                }

            }

            if (notFound) {
                System.out.println("------------------------------");
                System.out.println(inputId + " ID Number does not exist in our database");
            }

            break;
        case "q":
            System.out.println("Have a great day!");
            activeFlag = false;
            break;
        }
    }
}