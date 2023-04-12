package Shipflex;

import DataInOut.*;

import static DataInOut.ScanInput.inputNumber;


public class Shipflex {
    private static Company company = new Company("Scheeps werf den haag", "boatstraat", "2000 EA", "Den haag","Nederland", 14);

    public static void main(String[] args) {
        Info.readOptionsFromFile("src/data/options.csv");
        welcomeText();
        while (true) {
            startText();
            int inputIndex = inputNumber("een command");
            Printer.getInstance().emptyLine();
            switch (inputIndex) {
                case 0:

                    System.exit(0);
                    break;
                case 1:
                    startMakeQuote();
                    break;
                case 2:
                    startMaintenance();
                    break;
                default:
                    Printer.getInstance().printLine("Incorrecte invoer!");
            }
            Printer.getInstance().emptyLine();
        }
    }

    public static void welcomeText(){
        //standaard welcome tekst
        Printer.getInstance().printLine("Welcome by shipflex");
        Printer.emptyLine();

    }

    public static void startText(){
        Printer.getInstance().printLine("Commands: [0] stop, [1] maak offerte, [2] onderhoud");
    }

    public static void startMakeQuote(){
        MakeQuote makeQuote = new MakeQuote(ScanInput.inputQuestion("het boottype (rubberboot, zeilboot, speedboot, plezierjacht)"), company);
        makeQuote.start();
    }

    public static void startMaintenance(){
        Maintenance maintenance = new Maintenance();
        maintenance.start();
    }
}
