package IPA43;
import java.util.*;
class Student{
    private String name;
    private String rollNo;
    int age;
    private char gender;
    private String course;
    private int sem;
    private double Gpa;
    public Student(String name,String rollNo,int age,char gender,String course,int sem,double Gpa){
        this.name=name;
        this.rollNo=rollNo;
        this.age=age;
        this.gender=gender;
        this.course=course;
        this.sem=sem;
        this.Gpa=Gpa;
    }
    public double getGpa(){
        return this.Gpa;
    }
    public String getCourse(){
        return this.course;
    }
    public String getName(){
        return this.name;
    }
    public String getRollNo(){
        return this.rollNo;
    }
}
public class Ipa43{
    public static double calculateAverageGPA(Student[] students){
        if(students.length>0){
            double gpaTotal=0;
            for(int i=0;i<students.length;i++){
                gpaTotal+=students[i].getGpa();
            }
            return gpaTotal/students.length;
        }
        else
        {
            return 0;
        }

    }
    public static Student[] getStudentsByCourse(Student[] students,String course){
        Student[] studentArr=Arrays.stream(students)
                .filter(stu->stu.getCourse().equalsIgnoreCase(course))
                .toArray(Student[]::new);
        if(studentArr.length>0){
            return studentArr;
        }
        else{
            return null;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Student[] students=new Student[4];
        for(int i=0;i<4;i++){
            students[i]=new Student(sc.nextLine(),sc.nextLine(),Integer.parseInt(sc.nextLine()),sc.nextLine().charAt(0),sc.nextLine(),Integer.parseInt(sc.nextLine()),Double.parseDouble(sc.nextLine()));
        }
        String course=sc.nextLine();
        double avg=calculateAverageGPA(students);
        if(avg!=0){
            System.out.printf("%.1f\n",avg);
        }
        else{
            System.out.println("Sorry - No students are available");
        }
        Student[] stu=getStudentsByCourse(students,course);
        if(stu!=null){
            Arrays.stream(stu)
                    .forEach(student->{
                        System.out.println(student.getName());
                        System.out.println(student.getRollNo());
                        System.out.println(student.getGpa());
                    });
        }
        else{
            System.out.println("Sorry - No students are available for the given course");
        }
    }
}