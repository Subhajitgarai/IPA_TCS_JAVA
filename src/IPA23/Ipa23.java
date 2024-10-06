package IPA23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Institution{
    private int institutionId;
    private String institutionName;
    private int noOfStudentsPlaced;
    private int noOfStudentsCleared;
    private String location;
    private String grade;

    public Institution(int institutionId, String institutionName, int noOfStudentsPlaced, int noOfStudentsCleared, String location, String grade) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaced = noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
        this.grade = grade;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public int getNoOfStudentsPlaced() {
        return noOfStudentsPlaced;
    }

    public void setNoOfStudentsPlaced(int noOfStudentsPlaced) {
        this.noOfStudentsPlaced = noOfStudentsPlaced;
    }

    public int getNoOfStudentsCleared() {
        return noOfStudentsCleared;
    }

    public void setNoOfStudentsCleared(int noOfStudentsCleared) {
        this.noOfStudentsCleared = noOfStudentsCleared;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "institutionId=" + institutionId +
                ", institutionName='" + institutionName + '\'' +
                ", noOfStudentsPlaced=" + noOfStudentsPlaced +
                ", noOfStudentsCleared=" + noOfStudentsCleared +
                ", location='" + location + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}

public class Ipa23 {
    public static int findNumClearancedByLoc(Institution[] institutions, String location){
        int sum=0;
        for (int i=0;i<institutions.length;i++){
            if (institutions[i].getLocation().equalsIgnoreCase(location)){
                sum+=institutions[i].getNoOfStudentsCleared();
            }
        }
        return sum;
    }
    public static Institution updateInstitutionGrade(Institution[] institutions, String institutionName){
        for (int i=0;i<institutions.length;i++){
            if (institutions[i].getInstitutionName().equalsIgnoreCase(institutionName)){
               Institution ins= institutions[i];
                int rating=(ins.getNoOfStudentsPlaced()*100)/ ins.getNoOfStudentsCleared();
                if (rating>=80){
                    ins.setGrade("A");
                }
                else {
                    ins.setGrade("B");
                }
                return ins;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        Institution[] institutions=new Institution[4];
        for (int i=0;i<4;i++){
            int a= sc.nextInt();
            String b=sc.next();
            int c=sc.nextInt();
            int d=sc.nextInt();
            String e=sc.next();
            Institution institution=new Institution(a,b,c,d,e,null);
            institutions[i]=institution;
        }
        String f=sc.next();
        String g=sc.next();
        Arrays.stream(institutions).forEach(institution -> {
            System.out.println(institution.toString());
        });
        int numClearancedByLoc = findNumClearancedByLoc(institutions, f);
        System.out.println(numClearancedByLoc);
        Institution institution = updateInstitutionGrade(institutions, g);
        System.out.println(institution.getInstitutionName()+"::"+institution.getGrade());

    }
}
