package IPA40;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

class Car{
    private String make;
    private String model;
    private int year;
    private double price;

    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
public class Ipa40 {
    public static Car findMostExpensiveCar(Car[] cars) {
        Optional<Car>car=Arrays.stream(cars)
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .findFirst();
        return car.orElse(null);

    }
    public static Car getCarByMakeAndModel(Car[]cars, String make, String model){
        Optional<Car> carByMakeAndModel = Arrays.stream(cars)
                .filter(car -> car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model))
                .findFirst();
        return carByMakeAndModel.orElse(null);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Car[] cars=new Car[4];
        for(int i=0;i<4;i++){
            cars[i]=new Car(sc.nextLine(),sc.nextLine(),Integer.parseInt(sc.nextLine()),Double.parseDouble(sc.nextLine()));
        }
        String make=sc.nextLine();
        String model=sc.nextLine();
        Car mostExpensiveCar = findMostExpensiveCar(cars);
        if(mostExpensiveCar!=null){
            System.out.println(mostExpensiveCar.getMake());
            System.out.println(mostExpensiveCar.getModel());
            System.out.println(mostExpensiveCar.getYear());
            System.out.println(mostExpensiveCar.getPrice());
        }
        else {
            System.out.println("Sorry - No car is available");
        }
        Car carByMakeAndModel = getCarByMakeAndModel(cars, make, model);
        if(carByMakeAndModel!=null){
            System.out.println(carByMakeAndModel.getYear());
            System.out.println(carByMakeAndModel.getPrice());
        }
        else {
            System.out.println("Sorry - No car is available");
        }
    }
}
