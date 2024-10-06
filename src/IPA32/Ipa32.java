package IPA32;

import java.util.*;

class TravelAgencies{
    private int regNo;
    private String agencyName;
    private String packageType;
    private int price;
    private boolean flightFacility;
    public TravelAgencies(int regNo, String agencyName,String packageType,int price,boolean flightFacility){
        this.regNo=regNo;
        this.agencyName=agencyName;
        this.packageType=packageType;
        this.price=price;
        this.flightFacility=flightFacility;
    }
    public void setRegNo(int regNo){
        this.regNo=regNo;;
    }
    public void setAgencyName(String agencyName){
        this.agencyName=agencyName;
    }
    public void setPackageType(String packageType){
        this.packageType=packageType;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void setFlightFacility(boolean flightFacility){
        this.flightFacility=flightFacility;
    }
    public int getRegNo(){
        return this.regNo;
    }
    public String getAgencyName(){
        return this.agencyName;
    }
    public String getPackageType(){
        return this.packageType;
    }
    public int getPrice(){
        return this.price;
    }
    public boolean getFlightFacility(){
        return this.flightFacility;
    }

    @Override
    public String toString() {
        return "TravelAgencies{" +
                "regNo=" + regNo +
                ", agencyName='" + agencyName + '\'' +
                ", packageType='" + packageType + '\'' +
                ", price=" + price +
                ", flightFacility=" + flightFacility +
                '}';
    }
}

public class Ipa32 {
    public static Integer findAgencyWithHighestPackagePrice(TravelAgencies[] TravelAgencies){
        Optional<Integer> max=Arrays.stream(TravelAgencies).map(travelAgencies -> travelAgencies.getPrice())
                .reduce(Integer::max);
        return max.orElse(null);
    }
    public static TravelAgencies agencyDetailsForGivenldAndType(TravelAgencies[] TravelAgencies,int regNo,String packageType){
        TravelAgencies[] travelAgency=Arrays.stream(TravelAgencies).filter(travel-> travel.getFlightFacility() && travel.getRegNo() == regNo && travel.getPackageType().equalsIgnoreCase(packageType))
                .toArray(TravelAgencies[]::new);
        return travelAgency[0];
    }


    public static void main(String args[]){
        TravelAgencies[] travelAgencies=new TravelAgencies[4];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<4;i++){
            int a=Integer.valueOf(sc.nextLine());
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=Integer.valueOf(sc.nextLine());
            boolean e=Boolean.valueOf(sc.nextLine());
            TravelAgencies travel=new TravelAgencies(a,b,c,d,e);
            travelAgencies[i]=travel;
        }
        int regNo=Integer.valueOf(sc.nextLine());
        String packageType=sc.nextLine();
        Arrays.stream(travelAgencies).forEach(System.out::println);
        Integer agencyWithHighestPackagePrice = findAgencyWithHighestPackagePrice(travelAgencies);
        if (agencyWithHighestPackagePrice!=null){
            System.out.println(agencyWithHighestPackagePrice);
        }
        TravelAgencies travelAgencies1 = agencyDetailsForGivenldAndType(travelAgencies, regNo, packageType);
        System.out.println(travelAgencies1.getAgencyName()+":"+travelAgencies1.getPrice());
    }

}