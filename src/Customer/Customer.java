package Customer;

import DataInOut.Printer;

import java.util.HashMap;
import java.util.Map;

public abstract class Customer {
    protected String name;
    protected String street;
    protected int houseNumber;
    protected String postcode;
    protected String city;

    protected String country;

    protected int discount;
    protected HashMap<String, String> extraData;

    public Customer(String name, String street, int houseNumber, String postcode, String city, String country, int discount) {
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.discount = discount;
        this.extraData = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addExtraGegeven(String type, String value) {
        this.extraData.put(type, value);
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public int getDiscount() {
        return discount;
    }

    public String getCountry(){
        return country;
    }

    public void printCustomer(){
        Printer.getInstance().printLine("Naam: " + this.name);
        Printer.getInstance().printLine("Straat: " + this.street);
        Printer.getInstance().printLine("Huisnummer: " + this.houseNumber);
        Printer.getInstance().printLine("Postcode: " + this.postcode);
        Printer.getInstance().printLine("Stad: " + this.street);
        Printer.getInstance().printLine("Land: " + this.country);
        Printer.getInstance().printLine("Kortingpercentage: " + this.discount);

        if(!this.extraData.isEmpty()){
            Printer.getInstance().printLine("Extra gegevens:");
            for (Map.Entry<String, String> entry : extraData.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
