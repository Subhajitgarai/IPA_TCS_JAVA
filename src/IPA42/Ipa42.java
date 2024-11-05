package IPA42;

import java.util.*;
class Person{
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    public Person(String firstName,String lastName,int age,char gender){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.gender=gender;
    }

}
class Student{
    private String rollNo;
    private String course;
    private int sem;
    private double Gpa;
    public Student(String rollNo,String course,int sem,double Gpa){
        this.rollNo=rollNo;
        this.course=course;
        this.sem=sem;
        this.Gpa=Gpa;
    }
    public double getGpa(){
        return this.Gpa;
    }
    public String getRollNo(){
        return this.rollNo;
    }
    public String getCourse(){
        return this.course;
    }
}
class Faculty{
    private String employeeId;
    private String department;
    private String designation;
    private double salary;
    public Faculty(String employeeId,String department,String designation,double salary){
        this.employeeId=employeeId;
        this.department=department;
        this.designation=designation;
        this.salary=salary;
    }
    public double getSalary(){
        return this.salary;
    }
    public String getEmployeeId(){
        return this.employeeId;
    }
    public String getDepartment(){
        return this.department;
    }
}

class Ipa42 {
    public static Student findHighestGPAStudent(Student[] students) {
        return Arrays.stream(students)
                .max(Comparator.comparing(Student::getGpa))
                .orElse(null);
    }

    public static Faculty findHighestPaidFaculty(Faculty[] faculties) {
        return Arrays.stream(faculties)
                .max(Comparator.comparing(Faculty::getSalary))
                .orElse(null);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Faculty[] faculties = new Faculty[2];
        Student[] students = new Student[2];
        Person[] persons = new Person[2];

        for (int i = 0; i < 2; i++) {
            // Read Person details
            String firstName = sc.nextLine();
            String lastName = sc.nextLine();
            int age = Integer.parseInt(sc.nextLine());
            char gender = sc.nextLine().charAt(0); // Reads the gender character

            persons[i] = new Person(firstName, lastName, age, gender);

            // Read Student details
            String rollNo = sc.nextLine();
            String course = sc.nextLine();
            int sem = Integer.parseInt(sc.nextLine());
            double gpa = Double.parseDouble(sc.nextLine()); // GPA as a double

            students[i] = new Student(rollNo, course, sem, gpa);
        }

        for (int i = 0; i < 2; i++) {
            // Read Faculty details
            String employeeId = sc.nextLine();
            String department = sc.nextLine();
            String designation = sc.nextLine();
            double salary = Double.parseDouble(sc.nextLine()); // Salary as a double

            faculties[i] = new Faculty(employeeId, department, designation, salary);
        }

        // Finding and printing the highest GPA student
        Student stu = findHighestGPAStudent(students);
        if (stu != null) {
            System.out.println(stu.getRollNo());
            System.out.println(stu.getCourse());
            System.out.println(stu.getGpa());
        } else {
            System.out.println("Sorry - No Student is available");
        }

        // Finding and printing the highest paid faculty
        Faculty fac = findHighestPaidFaculty(faculties);
        if (fac != null) {
            System.out.println(fac.getEmployeeId());
            System.out.println(fac.getDepartment());
            System.out.println(fac.getSalary());
        } else {
            System.out.println("Sorry - No Faculty is available");
        }

        sc.close();
    }
}

