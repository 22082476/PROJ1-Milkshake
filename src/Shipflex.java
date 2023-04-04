public class Shipflex {

    private static ScanInput in = new ScanInput();

    private static Company company = new Company("Scheeps werf den haag", "boatstraat", "2000EA", "Den haag", 14);

    public static void main(String[] args) {
        welcomeText();

        while (true) {
            startText();
            int inputIndex = ScanInput.scanInt();

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
                    System.out.println("Incorrecte invoer!");
                    startText();

            }
        }
    }

    public static void welcomeText(){
        //standaard welcome tekst
        System.out.printf("Welcome by shipflex%n");
    }

    public static void startText(){
        System.out.println("Commands: [0]stop, [1]maak offerte, [2]onderhoud");
        System.out.print("Voer een command in: ");
    }

    public static void startMakeQuote(){
        Info.readOptionsFromFile("src/data/options.csv");
        System.out.print("Voer het boot type in: ");
        MakeQuote makeQuote = new MakeQuote(ScanInput.scanInL(), company);
        makeQuote.start();
    }

    public static void startMaintenance(){
//        Maintenance maintenance = new Maintenance();
    }
}
