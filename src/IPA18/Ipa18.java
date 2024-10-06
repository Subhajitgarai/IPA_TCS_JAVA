package IPA18;

import java.util.Arrays;
import java.util.Scanner;

class Antenna{
    private int antennaId;
    private String antennaName;
    private String projectLead;
    private double antennaVSWR;

    public String getAntennaName() {
        return antennaName;
    }

    public void setAntennaName(String antennaName) {
        this.antennaName = antennaName;
    }

    public int getAntennaId() {
        return antennaId;
    }

    public void setAntennaId(int antennaId) {
        this.antennaId = antennaId;
    }

    public String getProjectLead() {
        return projectLead;
    }

    public void setProjectLead(String projectLead) {
        this.projectLead = projectLead;
    }
    public double getAntennaVSWR() {
        return antennaVSWR;
    }

    public void setAntennaVSWR(double antennaVSWR) {
        this.antennaVSWR = antennaVSWR;
    }
    public Antenna(int antennaId,String antennaName,String projectLead,double antennaVSWR){
        this.antennaId=antennaId;
        this.antennaName=antennaName;
        this.projectLead=projectLead;
        this.antennaVSWR=antennaVSWR;

    }
    public Antenna(){

    }

    @Override
    public String toString() {
        return "Antenna{" +
                "antennaId=" + antennaId +
                ", antennaName='" + antennaName + '\'' +
                ", projectLead='" + projectLead + '\'' +
                ", antennaVSWR=" + antennaVSWR +
                '}';
    }
}

public class Ipa18 {
    public static int searchAntennaByName(Antenna[] antennas,String antennaName){
        System.out.println("Hello");
        System.out.println(antennaName);
        for (Antenna antenna : antennas) {
            if (antenna.getAntennaName().equalsIgnoreCase(antennaName)) {
                return antenna.getAntennaId();
            }
        }
        return 0;
    }
    public  static Antenna[] sortAntennaByVSWR(Antenna[] antennas, double sortValue){
        System.out.println("SortValue="+sortValue);
        Antenna[] array = Arrays.stream(antennas).filter(antenna -> antenna.getAntennaVSWR() < sortValue).toArray(Antenna[]::new);
        double[] values=new double[array.length];
        for (int i=0;i<array.length;i++){
            values[i]=array[i].getAntennaVSWR();
        }
        if (array.length>0){
            return array;
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Antenna antennas[]=new Antenna[4];
        for (int i=0;i<4;i++){
            int a=sc.nextInt();
            String b=sc.next();
            String c=sc.next();
            double d=  sc.nextDouble();
            Antenna antenna=new Antenna(a,b,c,d);
            antennas[i]=antenna;
        }
        String antennaName=sc.next();
        double sortValue=sc.nextDouble();
        Arrays.stream(antennas).forEach(antenna -> {
            String string = antenna.toString();
            System.out.println(string);
        });
        int antennaId = searchAntennaByName(antennas, antennaName);
        if (antennaId!=0){
            System.out.println(antennaId);
        }
        else {
            System.out.println("There is no antenna with the given parameter");
        }
        Antenna[] sortedAntenna = sortAntennaByVSWR(antennas, sortValue);
        if (sortedAntenna==null){
            System.out.println("No Antenna found");
        }
        else {
            for (Antenna antenna : sortedAntenna) {
                System.out.println(antenna.getProjectLead());
            }
        }

    }

}
