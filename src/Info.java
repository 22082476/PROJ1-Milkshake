import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Info {

    // hier moet nog een customer en company list
    private ArrayList<Option> options;

    Info() {
        this.options = new ArrayList<>();
    }

    public void readOptionsFromFile(String filePath) {

        String line = "";
        boolean isFirstLine = true;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while((line = br.readLine()) != null) {

                if(isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] row = line.split(",");
                String[] essentialBoatTypes = row[4].split(";");

                double price = Double.parseDouble(row[1]);
                boolean environmentDiscount = Boolean.parseBoolean(row[3]);

                if(row.length > 5)
                    addOption(new Option(row[0], price, row[2], environmentDiscount, new ArrayList<String>(List.of(essentialBoatTypes))));
                else
                    addOption(new Option(row[0], price, row[2], environmentDiscount, new ArrayList<String>(List.of(essentialBoatTypes)), row[5]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Option> getOptions() {
        return this.options;
    }

    public void addOption(Option option) {
        this.options.add(option);
    }


}