package org.example;
import javax.lang.model.type.NullType;
import java.util.Scanner;

public class Main {
    public static Customer customer;

    public static Customer createCustomer() {
        //konsol girdisi okumak için scanner nesnesi oluşturuldu
        Scanner input = new Scanner(System.in);
        int input_int;
        System.out.println("Welcome to Selin's Car Rental");
        System.out.println("Please Login");
        System.out.print("Are you individual or company? : ");
        printEnumNames(Customer.customer_type_enum.class, null);
        input_int = input.nextInt();
        input.nextLine();

        /*input_int değişkenin değeri Customer sınıfının customer_type_enum enumunun
        INDIVIDUAL değeriyle eşit olup olmadığını kontrol eder*/
        if (input_int == Customer.customer_type_enum.INDIVIDUAL.ordinal()) {
            System.out.println("Enter your name: ");
            String name = input.nextLine();
            System.out.println("Enter your surname: ");
            String surname = input.nextLine();
            System.out.println("Enter your phone number: ");
            String phone_number = input.nextLine();
            System.out.println("Enter your identification number: ");
            String id_no = input.nextLine();
            // alınan bilgilerle yeni bir Customer nesnesi oluşturur.
            customer = new Customer(name, surname, phone_number, id_no);
            /*input_int değişkenin değeri Customer sınıfının customer_type_enum enumunun
            COMPANY değeriyle eşit olup olmadığını kontrol eder*/
        } else if (input_int == Customer.customer_type_enum.COMPANY.ordinal()) {
            System.out.println("Enter your name: ");
            String name = input.nextLine();
            System.out.println("Enter your phone number: ");
            String phone_number = input.nextLine();
            System.out.println("Enter your tax number: ");
            String tax_no = input.nextLine();
            // alınan bilgilerle yeni bir Customer nesnesi oluşturur.
            customer = new Customer(name, phone_number, tax_no);
        } else {
            System.out.println("YOU HAVE LOGIN INCORRECTLY");
            return null;
        }
        return customer;
    }

    public static Car createCar(){
        //konsol girdisi okumak için scanner nesnesi oluşturuldu
        Scanner input = new Scanner(System.in);
        int input_int;
        System.out.println("Please select car model");
        printEnumNames(Car.model_enum.class, customer);
        int carmodel = input.nextInt();
        System.out.println("Please select car brand");
        printEnumNames(Car.brand_enum.class, customer);
        int carbrand = input.nextInt();
        System.out.println("Please select gear type");
        printEnumNames(Car.gear_type_enum.class, customer);
        int cargear = input.nextInt();
        System.out.println("Please select luggage capacity");
        printEnumNames(Car.luggage_capacity_enum.class, customer);
        int carluggage = input.nextInt();
        System.out.println("Please select fuel type");
        printEnumNames(Car.fuel_type_enum.class, customer);
        int carfuel = input.nextInt();
        System.out.println("Please select car color");
        printEnumNames(Car.color_enum.class, customer);
        int carcolor = input.nextInt();
        int carrent_day = 0;

        /*customer nesnesinin getCustomer_type() yöntemini çağırır.
        Bu yöntem, müşterinin türünü döndürür.
        Sonra, bu değerin Customer.customer_type_enum.INDIVIDUAL ile eşit olup olmadığını kontrol eder. Eğer eşitse, kodun içindeki blok çalışır.*/
        if (customer.getCustomer_type() == Customer.customer_type_enum.INDIVIDUAL){
            System.out.println("How many days will you rent this vehicle?");
            carrent_day = input.nextInt();
        } else if (customer.getCustomer_type() == Customer.customer_type_enum.COMPANY) {
            System.out.println("Will you rent this car monthly or daily? Daily:0  Monthly:1");
            input_int = input.nextInt();
            if (input_int==0){
                System.out.println("How many days will you rent this vehicle?");
                carrent_day = input.nextInt();
            } else if (input_int==1) {
                System.out.println("How many months will you rent this vehicle?");
                carrent_day = input.nextInt()*30;
            }
        }else{
            System.out.println("YOU HAVE ENTERED INCORRECTLY");
            return null;
        }

        Car car = new Car(Car.brand_enum.values()[carbrand],Car.model_enum.values()[carmodel],Car.gear_type_enum.values()[cargear],
                Car.luggage_capacity_enum.values()[carluggage],Car.color_enum.values()[carcolor],Car.fuel_type_enum.values()[carfuel],
                carrent_day);
        System.out.println("Your bill is :"+ (car.getRent_day()*car.getRent_price()));
        return car;
    }

    // generic type func
    public static <T extends Enum<T>> void printEnumNames(Class<T> enumType, Customer customer) {
        int i = 0;
        for (T enumConstant : enumType.getEnumConstants()) {
            if (customer != null && customer.getCustomer_type() == Customer.customer_type_enum.INDIVIDUAL && enumConstant.name().equals("SUV")) {
                continue;
            }
            System.out.print(enumConstant.name() + ":" + (i++) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        customer = createCustomer();
        Car car = createCar();
        car.displayBill();
    }
}
