package localTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class isNumeric {

    public boolean isNumber(String s){
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @DataProvider(name = "Strings")
    public Object[][] strings() {
        return new Object[][]
                {
                        {"lkjlkjsnlgksd'dfkg;klnl34058734-591=49v8-0 7"},
                        {"3 9  0"},
                        {null},
                        {"!!!"},
                        {"8798902365205762309873495873498620937237342095439"},
                        {"1.2"},
                };
    }

    @DataProvider(name = "Numbers")
    public Object[][] numbers() {
        return new Object[][]
                {
                        {"123"},
                        {"-28"}
                };
    }

    @Test (dataProvider = "Strings")
    public void NegativeTest(String input){
        Assert.assertFalse(isNumber(input));
    }

    @Test (dataProvider = "Numbers")
    public void PositiveTest(String input){
        Assert.assertTrue(isNumber(input));
    }
}
