package IPA33;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

class Newspaper{
    private int regNo;
    private String name;
    private int publicationYear;
    private int price;

    public Newspaper(int regNo, String name, int publicationYear, int price) {
        this.regNo = regNo;
        this.name = name;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "regNo=" + regNo +
                ", name='" + name + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                '}';
    }
}

public class Ipa33 {
    public static int findTotalPriceByPublicationYear(Newspaper[] newspapers, int publicationYear){
        Optional<Integer> sum = Arrays.stream(newspapers).filter(newspaper -> newspaper.getPublicationYear() == publicationYear)
                .map(Newspaper::getPrice).reduce(Integer::sum);
        if (sum.isPresent()){
            return sum.get();
        }
        else {
            return 0;
        }

    }
    public static Newspaper searchNewspaperByName(Newspaper[] newspapers, String name){
        Newspaper[] array = Arrays.stream(newspapers).filter(newspaper -> newspaper.getName().equalsIgnoreCase(name))
                .toArray(Newspaper[]::new);
        if (array.length>0){
            return array[0];
        }
        else {
            return null;
        }

    }
    public static void main(String[] args) {
        Newspaper[] newspapers=new Newspaper[4];
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<4;i++){
            int a=Integer.valueOf(sc.nextLine());
            String b=sc.nextLine();
            int c=Integer.valueOf(sc.nextLine());
            int d=Integer.valueOf(sc.nextLine());
            Newspaper newspaper=new Newspaper(a,b,c,d);
            newspapers[i]=newspaper;
        }
        int publicationYear=Integer.valueOf(sc.nextLine());
        String name=sc.nextLine();
        Arrays.stream(newspapers).forEach(System.out::println);
        int totalPriceByPublicationYear = findTotalPriceByPublicationYear(newspapers, publicationYear);
        if (totalPriceByPublicationYear>0){
            System.out.println(totalPriceByPublicationYear);
        }
        else {
            System.out.println("No Newspaper found with the mentioned attribute");
        }
        Newspaper newspaper = searchNewspaperByName(newspapers, name);
        if (newspaper !=null){
            System.out.println("regNo-"+newspaper.getRegNo());
            System.out.println("name-"+newspaper.getName());
            System.out.println("publicationYear-"+newspaper.getPublicationYear());
            System.out.println("price-"+newspaper.getPrice());
        }
        else {
            System.out.println("No Newspaper found with the given name");
        }
    }
}
