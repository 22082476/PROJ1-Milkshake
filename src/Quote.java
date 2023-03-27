public class Quote {
    private Company companyShipbuild;

    private Customer customer;
    private BusinessCustomer businessCustomer;
    private GovermentCustomer govermentCustomer;
    private String Date;
    private String QuoteDate;
    private Boat boat;
    public double CalculateEnvironmentDiscount(Option optie) {
        return optie.getPrice() * optie.getEnvironmentDiscount()/100;
    }

    public Quote(Company companyShipbuild){
        this.companyShipbuild = companyShipbuild;
        this.businessCustomer = null;
        this.customer = null;
        this.govermentCustomer = null;
    }


    public void setCompanyShipbuild(Company companyShipbuild) {
        this.companyShipbuild = companyShipbuild;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBusinessCustomer(BusinessCustomer businessCustomer) {
        this.businessCustomer = businessCustomer;
    }

    public void setGovermentCustomer(GovermentCustomer govermentCustomer) {
        this.govermentCustomer = govermentCustomer;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setQuoteDate(String quoteDate) {
        QuoteDate = quoteDate;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Company getCompanyShipbuild() {
        return companyShipbuild;
    }

    public String getDate() {
        return Date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getQuoteDate() {
        return QuoteDate;
    }

    public Boat getBoat() {
        return boat;
    }

    public void printCustomer(){
        if(govermentCustomer != null){
            govermentCustomer.printCustomer();
        } else if (businessCustomer != null) {
            businessCustomer.printCustomer();
        } else if (customer != null) {
            customer.printCustomer();
        }else {
            System.out.println("Nog geen klant toegevoegd");
            return;
        }
    }
}
