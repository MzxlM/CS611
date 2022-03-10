/**
*@ClassName:SecurityAccount
*@Description:A SecurityAccount object. Users can create an security account when they have enough balance in their
 * account.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class SecurityAccount extends BankAccount {

    public SecurityAccount(int accountID, int userId, double amount, Currency currency) {
        super(accountID, userId, Constants.ACCOUNT_TYPE_SECURITY, amount, currency);
    }

    @Override
    public boolean canClose() {
        return false;
    }
}
