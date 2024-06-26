package Shipflex;

import Boat.Boat;
import Boat.Option;
import Customer.CustomCustomer;
import Customer.BusinessCustomer;
import Customer.FoundationCustomer;
import Customer.GovermentCustomer;
import DataInOut.Info;
import DataInOut.Printer;

import java.util.ArrayList;
import java.util.List;


public class Quote {
    private Company companyShipbuild;
    private CustomCustomer customCustomer;
    private BusinessCustomer businessCustomer;
    private GovermentCustomer govermentCustomer;
    private FoundationCustomer foundationCustomer;
    private String date;
    private String quoteDate;
    private String about;
    private double workHoursCost;
    private Boat boat;


    public Quote(Company companyShipbuild, Boat boat) {
        this.companyShipbuild = companyShipbuild;
        this.businessCustomer = null;
        this.customCustomer = null;
        this.govermentCustomer = null;
        this.foundationCustomer = null;
        this.boat = boat;
    }

    public void setCustomCustomer(CustomCustomer customCustomer) {
        this.customCustomer = customCustomer;
    }
    public void setBusinessCustomer(BusinessCustomer businessCustomer) {
        this.businessCustomer = businessCustomer;
    }
    public void setGovermentCustomer(GovermentCustomer govermentCustomer) {
        this.govermentCustomer = govermentCustomer;
    }
    public void setFoundationCustomer(FoundationCustomer foundationCustomer) {
        this.foundationCustomer = foundationCustomer;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setQuoteDate(String quoteDate) {
        this.quoteDate = quoteDate;
    }
    public void setBoat(Boat boat) {
        this.boat = boat;
    }
    public Boat getBoat() {
        return boat;
    }

    public CustomCustomer getCustomCustomer() {
        return customCustomer;
    }
    public BusinessCustomer getBusinessCustomer() {
        return businessCustomer;
    }

    public GovermentCustomer getGovermentCustomer() {
        return govermentCustomer;
    }

    public FoundationCustomer getFoundationCustomer() {
        return foundationCustomer;
    }

    public void setWorkHoursCost(double workHoursCost) {
        this.workHoursCost = workHoursCost;
    }

    public void printCustomer() {
        switch (checkCustomerType()) {
            case "goverment":
                govermentCustomer.printCustomer();
                break;
            case "business":
                businessCustomer.printCustomer();
                break;
            case "foundation":
                foundationCustomer.printCustomer();
                break;
            case "customer":
                customCustomer.printCustomer();
                break;
            default:
                Printer.getInstance().printLine("Nog geen klant toegevoegd");
                break;
        }
    }


    private String checkCustomerType() {
        if (govermentCustomer != null) {
            return "goverment";
        } else if (businessCustomer != null) {
            return "business";
        } else if (customCustomer != null) {
            return "customer";
        } else if (foundationCustomer != null) {
            return "foundation";
        } else {
            return "";
        }
    }

    public void printOptions(boolean showIndex) {
        for (Option option : this.boat.getOptions()) {
            if (showIndex)
                Info.printOptionInfo(option, Info.getOptions().indexOf(option));
            else
                Info.printOptionInfo(option, -1);

            Printer.getInstance().emptyLine();
        }
    }


    public void printDate() {
        if (this.date != null && !this.date.equals("")) {
            Printer.getInstance().printLine("Datum: " + this.date);
        } else {
            Printer.getInstance().printLine("Datum nog niet ingevuld");
    }
        if (this.quoteDate != null && !this.quoteDate.equals("")) {
            Printer.getInstance().printLine("Geldigsheid datum: " + this.quoteDate);
        } else {
            Printer.getInstance().printLine("Geldigsheid datum nog niet ingevuld");
        }
    }


    public void printBasicInformation() {
        companyShipbuild.printCompany();
        Printer.getInstance().emptyLine();
        printCustomer();
        Printer.getInstance().emptyLine();
        printDate();
        Printer.getInstance().emptyLine();


        if(this.about != null && !this.about.equals("")) {
            Printer.getInstance().printLine("Betreft: " + this.about);
        }else {
            Printer.getInstance().printLine("Betreft is nog niet ingevuld");

        }
        Printer.getInstance().emptyLine();
    }

    public void printQuote() {
        Printer.getInstance().printCharacters(129, '━');
        Printer.getInstance().emptyLine();
        this.printBasicInformation();
        Printer.getInstance().printCharacters(78, '﹏');
        Printer.getInstance().emptyLine();
        boat.printBoat();
        Printer.getInstance().printCharacters(78, '﹏');
        Printer.getInstance().emptyLine();
        this.printOptions();
        Printer.getInstance().emptyLine();
        this.printTotal();
        Printer.getInstance().emptyLine();
        Printer.getInstance().printCharacters(129, '━');
    }

    public void printOptions() {
        List<Option> essentialOptions = new ArrayList<>();
        List<Option> extraOptions = new ArrayList<>();

        for (Option option : boat.getOptions()) {
            if (option.getEssentialForBoatType().contains(boat.getType().toLowerCase()))
                essentialOptions.add(option);
            else
                extraOptions.add(option);
        }

        printOptionsListFormatted(essentialOptions);
        printOptionsListFormatted(extraOptions);
    }

    private void printOptionsListFormatted(List<Option> options) {
        for (Option option : options) {
            option.printOptionInfoForBoat(boat.getType());
        }
    }

    public int getDiscount() {
        int discount = 0;
        switch (checkCustomerType()) {
            case "goverment":
                discount = govermentCustomer.getDiscount();
                break;
            case "business":
                discount = businessCustomer.getDiscount();
                break;
            case "foundation":
                discount = foundationCustomer.getDiscount();
                break;
            case "customer":
                discount = customCustomer.getDiscount();
                break;
        }
        return 100 - discount;
    }


    public double calculatePercentage(int percentage, double price) {
        return (price / 100) * percentage;
    }

    public double calculateBoatPrice() {
        double price = 0;
        price += boat.getBasePrice();

        for (Option option : boat.getOptions()) {
            price += option.getPrice();
        }

        return price;
    }

    public void printTotal() {
        Printer.getInstance().emptyLine();
        //Totaal prijs boot
        double totalPriceBoat = calculateBoatPrice();
        Printer.getInstance().printFormatInfo(String.format("Totaal prijs boot:"));
        Printer.getInstance().printFormatInfo("");
        Printer.getInstance().printFormatInfo("");
        Printer.getInstance().printFormatInfo(String.format("%.2f", totalPriceBoat));
        Printer.getInstance().emptyLine();

        //Totaal prijs boot met korting
        if (getDiscount() < 100 && getDiscount() > 0) {
            totalPriceBoat = calculatePercentage(getDiscount(), totalPriceBoat);
            Printer.getInstance().printFormatInfo(String.format("Totaal prijs boot met korting:"));
            Printer.getInstance().printFormatInfo("");
            Printer.getInstance().printFormatInfo("");
            Printer.getInstance().printFormatInfo(String.format("%.2f", totalPriceBoat));
            Printer.getInstance().emptyLine();
        }

        //prijs arbeids uren
        Printer.getInstance().emptyLine();
        double workCost = workHoursCost;
        Printer.getInstance().printFormatInfo("Prijs arbeids uren:");
        Printer.getInstance().printFormatInfo("");
        Printer.getInstance().printFormatInfo("");
        Printer.getInstance().printFormatInfo(String.format("%.2f", workCost));
        Printer.getInstance().emptyLine();
        Printer.getInstance().emptyLine();

        //prijs arbeids uren incl
        workCost = calculatePercentage(109, workCost);
        Printer.getInstance().printFormatInfo(String.format("Prijs arbeids uren incl. Btw(9%%):"));
        Printer.getInstance().printFormatInfo("");
        Printer.getInstance().printFormatInfo("");
        Printer.getInstance().printFormatInfo(String.format("%.2f", workCost));
        Printer.getInstance().emptyLine();

        //Totaal prijs boot incl btw
        totalPriceBoat = calculatePercentage(121, totalPriceBoat);
        Printer.getInstance().printFormatInfo(String.format("Totaal prijs boot incl. Btw(21%%):"));
        Printer.getInstance().printFormatInfo("");
        Printer.getInstance().printFormatInfo("");
        Printer.getInstance().printFormatInfo(String.format("%.2f", totalPriceBoat));
        Printer.getInstance().emptyLine();

        //Totaalprijs offerte
        totalPriceBoat += workHoursCost;
        Printer.getInstance().printSpaces(128);
        Printer.getInstance().printCharacters(1,'+');
        Printer.getInstance().emptyLine();
        Printer.getInstance().printFormatInfo(String.format("Totaal prijs offerte:"));
        Printer.getInstance().printFormatInfo("");
        Printer.getInstance().printFormatInfo("");
        Printer.getInstance().printFormatInfo(String.format("%.2f", totalPriceBoat));
    }
}