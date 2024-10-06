package IPA35;

import java.util.Arrays;
import java.util.Scanner;

class Car {
    private int carId;
    private String carName;
    private String fuelType;

    public Car(int carId, String carName, String fuelType) {
        this.carId = carId;
        this.carName = carName;
        this.fuelType = fuelType;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}

public class Ipa35 {
    public static Car[] removeAndRearrange(Car[] cars, int carId) {
        Car[] array = Arrays.stream(cars).filter(car -> car.getCarId() != carId).toArray(Car[]::new);
        int v = array[0].getCarId();

        if (array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                array[i].setCarId(v);
                v += 1;
            }
            return array;

        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Car[] cars=new Car[5];
        for (int i=0;i<5;i++){
            int a=sc.nextInt();
            String b=sc.next();
            String c=sc.next();
            Car car=new Car(a,b,c);
            cars[i]=car;
        }
        int cardId=sc.nextInt();
        Car[] cars1 = removeAndRearrange(cars, cardId);
        Arrays.stream(cars1).forEach(car->{
            System.out.println(car.getCarId()+":"+car.getCarName());
        });
    }
}
