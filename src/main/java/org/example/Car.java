package org.example;

public class Car {
    public enum brand_enum{FORD,MERCEDES,VOLVO,BMW,TOYOTA}
    public enum model_enum{SEDAN,HATCHBACK,SUV}
    public enum gear_type_enum{AUTOMATIC,MANUEL}
    public enum luggage_capacity_enum{SMALL,MEDIUM,LARGE}
    public enum color_enum{BLACK,WHITE,GRAY,RED}
    public enum fuel_type_enum{DIESEL,LPG,FUEL}

    private String brand;
    private String model;
    private String gear_type;
    private String luggage_capacity;
    private String color;
    private String fuel_type;
    private int rent_day;
    private int rent_price;
    private double discount = 1.0;
    private double totalprice;


    //constructors
    public Car(brand_enum brand, model_enum model, gear_type_enum gear_type,
               luggage_capacity_enum luggage_capacity,color_enum color,
               fuel_type_enum fuel_type, int rent_day){
        this.brand=brand.name();
        this.model=model.name();
        this.color=color.name();
        this.fuel_type=fuel_type.name();
        this.gear_type=gear_type.name();
        this.luggage_capacity=luggage_capacity.name();
        this.rent_day=rent_day;
        switch (model){
            case SEDAN -> rent_price=200;
            case HATCHBACK -> rent_price=100;
            case SUV -> rent_price=300;
        }
        switch (model){
            case SEDAN -> discount=0.97;
            case HATCHBACK -> discount=0.99;
        }
        if(rent_day%30 == 0){
            totalprice = (rent_day*rent_price)*discount;
        }
    }

    //getters
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public String getColor(){
        return color;
    }
    public String getFuel_type(){
        return fuel_type;
    }
    public String getGear_type(){
        return gear_type;
    }
    public String getLuggage_capacity(){
        return luggage_capacity;
    }
    public int getRent_day(){
        return rent_day;
    }
    public int getRent_price(){
        return rent_price;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void displayBill(){
        System.out.println("Car Bill:");
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Color: " + getColor());
        System.out.println("Fuel Type: " + getFuel_type());
        System.out.println("Gear Type: " + getGear_type());
        System.out.println("Luggage Capacity: " + getLuggage_capacity());
        System.out.println("Rental Days: " + getRent_day());
        System.out.println("Rental Price: " + getRent_price());
        System.out.println("Total Price: " + getTotalprice());
    }
}
