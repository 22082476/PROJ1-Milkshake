package Test_AskCustomer;

import DataInOut.Info;
import Shipflex.Company;
import Shipflex.MakeQuote;
import Shipflex.MakeQuoteCustomer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_AskCustomerGoverment_MakeQuoteCustomer {
    @ParameterizedTest
    @CsvSource({"naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, ministerie, naam, straat, 1, 2589 EJ, Den Haag, Nederland, 0, ministerie,"})
    public void Test_AskCustomerGoverment(String name, String street, int houseNumber, String postcode, String city, String country, int percentage, String ministry, String expectedName, String expectedStreet, int expectedHouseNumber, String expectedPostcode, String expectedCity, String expectedCountry, int expectedDiscount, String expectedMinistryName) throws IOException {
        //Arange
        Info.readOptionsFromFile("src/data/options.csv");
        MakeQuote makequote = new MakeQuote("rubberboot", new Company("", "", 0, "", "", ""));
        MakeQuoteCustomer makequotecustomer = new MakeQuoteCustomer();

        //Act
        String inputData = "overheid\n" + name + "\n" + street + "\n" + houseNumber + "\n" + postcode + "\n" + city + "\n" + country + "\n" + percentage + "\n" + ministry + "\nnee";
        ByteArrayInputStream in = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(in);

        makequotecustomer.askCustomer();

        in.close();

        //Assert
        assertEquals(expectedName, MakeQuote.getQuote().getGovermentCustomer().getName());
        assertEquals(expectedStreet, MakeQuote.getQuote().getGovermentCustomer().getStreet());
        assertEquals(expectedHouseNumber, MakeQuote.getQuote().getGovermentCustomer().getHouseNumber());
        assertEquals(expectedPostcode, MakeQuote.getQuote().getGovermentCustomer().getPostcode());
        assertEquals(expectedCity, MakeQuote.getQuote().getGovermentCustomer().getCity());
        assertEquals(expectedCountry, MakeQuote.getQuote().getGovermentCustomer().getCountry());
        assertEquals(expectedDiscount, MakeQuote.getQuote().getGovermentCustomer().getDiscount());
        assertEquals(expectedMinistryName, MakeQuote.getQuote().getGovermentCustomer().getMinistry());
    }
}
