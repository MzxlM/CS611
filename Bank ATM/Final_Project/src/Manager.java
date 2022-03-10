import java.util.List;
import java.util.stream.Collectors;
/**
*@ClassName:Manager
*@Description:A Manager object. It is a subclass of User class. The Manager can apply interest on both loans and deposits.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class Manager extends User {
    private DBSystem db = new DBSystem();
    public Manager(int UID, String name, String userName, String password){
        super(UID, name, userName, password, true);
    }

    //let manager decide when to pay and earn interest.
    // I will only pay interest on savings accounts that have high balances, but I will charge interest on all loans!
    public void applyInterest(){
        //get accounts for all customer
        List<BankAccount> accounts = db.getAccounts(Constants.SELECT_ALL_ACCOUNTS);

        //find accounts that manager should pay for interests.
        List<BankAccount> bankAccounts = accounts.stream().filter(o -> o.getAccountType().equals(Constants.ACCOUNT_TYPE_SAVING))
                .filter(o -> o.getBalance() >= Constants.INTEREST_BALANCE)
                .collect(Collectors.toList());

        //pay the interests.
        for (BankAccount bankAccount : bankAccounts) {
            //update bank accounts on DB
            db.updateAccount(bankAccount.getAccountID(), bankAccount.getBalance()*(1+Constants.INTEREST_RATE));
        }

        //get all loans
        List<Loan> loans = db.getLoans(Constants.SELECT_ALL_ACCOUNTS);

        //charge all loans
        for (Loan loan : loans) {
            db.updateLoan(loan.getId(), loan.getAmount()*(1+Constants.LOAN_RATE));
        }


    }

    //return all accounts from table
    public List<BankAccount> getAllAccounts(){
        return db.getAccounts(Constants.SELECT_ALL_ACCOUNTS);
    }

    //return all transactions from table
    public List<Transaction> getAllTransactions(){
        return db.getTrans(Constants.SELECT_ALL_ACCOUNTS);
    }

    //
    public List<Loan> getAllLoans(){
        return db.getLoans(Constants.SELECT_ALL_ACCOUNTS);
    }


}
