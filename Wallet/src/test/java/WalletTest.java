import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WalletTest {
    @Test
    public void test1DollarIsEqualTo74_85Rupees() {
        boolean actualValue;
        boolean expectedValue = true;
        String currencyType1 = "Dollar";
        String currencyType2 = "Rupees";
        double currencyValue1 = 1;
        double currencyValue2 = 74.85;
        Currency dollar = new Currency(currencyType1,currencyValue1);
        Currency rupees = new Currency(currencyType2,currencyValue2);

        actualValue = WalletFunctionality.compareDollarWithRupees(dollar,rupees);

        assertEquals(expectedValue,actualValue);

    }

    @Test
    public void test1XDollarIsEqualTo74_85XRupees() {
        boolean actualValue;
        boolean expectedValue  = true;
        String currencyType1 = "Dollar";
        String currencyType2 = "Rupees";
        double currencyValue1 = 3;
        double currencyValue2 = 74.85*3;
        Currency dollar = new Currency(currencyType1,currencyValue1);
        Currency rupees = new Currency(currencyType2,currencyValue2);

        actualValue = WalletFunctionality.compareDollarWithRupees(dollar,rupees);

        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testForReturningTotalBalanceAfterDepositingCurrencyAsDollar() {
        double actualValue;
        double expectedValue = 5;
        String preferredCurrency = "Dollars";
        String currencyType1 = "Dollar";
        String currencyType2 = "Rupees";
        String currencyType3 = "Dollar";
        double currencyValue1 = 3;
        double currencyValue2 = 74.85;
        double currencyValue3 = 1;
        Currency dollar = new Currency(currencyType1,currencyValue1);
        Currency rupees = new Currency(currencyType2,currencyValue2);
        WalletFunctionality.depositCurrency(currencyType3, currencyValue3, dollar, rupees);

        actualValue = WalletFunctionality.returnTotalBalance(preferredCurrency, dollar, rupees);

        assertEquals(expectedValue, actualValue, 0.00001);
    }
    @Test
    public void testForReturningTotalBalanceAfterDepositingCurrencyAsRupees() {
        double actualValue;
        double expectedValue = 4;
        String preferredCurrency = "Dollars";
        String currencyType1 = "Dollar";
        String currencyType2 = "Rupees";
        String currencyType3 = "Rupees";
        double currencyValue1 = 1;
        double currencyValue2 = 74.85;
        double currencyValue3 = 149.7;
        Currency dollar = new Currency(currencyType1,currencyValue1);
        Currency rupees = new Currency(currencyType2,currencyValue2);
        WalletFunctionality.depositCurrency(currencyType3, currencyValue3, dollar, rupees);

        actualValue = WalletFunctionality.returnTotalBalance(preferredCurrency, dollar, rupees);

        assertEquals(expectedValue, actualValue, 0.00001);
    }

    @Test
    public void testForReturningTotalBalanceWhenPreferredCurrencyIsRupees() {
        double actualValue;
        double expectedValue = 299.40;
        String preferredCurrency = "Rupees";
        String currencyType1 = "Dollar";
        String currencyType2 = "Rupees";
        double currencyValue1 = 3;
        double currencyValue2 = 74.85;
        Currency dollar = new Currency(currencyType1,currencyValue1);
        Currency rupees = new Currency(currencyType2,currencyValue2);

        actualValue = WalletFunctionality.returnTotalBalance(preferredCurrency, dollar, rupees);

        assertEquals(expectedValue, actualValue, 0.00001);
    }

    @Test
    public void testForReturningTotalBalanceWhenPreferredCurrencyIsDollars() {
        double actualValue;
        double expectedValue = 4;
        String preferredCurrency = "Dollars";
        String currencyType1 = "Dollar";
        String currencyType2 = "Rupees";
        double currencyValue1 = 3;
        double currencyValue2 = 74.85;
        Currency dollar = new Currency(currencyType1,currencyValue1);
        Currency rupees = new Currency(currencyType2,currencyValue2);

        actualValue = WalletFunctionality.returnTotalBalance(preferredCurrency, dollar, rupees);

        assertEquals(expectedValue, actualValue, 0.00001);
    }

    @Test
    public void testForWithdrawingCurrencyInDollarsWithSufficientBalance() {
        double expectedValue = 4;
        String preferredCurrency = "Dollars";
        double withdrawAmount = 1;
        String currencyType1 = "Dollar";
        String currencyType2 = "Rupees";
        double currencyValue1 = 5;
        double currencyValue2 = 74.85;
        Currency dollar = new Currency(currencyType1,currencyValue1);
        Currency rupees = new Currency(currencyType2,currencyValue2);

        WalletFunctionality.withdrawCurrency(preferredCurrency,withdrawAmount,dollar,rupees);

        assertEquals(expectedValue,dollar.getCurrencyValue());
    }
    @Test
    public void testForWithdrawingCurrencyInRupeesWithSufficientBalance() {
        double expectedValue = 0;
        String preferredCurrency = "Rupees";
        double withdrawAmount = 74.85;
        String currencyType1 = "Dollar";
        String currencyType2 = "Rupees";
        double currencyValue1 = 5;
        double currencyValue2 = 74.85;
        Currency dollar = new Currency(currencyType1,currencyValue1);
        Currency rupees = new Currency(currencyType2,currencyValue2);

        WalletFunctionality.withdrawCurrency(preferredCurrency,withdrawAmount,dollar,rupees);

        assertEquals(expectedValue,rupees.getCurrencyValue());
    }

    @Test
    public void testForWithdrawingCurrencyInDollarsWithInsufficientBalance() {
        double expectedValue = 74.85;
        String preferredCurrency = "Dollars";
        double withdrawAmount = 6;
        String currencyType1 = "Dollar";
        String currencyType2 = "Rupees";
        double currencyValue1 = 5;
        double currencyValue2 = 149.70;
        Currency dollar = new Currency(currencyType1,currencyValue1);
        Currency rupees = new Currency(currencyType2,currencyValue2);

        WalletFunctionality.withdrawCurrency(preferredCurrency,withdrawAmount,dollar,rupees);

        assertEquals(expectedValue,rupees.getCurrencyValue());
    }

    @Test
    public void testForWithdrawingCurrencyInRupeesWithInsufficientBalance() {
        double expectedValue = 4;
        String preferredCurrency = "Rupees";
        double withdrawAmount = 224.55;
        String currencyType1 = "Dollar";
        String currencyType2 = "Rupees";
        double currencyValue1 = 5;
        double currencyValue2 = 149.70;
        Currency dollar = new Currency(currencyType1,currencyValue1);
        Currency rupees = new Currency(currencyType2,currencyValue2);

        WalletFunctionality.withdrawCurrency(preferredCurrency,withdrawAmount,dollar,rupees);

        assertEquals(expectedValue,dollar.getCurrencyValue());
    }
}
