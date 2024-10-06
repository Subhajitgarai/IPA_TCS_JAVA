package IPA36;

import java.util.*;

class MobileDetails{
    private int mobileId;
    private int price;
    private String brand;
    private boolean isFlagship;

    public MobileDetails(int mobileId, int price, String brand, boolean isFlagship) {
        this.mobileId = mobileId;
        this.price = price;
        this.brand = brand;
        this.isFlagship = isFlagship;
    }

    public int getMobileId() {
        return mobileId;
    }

    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isFlagship() {
        return isFlagship;
    }

    public void setFlagship(boolean flagship) {
        isFlagship = flagship;
    }

    @Override
    public String toString() {
        return "MobileDetails{" +
                "mobileId=" + mobileId +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", isFlagship=" + isFlagship +
                '}';
    }
}

public class Ipa36 {
    public static Integer getTotalPrice(MobileDetails[] mobileDetails, String brand){
        Optional<Integer> totalPrice = Arrays.stream(mobileDetails).filter(mobileDetail -> mobileDetail.getBrand().equals(brand))
                .map(MobileDetails::getPrice).reduce(Integer::sum);
        return totalPrice.orElse(null);
    }
    public static MobileDetails[] getSecondMin(MobileDetails[] mobileDetails){
        MobileDetails[] sortedArr = Arrays.stream(mobileDetails).sorted(Comparator.comparing(MobileDetails::getPrice))
                .toArray(MobileDetails[]::new);
        TreeSet<Integer>treeSet=new TreeSet<>();
        for (int i=0;i<sortedArr.length;i++){
            treeSet.add(sortedArr[i].getPrice());
        }
        System.out.println(treeSet);
        Integer[] array = treeSet.toArray(Integer[]::new);
        System.out.println(array[1]);
        MobileDetails[] array1 = Arrays.stream(sortedArr).filter(arr -> arr.getPrice() == array[1]).toArray(MobileDetails[]::new);
        return array1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MobileDetails[] mobileDetails = new MobileDetails[5];
        for (int i=0;i<5;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            String c=sc.next();
            boolean d=sc.nextBoolean();
            MobileDetails mobileDetails1=new MobileDetails(a,b,c,d);
            mobileDetails[i]=mobileDetails1;
        }
        String brand=sc.next();
        Arrays.stream(mobileDetails).forEach(System.out::println);
        Integer totalPrice = getTotalPrice(mobileDetails, brand);
        if (totalPrice!=null){
            System.out.println(totalPrice);
        }
        else {
            System.out.println("There are no mobile with given brand");
        }
        MobileDetails[] secondMin = getSecondMin(mobileDetails);
        if (secondMin!=null){
            Arrays.stream(secondMin).forEach(mobileDetails1 -> {
                System.out.println(mobileDetails1.getBrand()+" : "+mobileDetails1.getPrice());
            });
        }
    }
}
