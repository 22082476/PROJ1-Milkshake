import java.util.ArrayList;

public class Maintenance {
    private static ScanInput input = new ScanInput();

    public ArrayList<String> readBoatList(String question) {
        ArrayList boatList = new ArrayList();
        String userinput = MakeQuote.inputQuestion(question);
        if(!userinput.equalsIgnoreCase("stop")) {
            if (!boatList.equals("")) {
                boatList.add(userinput);
                readBoatList(question);
            }
        }
        return boatList;
    }
    public void start(){
        String input;
        input = MakeQuote.inputQuestion(" optie toevoegen of customer type toevoegen");

        if(input.equalsIgnoreCase("optie toevoegen")) {
            Info.addOption(new Option(MakeQuote.inputQuestion("de naam van het onderdeel"),
            MakeQuote.inputNumber("de prijs van het onderdeel"),
            MakeQuote.inputQuestion("soort van onderdeel"),
            MakeQuote.inputNumber("het kortingsperctentage"),
            readBoatList("voor welke soort boten het onderdeel essentieel is"),
            readBoatList("voor welke soort boten het onderdeel optioneel is")));
        }
       // if (input.equalsIgnoreCase("customer type toevoegen")) {
         //   Info.addOption(new Option(askQuestionForStringInput("Wat voor soort klant is het?"),
           // askQuestionForStringInt("Wat is de prijs voor deze klant?"),
            //askQuestionForStringInt("Wat is het kortingspercentage voor dit klanttype?");
            //askQuestionForStringInt();
       // }
    }
    public ArrayList<String> readCustomerType (String question) {
        ArrayList customerType = new ArrayList();
        String userinput = MakeQuote.inputQuestion(question);
        if (!userinput.equalsIgnoreCase("stop")) {
            if (!customerType.equals("")) {
                customerType.add(userinput);
                readCustomerType(question);
            }
        }
        return customerType;
    }
}