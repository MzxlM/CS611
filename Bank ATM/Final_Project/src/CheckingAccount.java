/**
*@ClassName:CheckingAccount
*@Description:A CheckingAccount object. It is the subclass of BankAccount.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class CheckingAccount extends BankAccount {

    public CheckingAccount(int accountID, int userId, double amount, Currency currency) {
        super(accountID, userId, Constants.ACCOUNT_TYPE_CHECKING, amount, currency);
    }

    @Override
    public boolean canClose() {
        return false;
    }
}
