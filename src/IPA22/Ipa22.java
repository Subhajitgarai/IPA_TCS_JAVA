package IPA22;

import java.util.Arrays;
import java.util.Scanner;

class Associate{
    private int id;
    private String name;
    private String technology;
    private int experienceInYears;
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getTechnology(){
        return technology;
    }
    public int getExperienceInYears(){
        return experienceInYears;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String  name){
        this.name = name;
    }
    public void setTechnology(String  technology){
        this.name = name;
    }
    public void setExperienceInYears(int experienceInYears){
        this.experienceInYears = experienceInYears;
    }

    public Associate(int id, String name, String technology, int experienceInYears) {
        this.id = id;
        this.name = name;
        this.technology = technology;
        this.experienceInYears = experienceInYears;
    }

    @Override
    public String toString() {
        return "Associate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", technology='" + technology + '\'' +
                ", experienceInYears=" + experienceInYears +
                '}';
    }
}

public class Ipa22 {
    public static Associate[] associatesForGivenTechnology(Associate[] associates,String searchTechnology){
        Associate[] array = Arrays.stream(associates).filter(associate -> associate.getTechnology().equalsIgnoreCase(searchTechnology))
                .filter(associate -> associate.getExperienceInYears() % 5 == 0)
                .toArray(Associate[]::new);
        if (array.length!=0){
            return array;
        }
        return null;
    }

    public static void main(String[] args) {
        Associate[] associates=new Associate[5];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<5;i++){
            int a=sc.nextInt();
            String b=sc.next();
            String c=sc.next();
            int d=sc.nextInt();
            Associate associate=new Associate(a,b,c,d);
            associates[i]=associate;
        }
        String tech=sc.next();
        Arrays.stream(associates).forEach(associate -> {
            System.out.println(associate.toString());
        });
        Associate[] associates1 = associatesForGivenTechnology(associates, tech);
        if (associates1.length>0){
            Arrays.stream(associates1).forEach(associate -> {
                System.out.println(associate.getId());
            });
        }
        else {
            System.out.println("No Associate Found");
        }

    }
}
