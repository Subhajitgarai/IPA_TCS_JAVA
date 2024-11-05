package IPA38;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeSet;

class HeadSets{
    private String headsetName;
    private String brand;
    private int price;
    private boolean available;

    public HeadSets(String headsetName, String brand, int price, boolean available) {
        this.headsetName = headsetName;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }

    public String getHeadsetName() {
        return headsetName;
    }

    public void setHeadsetName(String headsetName) {
        this.headsetName = headsetName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "HeadSets{" +
                "headsetName='" + headsetName + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}

public class Ipa38 {
    public  static Integer findTotalPriceForGivenBrand(HeadSets[] headSets, String brand) {
        Optional<Integer> reduce = Arrays.stream(headSets).filter(headset -> headset.getBrand().equalsIgnoreCase(brand))
                .map(HeadSets::getPrice).reduce(Integer::sum);
        return reduce.orElse(null);
    }
    public static HeadSets findAvailableHeadsetWithSecondMinPrice(HeadSets[] headSets){
        TreeSet<Integer> prices = new TreeSet<>();
        for (int i=0;i<headSets.length;i++){
            prices.add(headSets[i].getPrice());
        }
        Integer secondLowPrice=prices.toArray(Integer[]::new)[1];
        for (HeadSets headSet : headSets) {
            if (headSet.getPrice()==secondLowPrice){
                return headSet;
            }
        }
        return null;

    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HeadSets[] headSets=new HeadSets[4];
        for (int i=0;i<4;i++){
            String a= scanner.nextLine();
            String b= scanner.nextLine();
            Integer c=Integer.valueOf(scanner.nextLine());
            Boolean d=Boolean.valueOf(scanner.nextLine());
            headSets[i]=new HeadSets(a,b,c,d);
        }
        String brand=scanner.nextLine();
        Arrays.stream(headSets).forEach(System.out::println);
        Integer totalPriceForGivenBrand = findTotalPriceForGivenBrand(headSets, brand);
        if (totalPriceForGivenBrand!=null){
            System.out.println(totalPriceForGivenBrand);
        }
        else {
            System.out.println("No Headsets available with the given brand");
        }
        HeadSets availableHeadsetWithSecondMinPrice = findAvailableHeadsetWithSecondMinPrice(headSets);
        if (availableHeadsetWithSecondMinPrice!=null){
            System.out.println(availableHeadsetWithSecondMinPrice.getHeadsetName());
            System.out.println(availableHeadsetWithSecondMinPrice.getPrice());
        }
        else {
            System.out.println("No Headsets available");
        }
    }
}
