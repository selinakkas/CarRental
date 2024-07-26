package org.example;

public class Customer {
    public enum customer_type_enum {INDIVIDUAL,COMPANY}
    private customer_type_enum customer_type;
    private String name;
    private String surname;
    private String id_no;
    private String tax_no;
    private String phone_number;

    //constructors
    //cons. fonk. adı classla aynı olmak zorundadır
    public Customer(String name, String surname, String phone_number, String id_no){
        this.customer_type=customer_type_enum.INDIVIDUAL;
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.id_no = id_no;
    }//ind.customer const.
    public Customer(String name,String phone_number, String tax_no){
        this.customer_type=customer_type_enum.COMPANY;
        this.name = name;
        this.phone_number = phone_number;
        this.id_no = tax_no;
    }//comp.customer const.

    //getters
     public String getName(){
        return name;
     }
    public String getSurname(){
        return surname;
    }
    public String getPhone_number(){
        return phone_number;
    }
    public String getId_no(){
        return id_no;
    }
    public customer_type_enum getCustomer_type(){
        return customer_type;
    }
    public String getTax_no(){
        return tax_no;
    }
}
