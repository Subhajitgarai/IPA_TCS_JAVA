package IPA19;

import java.util.Arrays;
import java.util.Scanner;

class Flowers {
    private int flowerId;
    private String flowerName;
    private int rating;
    private String type;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Flowers(int flowerId, String flowerName, int price, int rating, String type) {
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.rating = rating;
        this.type = type;
        this.price = price;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Flowers() {
    }

    @Override
    public String toString() {
        return "Flowers{" +
                "flowerId=" + flowerId +
                ", flowerName='" + flowerName + '\'' +
                ", rating=" + rating +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}

public class Ipa19 {
    public static Flowers findMinPriceByType(Flowers[] flowers, String type) {
        System.out.println(type);
        Flowers flower = new Flowers();
        int[] priceArr = new int[flowers.length];
        Arrays.fill(priceArr,9999);
        for (int i = 0; i < flowers.length; i++) {
            if (flowers[i].getType().equalsIgnoreCase(type) && flowers[i].getRating() > 3) {
                priceArr[i] = flowers[i].getPrice();
            }
        }
        Arrays.sort(priceArr);
        System.out.println(priceArr[0]);
        if (priceArr.length > 0) {
            for (int i = 0; i < flowers.length; i++) {
                if (priceArr[0] == flowers[i].getPrice()) {
                    flower = flowers[i];
                    return flower;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Flowers[] flowerArr = new Flowers[4];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("Enter flower details (ID, Name, Price, Rating, Type):");

            // Use nextLine for all inputs and parse numbers manually
            int a = Integer.parseInt(scanner.nextLine()); // Parse ID from String
            String b = scanner.nextLine(); // Name (this can contain spaces)
            int c = Integer.parseInt(scanner.nextLine()); // Parse Price from String
            int d = Integer.parseInt(scanner.nextLine()); // Parse Rating from String
            String e = scanner.nextLine(); // Type

            Flowers flowers = new Flowers(a, b, c, d, e);
            flowerArr[i] = flowers;
        }
        String type=scanner.next();

        // Print all flower details
        Arrays.stream(flowerArr).forEach(flowers -> {
            System.out.println(flowers.toString());
        });
        Flowers minPriceByType = findMinPriceByType(flowerArr, type);
        if (minPriceByType!=null){
            System.out.println(minPriceByType.getFlowerId());
        }
        else {
            System.out.println("No Flower Found");
        }
    }
}
