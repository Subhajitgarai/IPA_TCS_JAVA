package IPA39;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

class Vegetable{
    private int vegetableId;
    private String vegetableName;
    private int price;
    private int rating;

    public Vegetable(int vegetableId, String vegetableName, int price, int rating) {
        this.vegetableId = vegetableId;
        this.vegetableName = vegetableName;
        this.price = price;
        this.rating = rating;
    }

    public int getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(int vegetableId) {
        this.vegetableId = vegetableId;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "vegetableId=" + vegetableId +
                ", vegetableName='" + vegetableName + '\'' +
                ", price=" + price +
                ", rating='" + rating + '\'' +
                '}';
    }
}
public class Ipa39 {
    public  static Vegetable findMinimumPriceByRating(Vegetable[] vegetables, int rating) {
        Optional<Integer> array = Arrays.stream(vegetables).filter(vegetable -> vegetable.getRating() > rating)
                .map(Vegetable::getPrice)
                .reduce(Integer::min);
        if (array.isPresent()) {
            for (int i=0;i<vegetables.length;i++){
                if (vegetables[i].getPrice()==array.get()){
                    return vegetables[i];
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Vegetable[] vegetables=new Vegetable[4];
        for(int i=0;i<4;i++){
            int a=sc.nextInt();
            String b=sc.next();
            int c=sc.nextInt();
            int d=sc.nextInt();
            Vegetable vegetable=new Vegetable(a,b,c,d);
            vegetables[i]=vegetable;

        }
        int rating=sc.nextInt();
        Arrays.stream(vegetables).forEach(System.out::println);
        Vegetable minimumPriceByRating = findMinimumPriceByRating(vegetables, rating);
        if (minimumPriceByRating!=null){
            System.out.println(minimumPriceByRating.getVegetableId());
        }
        else {
            System.out.println("No such Vegetables");
        }


    }
}
