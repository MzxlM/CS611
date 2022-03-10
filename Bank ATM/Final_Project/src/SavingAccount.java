/**
*@ClassName:SavingAccount
*@Description:A SavingAccount object. It is a subclass of BankAccount class.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class SavingAccount extends BankAccount {

    public SavingAccount(int accountID, int userId, double amount, Currency currency) {
        super(accountID, userId, Constants.ACCOUNT_TYPE_SAVING, amount, currency);
    }

    @Override
    public boolean canClose() {
        return false;
    }
}
