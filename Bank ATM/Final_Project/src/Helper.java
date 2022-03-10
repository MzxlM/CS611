import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
/**
*@ClassName:Helper
*@Description:A Helper object. It helps with the execution of the program.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class Helper {
    public Helper() {
    }

    //convert bank type from int to string
    public String convertTypeToString(int accountType){
        if (accountType == Constants.ACCOUNT_TYPE_CHECKING_INT) {
            return Constants.ACCOUNT_TYPE_CHECKING;
        }
        if (accountType == Constants.ACCOUNT_TYPE_SAVING_INT) {
            return Constants.ACCOUNT_TYPE_SAVING;
        }
        if (accountType == Constants.ACCOUNT_TYPE_SECURITY_INT) {
            return Constants.ACCOUNT_TYPE_SECURITY;
        }
        return null;
    }
    //convert bank type from String to int
    public Integer convertTypeToInt(String accountType){
        if (accountType == Constants.ACCOUNT_TYPE_CHECKING) {
            return Constants.ACCOUNT_TYPE_CHECKING_INT;
        }
        if (accountType == Constants.ACCOUNT_TYPE_SAVING) {
            return Constants.ACCOUNT_TYPE_SAVING_INT;
        }
        if (accountType == Constants.ACCOUNT_TYPE_SECURITY) {
            return Constants.ACCOUNT_TYPE_SECURITY_INT;
        }
        return null;
    }

    //convert currency from currency type
    public Currency convertCurrencyFromString(String currency){
        CurrencyList currencyList = new CurrencyList();
        List<Currency> collect = currencyList.getCurrencies().stream().filter(o -> o.getCode().equals(currency)).collect(Collectors.toList());
        return collect.get(0);
    }

    //create account object
    public BankAccount createAccountObject(int id, int userId, String accountType, double initialAmount, Currency currency) {
        BankAccount newBankAccount;
        if (accountType.equals(Constants.ACCOUNT_TYPE_CHECKING)) {
            newBankAccount = new CheckingAccount(id, userId, initialAmount, currency);

        } else if (accountType.equals(Constants.ACCOUNT_TYPE_SAVING)){
            newBankAccount = new SavingAccount(id, userId, initialAmount, currency);

        } else if (accountType.equals(Constants.ACCOUNT_TYPE_SECURITY)) {
            newBankAccount = new SecurityAccount(id, userId, initialAmount, currency);
        } else {
            System.out.println("DB create account error due to account type");
            newBankAccount = null;
        }
        return newBankAccount;
    }

    public Boolean currencyCheck(String currency) {
        for (String s : Constants.CURRENCY_CODE) {
            if (s.equals(currency)) return true;
        }
        return false;
    }

    public static boolean isInt(String s){
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static String getRoundTwoDigits(Double value){
        DecimalFormat df = new DecimalFormat("#.00");
        String str = df.format(value);
        return str;
    }

}
