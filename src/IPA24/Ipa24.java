package IPA24;

import java.util.Arrays;
import java.util.Scanner;

class Inventory{
    private String inventoryId;
    private int maximumQuantity;
    private int currentQuantity;
    private int threshold;

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold) {
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId='" + inventoryId + '\'' +
                ", maximumQuantity=" + maximumQuantity +
                ", currentQuantity=" + currentQuantity +
                ", threshold=" + threshold +
                '}';
    }
}
public class Ipa24 {
    public static Inventory[] replenish(Inventory[] inventories, int limit){
        Inventory[] array = Arrays.stream(inventories).filter(inventory -> inventory.getThreshold() <= limit).toArray(Inventory[]::new);
        return array;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Inventory[] inventories=new Inventory[4];
        for (int i=0;i<4;i++){
            String a=sc.next();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int d=sc.nextInt();
            Inventory inventory=new Inventory(a,b,c,d);
            inventories[i]=inventory;
        }
        int limit=sc.nextInt();
        Arrays.stream(inventories).forEach(inventory -> {
            System.out.println(inventory.toString());
        });
        Inventory[] replenish = replenish(inventories, limit);
        Arrays.stream(replenish).forEach(inventory -> {
            if (inventory.getThreshold()>75){
                System.out.println(inventory.getInventoryId()+" Critical Filling");
            }
            else if (inventory.getThreshold()>=50 && inventory.getThreshold()<=75){
                System.out.println(inventory.getInventoryId()+" Moderate Filling");
            }
            else {
                System.out.println(inventory.getInventoryId()+" Non-Critical Filling");
            }
        });


    }
}
