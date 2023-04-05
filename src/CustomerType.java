import java.util.HashMap;
import java.util.Map;

class   Customer {
    protected String name;
    protected String street;
    protected String postcode;
    protected String city;
    protected int houseNumber;
    protected int discount;
    protected HashMap<String, String> extraGegevens;

    public Customer(String name, String street, String postcode, String city, int houseNumber, int discount) {
        this.name = name;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.houseNumber = houseNumber;
        this.discount = discount;
        this.extraGegevens = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getDiscount() {
        return discount;
    }

    public void addExtraGegeven(String type, String value) {
        this.extraGegevens.put(type, value);
    }

    public void printCustomer(){
        Printer.printLine("Naam: " + this.name);
        Printer.printLine("Straat: " + this.street);
        Printer.printLine("Postcode: " + this.postcode);
        Printer.printLine("Stad: " + this.street);
        Printer.printLine("Huisnummer: " + this.houseNumber);
        Printer.printLine("Kortingpercentage: " + this.discount);

        if(!this.extraGegevens.isEmpty()){
            Printer.printLine("Extra gegevens:");
            for (Map.Entry<String, String> entry : extraGegevens.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}

class BusinessCustomer extends Customer{
    // class company moet nog aangemaakt worden
    private String companyname;



    public BusinessCustomer(String name, String street, String postcode, String city, int houseNumber, int discount, String companyname){
        super(name,street,postcode,city,houseNumber,discount);
        this.companyname = companyname;

    }

    public String getCompany() {
        return companyname;
    }

    public void setCompany(String companyname) {
        this.companyname = companyname;
    }

    @Override
    public void printCustomer(){
        Printer.printLine("Bedrijfsnaam: " + this.companyname);
        super.printCustomer();
    }
}

class GovermentCustomer extends Customer {

    private String ministry;

    public GovermentCustomer (String name, String street, String postcode, String city, int houseNumber, int discount ,String ministry){
        super(name, street, postcode, city, houseNumber,discount);
        this.ministry = ministry;
    }

    public String getMinisty() {
        return ministry;
    }

    public void setMinisty(String ministy) {
        this.ministry = ministy;
    }

    @Override
    public void printCustomer(){
        Printer.printLine("Ministerie: " + this.ministry);
        super.printCustomer();
    }
}

class FoundationCustomer extends Customer {

    private String foundation;

    public FoundationCustomer (String name, String street, String postcode, String city, int houseNumber, int discount, String foundation){
        super(name, street, postcode, city, houseNumber,discount);
        this.foundation = foundation;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    @Override
    public void printCustomer(){
        super.printCustomer();
        Printer.printLine("Stichting: " + this.foundation);
    }
}
